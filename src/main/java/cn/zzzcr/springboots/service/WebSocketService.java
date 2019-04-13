package cn.zzzcr.springboots.service;

import cn.zzzcr.springboots.model.ChartUser;
import cn.zzzcr.springboots.model.InMessage;
import cn.zzzcr.springboots.model.OutMessage;
import cn.zzzcr.springboots.model.StockInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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


    public void sendServerInfo(){

        int availableProcessors = Runtime.getRuntime().availableProcessors();

        long freeMemory = Runtime.getRuntime().freeMemory();

        long freeMemoryM =  freeMemory/1024/1024;

        long maxMemory = Runtime.getRuntime().maxMemory();

        long maxMemoryM = maxMemory/1024/1024;

        String message = String.format("服务器可用处理器：%s, 空闲内存为：%sM, 最大内存为：%sM",availableProcessors,freeMemoryM,maxMemoryM);

        messagingTemplate.convertAndSend("/topic/server_info",new OutMessage(message));
    }

    public void sendStockInfo(StockInfo stockInfo){

        messagingTemplate.convertAndSend("/topic/stock_info",stockInfo);
    }


    public void sendOnlineUser(Map<String,ChartUser> onlineUser){
        List<String> userNames = onlineUser.values().stream().
                map(ChartUser::getUserName).collect(Collectors.toList());
        messagingTemplate.convertAndSend("/topic/onlineuser",userNames);
    }

    public void sendMyName(String myName){

        messagingTemplate.convertAndSend("/topic/myName",myName);
    }

    public void sendTopicChat(InMessage message){

        OutMessage outMessage = new OutMessage();
        outMessage.setFrom(message.getFrom());
        outMessage.setContent(message.getContent());
        messagingTemplate.convertAndSend("/topic/chat",outMessage);
    }

}
