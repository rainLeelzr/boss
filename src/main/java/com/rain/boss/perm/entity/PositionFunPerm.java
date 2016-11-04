package com.rain.boss.perm.entity;

import com.rain.boss.BaseEntity;

//功能权限
public class PositionFunPerm extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**岗位id:*/
    private String positionId;

    /**功能id:*/
    private String funPermId;

    public String getPositionId(){
        return positionId;
    }

    public void setPositionId(String positionId){
        this.positionId = positionId;
    }

    public String getFunPermId(){
        return funPermId;
    }

    public void setFunPermId(String funPermId){
        this.funPermId = funPermId;
    }

    @Override
    public String toString() {
        return "PositionFunPerm{" +
                "positionId:'" + positionId + '\'' +
                ", funPermId:'" + funPermId + '\'' +
                '}';
    }
}