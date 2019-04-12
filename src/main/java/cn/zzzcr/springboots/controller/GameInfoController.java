package cn.zzzcr.springboots.controller;

import cn.zzzcr.springboots.model.InMessage;
import cn.zzzcr.springboots.model.OutMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GameInfoController {

    @MessageMapping("/v1/chat")
    @SendTo("/topic/game_chat")
    public OutMessage gameInfo(InMessage message){
        return new OutMessage(message.getContent());
    }
}
