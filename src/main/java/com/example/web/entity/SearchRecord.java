package com.example.web.entity;

public class SearchRecord {
    private int sid;
    private String cname;
    private int times;

    public SearchRecord(int sid, String cname, int times) {
        this.sid = sid;
        this.cname = cname;
        this.times = times;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }
}
