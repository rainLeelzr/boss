package com.rain.boss.base.entity;

import com.rain.boss.baseClass.entity.BaseEntity;

import java.sql.Timestamp;

public class RequestLog extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 客户端ip:
     */
    private String clientIp;

    /**
     * 请求时间:
     */
    private Timestamp requestTime;

    /**
     * 响应时间:
     */
    private Timestamp responseTime;

    /**
     * 请求方法:
     */
    private String reqMethod;

    /**
     * 请求路径:
     */
    private String reqUri;

    /**
     * 请求参数:
     */
    private String reqParam;

    /**
     * 响应内容:
     */
    private String responseText;

    /**
     * 用户代理:
     */
    private String userAgent;

    /**
     * 请求结果:
     */
    private String reqResult;

    /**
     * 用户id:
     */
    private String userId;

    /**
     * 用户名:
     */
    private String userName;

    /**
     * 机构id:
     */
    private String orgId;

    /**
     * 机构名:
     */
    private String orgName;

    /**
     * 备注:
     */
    private String remark;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public Timestamp getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Timestamp requestTime) {
        this.requestTime = requestTime;
    }

    public Timestamp getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Timestamp responseTime) {
        this.responseTime = responseTime;
    }

    public String getReqMethod() {
        return reqMethod;
    }

    public void setReqMethod(String reqMethod) {
        this.reqMethod = reqMethod;
    }

    public String getReqUri() {
        return reqUri;
    }

    public void setReqUri(String reqUri) {
        this.reqUri = reqUri;
    }

    public String getReqParam() {
        return reqParam;
    }

    public void setReqParam(String reqParam) {
        this.reqParam = reqParam;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getReqResult() {
        return reqResult;
    }

    public void setReqResult(String reqResult) {
        this.reqResult = reqResult;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "RequestLog{" +
                "clientIp='" + clientIp + '\'' +
                ", requestTime=" + requestTime +
                ", responseTime=" + responseTime +
                ", reqMethod='" + reqMethod + '\'' +
                ", reqUri='" + reqUri + '\'' +
                ", reqParam='" + reqParam + '\'' +
                ", responseText='" + responseText + '\'' +
                ", userAgent='" + userAgent + '\'' +
                ", reqResult='" + reqResult + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", orgId='" + orgId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}