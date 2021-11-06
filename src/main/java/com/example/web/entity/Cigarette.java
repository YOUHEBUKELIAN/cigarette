package com.example.web.entity;

public class Cigarette {
    private int cid;
    private String picUrl;
    private String cname;
    private int type;

    public Cigarette(int cid, String picUrl, String cname, int type) {
        this.cid = cid;
        this.picUrl = picUrl;
        this.cname = cname;
        this.type = type;
    }

    public int getCid() {
        return cid;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getCname() {
        return cname;
    }

    public int getType() {
        return type;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setType(int type) {
        this.type = type;
    }
}
