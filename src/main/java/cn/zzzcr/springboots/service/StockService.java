package cn.zzzcr.springboots.service;

import cn.zzzcr.springboots.model.StockInfo;
import cn.zzzcr.springboots.utils.HttpUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

@Service
public class StockService {



    public StockInfo stockData(){
        //API产品路径
        String host = "http://istock.market.alicloudapi.com";
        String path = "/ai_fintech_knowledge/ai_stock_trade_market";
        String method = "GET";
        //阿里云APPCODE
        String appcode = "2947dcb607df4d8cb1cf913b6ef5d2b3";
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<>();
        //参数配置
        //结束时间，如：20180808
        querys.put("END_TIME", "20190412");
        //开始时间，如：20180808
        querys.put("START_TIME", "20190412");
        //上市公司代码，如：600744
        querys.put("STOCK_CODE", "601398");

        try {

            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
//            System.out.println("股票响应：=> " + response.toString());
//            //获取response的body
//            System.out.println("股票数据 => " + EntityUtils.toString(response.getEntity()));

            JSONObject jsonObject = JSONObject.parseObject(EntityUtils.toString(response.getEntity()));

            StockInfo stockInfo = new StockInfo();

            stockInfo.setStockCode(jsonObject.getString("STOCK_CODE"));
            stockInfo.setStockNameCH(jsonObject.getString("STOCK_NAME_CH"));
            JSONArray stock_trade_entity = jsonObject.getJSONArray("STOCK_TRADE_ENTITY");
            JSONObject jsonObject1 = stock_trade_entity.getJSONObject(0);
            stockInfo.setTime(jsonObject1.getString("TIME"));
            stockInfo.setClosePrice(jsonObject1.getString("CLOSE"));
            stockInfo.setMaxPrice(jsonObject1.getString("HIGH"));
            stockInfo.setMinPrice(jsonObject1.getString("LOW"));
            stockInfo.setOpenPrice(jsonObject1.getString("OPEN"));
            stockInfo.setLastDayClosePrice(jsonObject1.getString("PRE_CLOSE"));
            stockInfo.setVolume(jsonObject1.getString("VOLUME"));
            stockInfo.setTurnover(jsonObject1.getString("TURNOVER"));
            stockInfo.setUpdown(jsonObject1.getString("UPDOWN"));
            stockInfo.setUpdownPer(jsonObject1.getString("UPDOWN_PER"));

            return stockInfo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void companyData(){
        //API产品路径
        String host = "http://istock.market.alicloudapi.com";
        String path = "/ai_fintech_knowledge/ai_stock_code";
        String method = "GET";
        //阿里云APPCODE
        String appcode = "2947dcb607df4d8cb1cf913b6ef5d2b3";
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<>();

        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);

            System.out.println("公司数据 => " + EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
