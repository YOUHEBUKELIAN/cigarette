package com.example.web.entity;

public class Feedback {
    private int fid;
    private String picUrl;
    private String cname;
    private int type;
    private int uid;
    private String txt;
    private int status;
    private int sid;

    public Feedback(int fid, String picUrl, String cname, int type, int uid, String txt, int status, int sid) {
        this.fid = fid;
        this.picUrl = picUrl;
        this.cname = cname;
        this.type = type;
        this.uid = uid;
        this.txt = txt;
        this.status = status;
        this.sid = sid;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
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
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
}
