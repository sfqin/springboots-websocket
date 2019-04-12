package cn.zzzcr.springboots.service;

import cn.zzzcr.springboots.model.InMessage;
import cn.zzzcr.springboots.model.OutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void sendTopicMsg(String dest, InMessage inMessage){

        messagingTemplate.convertAndSend(dest,new OutMessage(inMessage.getContent()));
    }

    public void sendChatMsg(InMessage inMessage){
        messagingTemplate.convertAndSend("/chat/single/"+ inMessage.getTo(),
                new OutMessage(inMessage.getFrom() +" 发送：" + inMessage.getContent()));
    }

}
