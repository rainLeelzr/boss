package com.rain.boss.perm.entity;

import com.rain.boss.baseClass.entity.BaseEntity;

//用户岗位关系
public class UserPosition extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id:
     */
    private java.lang.String userId;

    /**
     * 岗位Id:
     */
    private java.lang.String positionId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    @Override
    public String toString() {
        return "UserPosition{" +
                "userId:'" + userId + '\'' +
                ", positionId:'" + positionId + '\'' +
                '}';
    }
}