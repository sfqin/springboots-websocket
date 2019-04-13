package cn.zzzcr.springboots.model;

public class StockInfo {

    private String stockCode;

    private String stockNameCH;

    private String time;

    private String closePrice;

    private String maxPrice;

    private String minPrice;

    private String openPrice;

    private String lastDayClosePrice;

    private String volume;

    private String turnover;

    private String updown;

    private String updownPer;

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockNameCH() {
        return stockNameCH;
    }

    public void setStockNameCH(String stockNameCH) {
        this.stockNameCH = stockNameCH;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(String closePrice) {
        this.closePrice = closePrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(String openPrice) {
        this.openPrice = openPrice;
    }

    public String getLastDayClosePrice() {
        return lastDayClosePrice;
    }

    public void setLastDayClosePrice(String lastDayClosePrice) {
        this.lastDayClosePrice = lastDayClosePrice;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getTurnover() {
        return turnover;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }

    public String getUpdown() {
        return updown;
    }

    public void setUpdown(String updown) {
        this.updown = updown;
    }

    public String getUpdownPer() {
        return updownPer;
    }

    public void setUpdownPer(String updownPer) {
        this.updownPer = updownPer;
    }
}
