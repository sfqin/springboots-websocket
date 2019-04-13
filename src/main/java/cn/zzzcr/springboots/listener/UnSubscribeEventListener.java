package cn.zzzcr.springboots.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionUnsubscribeEvent;

//@Component
public class UnSubscribeEventListener implements ApplicationListener<SessionUnsubscribeEvent> {


    @Override
    public void onApplicationEvent(SessionUnsubscribeEvent sessionUnsubscribeEvent) {
        StompHeaderAccessor wrap = StompHeaderAccessor.wrap(sessionUnsubscribeEvent.getMessage());
        System.out.println("UnSubscribeEventListener.onApplicationEvent 监听 unSubscribe 事件 ==> " + wrap.getCommand().getMessageType());
    }
}
