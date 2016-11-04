package com.rain.boss.perm.entity;

import com.rain.boss.BaseEntity;

//功能权限
public class OrgPosition extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**机构部门id:*/
    private String orgId;

    /**岗位id:*/
    private String positionId;

    public String getOrgId(){
        return orgId;
    }

    public void setOrgId(String orgId){
        this.orgId = orgId;
    }

    public String getPositionId(){
        return positionId;
    }

    public void setPositionId(String positionId){
        this.positionId = positionId;
    }

    @Override
    public String toString() {
        return "OrgPosition{" +
                "orgId:'" + orgId + '\'' +
                ", positionId:'" + positionId + '\'' +
                '}';
    }
}