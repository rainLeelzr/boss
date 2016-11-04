package com.rain.boss.web;

public enum Message {
    success(1, "操作成功"), fail(0, "操作失败");

    private int code;

    private String message;

    Message(int code, String message) {
        this.message = message;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


}
