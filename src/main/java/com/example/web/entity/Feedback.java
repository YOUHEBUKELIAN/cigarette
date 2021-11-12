package com.example.web.entity;

public class Feedback {
    private int id;
    private String picUrl;
    private String name;
    private int type;
    private int uid;
    private String description;
    private int status;
    private String amail;

    public Feedback(){

    }
    public Feedback(int id, String picUrl, String name, int type, int uid, String description, int status, String amail) {
        this.id = id;
        this.picUrl = picUrl;
        this.name = name;
        this.type = type;
        this.uid = uid;
        this.description = description;
        this.status = status;
        this.amail = amail;
    }

    public int getFid() {
        return id;
    }

    public void setFid(int fid) {
        this.id = fid;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getCname() {
        return name;
    }

    public void setCname(String cname) {
        this.name = cname;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTxt() {
        return description;
    }

    public void setTxt(String txt) {
        this.description = txt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSid() {
        return amail;
    }

    public void setSid(String sid) {
        this.amail = sid;
    }
}
