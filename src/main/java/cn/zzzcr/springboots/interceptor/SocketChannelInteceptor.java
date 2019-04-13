package cn.zzzcr.springboots.interceptor;

import cn.zzzcr.springboots.controller.MutiChatController;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;

public class SocketChannelInteceptor implements ChannelInterceptor {


    /**
     * 在消息被直接发送到频道之前调用
     * @param message
     * @param channel
     * @return
     */
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        System.out.println("SocketChannelInteceptor.preSend");
        return message;
    }

    /**
     * 在消息被发送之后调用
     * @param message
     * @param channel
     * @param sent
     */
    @Override
    public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
        System.out.println("SocketChannelInteceptor.postSend");
        StompHeaderAccessor wrap = StompHeaderAccessor.wrap(message);
        if(wrap.getCommand() == null){
            return;
        }
        String sessionId = wrap.getSessionAttributes().get("sessionId").toString();
        System.out.println("SocketChannelInteceptor.postSend => sessionId=" + sessionId);

        switch (wrap.getCommand()){
            case CONNECT:
                System.out.println("connect sessionId="+sessionId);
                break;
            case DISCONNECT:
                System.out.println("disconnect sessionId="+sessionId);
                //用户下线操作
                MutiChatController.onlineUser.remove(sessionId);
            case SUBSCRIBE:
                break;
            case UNSUBSCRIBE:
                break;
            default:
                break;
        }
    }

    /**
     * 在完成发送后调用，不管是否有异常发生，一般用于资源清理
     * @param message
     * @param channel
     * @param sent
     * @param ex
     */
    @Override
    public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
        System.out.println("SocketChannelInteceptor.afterSendCompletion");
    }
}
