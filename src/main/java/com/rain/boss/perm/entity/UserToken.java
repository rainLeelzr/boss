package com.rain.boss.perm.entity;

import com.rain.boss.baseClass.entity.BaseEntity;

//用户岗位_令牌
public class UserToken extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户岗位id:
     */
    private String userId;

    /**
     * 令牌:
     */
    private String token;

    /**
     * 令牌生成时间:
     */
    private String tokenCreateTime;

    /**
     * 令牌过期时间:
     */
    private Long tokenExpireTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenCreateTime() {
        return tokenCreateTime;
    }

    public void setTokenCreateTime(String tokenCreateTime) {
        this.tokenCreateTime = tokenCreateTime;
    }

    public Long getTokenExpireTime() {
        return tokenExpireTime;
    }

    public void setTokenExpireTime(Long tokenExpireTime) {
        this.tokenExpireTime = tokenExpireTime;
    }

    @Override
    public String toString() {
        return "UserToken{" +
                "userId:'" + userId + '\'' +
                ", token:'" + token + '\'' +
                ", tokenCreateTime:'" + tokenCreateTime + '\'' +
                ", tokenExpireTime:'" + tokenExpireTime + '\'' +
                '}';
    }
}