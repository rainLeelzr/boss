package com.rain.boss.perm.dto;

/**
 * Created by Administrator on 2016/12/19.
 */
public class Token {
    private String userId;

    private long expireTime;

    private String userAgent;

    public Token() {
    }

    public Token(String userId, long expireTime, String userAgent) {
        this.userId = userId;
        this.expireTime = expireTime;
        this.userAgent = userAgent;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

}
