package cn.zzzcr.springboots.controller;

import cn.zzzcr.springboots.model.ChartUser;
import cn.zzzcr.springboots.model.InMessage;
import cn.zzzcr.springboots.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MutiChatController {

    @Autowired
    private WebSocketService webSocketService;


    public static Map<String, String> userMap = new HashMap<String, String>();
    static{
        userMap.put("jack", "123");
        userMap.put("mary", "456");
        userMap.put("tom", "789");
        userMap.put("tim", "000");
        userMap.put("小D", "666");
    }


    public static Map<String, ChartUser> onlineUser = new HashMap<>();
    static{
        onlineUser.put("123",new ChartUser("admin","888"));
    }

    @PostMapping("login")
    public String userLogin(@RequestParam(value = "useranme",required = true) String useranme,
                            @RequestParam(value = "password",required = true) String password,
                            HttpSession session){

        if(password.equals(userMap.get(useranme))){
            ChartUser chartUser = new ChartUser(useranme, password);
            String sessionId = session.getId();
            onlineUser.put(sessionId,chartUser);
            return "redirect:/chats/chat.html";
        }else {
            return "redirect:/chats/error.html";
        }
    }

    @Scheduled(fixedRate = 1000)
    public void onlineUser(){
        webSocketService.sendOnlineUser(onlineUser);
    }

    @Scheduled(fixedRate = 1000)
    public void myName(){

    }

    @MessageMapping("/v6/chat")
    public void topicChart(InMessage inMessage, SimpMessageHeaderAccessor headerAccessor){
        String sessionId = headerAccessor.getSessionAttributes().get("sessionId").toString();
        ChartUser chartUser = onlineUser.get(sessionId);
        inMessage.setFrom(chartUser.getUserName());
        webSocketService.sendTopicChat(inMessage);
    }

}
