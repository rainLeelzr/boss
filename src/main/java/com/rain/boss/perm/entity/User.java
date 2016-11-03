package com.rain.boss.perm.entity;

import com.rain.boss.BaseEntity;

public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 账号:
     */
    private String userAccount;

    /**
     * 密码:
     */
    private String userPwd;

    /**
     * 姓名:
     */
    private String userName;

    /**
     * 性别:
     */
    private Byte gender;

    /**
     * qq:
     */
    private String qq;

    private String telephone;

    /**
     * 手机:
     */
    private String mobilePhone;

    /**
     * 电子邮箱:
     */
    private String email;

    private Byte enabled;

    /**
     * 备注:
     */
    private String remark;

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Byte getEnabled() {
        return enabled;
    }

    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User: {id: \"" + id + "\", userAccount: \"" + userAccount
                + "\", userPwd: \"" + userPwd + "\", userName: \"" + userName
                + "\", gender: \"" + gender + "\", qq: \"" + qq
                + "\", telephone: \"" + telephone + "\", mobilePhone: \""
                + mobilePhone + "\", email: \"" + email + "\", enabled: \""
                + enabled + "\", remark: \"" + remark + "\"}";
    }

}