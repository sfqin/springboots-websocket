package cn.zzzcr.springboots.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;

@Component
public class ConnectEventListener implements ApplicationListener<SessionConnectEvent> {

    @Override
    public void onApplicationEvent(SessionConnectEvent sessionConnectEvent) {
        StompHeaderAccessor wrap = StompHeaderAccessor.wrap(sessionConnectEvent.getMessage());

        System.out.println("ConnectEventListener.onApplicationEvent 监听建立connect事件 ==> " + wrap.getCommand().getMessageType());
    }
}
