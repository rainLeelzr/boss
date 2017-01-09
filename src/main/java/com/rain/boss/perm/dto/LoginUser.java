package com.rain.boss.perm.dto;

import com.rain.boss.perm.entity.User;
import com.rain.boss.perm.entity.UserToken;

public class LoginUser {
    //user
    private String userId;
    private String userAccount;
    private String userName;
    private int gender;
    private String qq;
    private String telephone;
    private String mobilePhone;
    private String email;

    //userToken
    private String token;

    public LoginUser() {

    }

    public LoginUser(User user, String token) {
        this.userId = user.getId();
        this.userAccount = user.getUserAccount();
        this.userName = user.getUserName();
        this.gender = user.getGender();
        this.qq = user.getQq();
        this.telephone = user.getTelephone();
        this.mobilePhone = user.getMobilePhone();
        this.email = user.getEmail();

        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
