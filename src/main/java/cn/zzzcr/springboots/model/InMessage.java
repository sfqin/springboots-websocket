package cn.zzzcr.springboots.model;

import java.util.Date;

public class InMessage {

    private String from;

    private String to;

    private String content;

    private Date time;

    public String getFrom() {
        return from;
    }


    public InMessage(){}

    public InMessage(String content) {
        this.content = content;
    }



    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}
