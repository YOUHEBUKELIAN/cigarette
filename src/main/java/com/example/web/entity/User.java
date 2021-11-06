package com.example.web.entity;

public class User {
    private int uid;
    private String tele;
    private String password;
    private int type;
    private String uname;

    public User(int uid, String tele, String password, int type, String uname) {
        this.uid = uid;
        this.tele = tele;
        this.password = password;
        this.type = type;
        this.uname = uname;
    }

    public int getUid() {
        return uid;
    }

    public String getTele() {
        return tele;
    }

    public String getPassword() {
        return password;
    }

    public int getType() {
        return type;
    }

    public String getUname() {
        return uname;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
