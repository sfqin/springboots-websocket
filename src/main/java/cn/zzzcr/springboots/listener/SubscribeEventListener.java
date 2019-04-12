package cn.zzzcr.springboots.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

@Component
public class SubscribeEventListener implements ApplicationListener<SessionSubscribeEvent> {


    @Override
    public void onApplicationEvent(SessionSubscribeEvent sessionSubscribeEvent) {
        StompHeaderAccessor wrap = StompHeaderAccessor.wrap(sessionSubscribeEvent.getMessage());

        System.out.println("SubscribeEventListener.onApplicationEvent 监听订阅topic事件 ==> "+wrap.getCommand().getMessageType());
    }
}
