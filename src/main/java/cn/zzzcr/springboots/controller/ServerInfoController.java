package cn.zzzcr.springboots.controller;

import cn.zzzcr.springboots.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class ServerInfoController {

    @Autowired
    private WebSocketService webSocketService;


    @Scheduled(fixedRate = 3000)
    public void sendServerInfo(){
        webSocketService.sendServerInfo();
    }
}
