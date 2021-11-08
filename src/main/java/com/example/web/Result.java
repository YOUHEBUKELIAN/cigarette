package com.example.web;

public class Result {
    // 状态码  0不成功，100是成功
    private int code;
    // 描述信息
    private String message;
    // 真正的返回数据
    private Object data;

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result() {
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
