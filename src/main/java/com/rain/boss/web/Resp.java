package com.rain.boss.web;

public class Resp {
    //业务操作成功为true，失败为false
    private boolean success;

    //业务操作成功为1，失败为0，其他为自定义
    private int code;

    //业务操作结果描述
    private String message;

    //业务操作得到的数据
    private Object data;

    private Resp() {

    }

    public static Resp success(){
        Resp d = new Resp();
        d.setSuccess(true);
        d.setCode(Message.success.getCode());
        d.setMessage(Message.success.getMessage());
        return d;
    }

    public static Resp success(Object data) {
        Resp d = new Resp();
        d.setSuccess(true);
        d.setCode(Message.success.getCode());
        d.setMessage(Message.success.getMessage());
        d.setData(data);
        return d;
    }

    public static Resp success(Message message, Object data) {
        Resp d = new Resp();
        d.setSuccess(true);
        d.setCode(message.getCode());
        d.setMessage(message.getMessage());
        d.setData(data);
        return d;
    }

    public static Resp fail() {
        Resp d = new Resp();
        d.setSuccess(false);
        d.setCode(Message.success.getCode());
        d.setMessage(Message.success.getMessage());
        return d;
    }

    public static Resp fail(Object data) {
        Resp d = new Resp();
        d.setSuccess(false);
        d.setCode(Message.success.getCode());
        d.setMessage(Message.success.getMessage());
        d.setData(data);
        return d;
    }

    public static Resp fail(Message message, Object data) {
        Resp d = new Resp();
        d.setSuccess(false);
        d.setCode(message.getCode());
        d.setMessage(message.getMessage());
        d.setData(data);
        return d;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RespData{" +
                "success:" + success +
                ", code:" + code +
                ", message:'" + message + '\'' +
                ", data:" + data +
                '}';
    }
}
