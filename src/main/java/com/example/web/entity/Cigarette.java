package com.example.web.entity;

public class Cigarette {
    private int id;
    private String picUrl;
    private String name;
    private int type;

    public Cigarette(int cid, String picUrl, String cname, int type) {
        this.id = cid;
        this.picUrl = picUrl;
        this.name = cname;
        this.type = type;
    }

    public int getCid() {
        return id;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getCname() {
        return name;
    }

    public int getType() {
        return type;
    }

    public void setCid(int cid) {
        this.id = cid;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setCname(String cname) {
        this.name = cname;
    }

    public void setType(int type) {
        this.type = type;
    }
}
