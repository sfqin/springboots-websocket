package cn.zzzcr.springboots.controller;

import cn.zzzcr.springboots.model.InMessage;
import cn.zzzcr.springboots.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SingleChatContoller {

    @Autowired
    private WebSocketService webSocketService;

    @MessageMapping("/v3/single/chat")
    public void singleChat(InMessage inMessage){

        webSocketService.sendChatMsg(inMessage);
    }

}
