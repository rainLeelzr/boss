package com.rain.boss.web;

public enum Message {
    //全局信息
    success(1, "操作成功"),
    fail(0, "操作失败"),
    sysException(4, "系统异常，请稍后再试！"),

    //权限信息
    unLogin(2, "未登录系统"),
    accountOrPwdError(3, "用户名或密码错误"),
    loginTimeout(5, "登录超时，请重新登录！");

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
