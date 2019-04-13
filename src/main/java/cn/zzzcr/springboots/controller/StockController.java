package cn.zzzcr.springboots.controller;

import cn.zzzcr.springboots.model.StockInfo;
import cn.zzzcr.springboots.service.StockService;
import cn.zzzcr.springboots.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class StockController {


    @Autowired
    private StockService stockService;

    @Autowired
    private WebSocketService webSocketService;

//    @Scheduled(fixedRate = 2000)
    private void stockInfo(){
        StockInfo stockInfo = stockService.stockData();
        webSocketService.sendStockInfo(stockInfo);
    }

}
