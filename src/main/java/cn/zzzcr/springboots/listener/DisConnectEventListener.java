package cn.zzzcr.springboots.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

//@Component
public class DisConnectEventListener implements ApplicationListener<SessionDisconnectEvent> {


    @Override
    public void onApplicationEvent(SessionDisconnectEvent sessionDisconnectEvent) {
        StompHeaderAccessor wrap = StompHeaderAccessor.wrap(sessionDisconnectEvent.getMessage());
        System.out.println("DisConnectEventListener.onApplicationEvent 监听 disconnect事件 ==> "+ wrap.getCommand().getMessageType());
    }
}
