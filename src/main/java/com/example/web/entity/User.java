package com.example.web.entity;

public class User {
    private int id;
    private String mail;
    private String password;
    private int type;


    public User() {
    }

    public User(int id, String mail, String password) {
        this.id = id;
        this.mail = mail;
        this.password = password;
        this.type = 0;
    }

    public int getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public int getType() {
        return type;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(int type) {
        this.type = type;
    }


}
