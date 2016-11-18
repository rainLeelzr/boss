package com.rain.boss.perm.entity;

import com.rain.boss.baseClass.entity.BaseEntity;

//功能权限
public class PositionFunPermDataPermSet extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**岗位功能权限id:*/
    private String positionFunPermId;

    /**数据权限集id:*/
    private String dataPermSetId;

    public String getPositionFunPermId(){
        return positionFunPermId;
    }

    public void setPositionFunPermId(String positionFunPermId){
        this.positionFunPermId = positionFunPermId;
    }

    public String getDataPermSetId(){
        return dataPermSetId;
    }

    public void setDataPermSetId(String dataPermSetId){
        this.dataPermSetId = dataPermSetId;
    }

    @Override
    public String toString() {
        return "PositionFunPermDataPermSet{" +
                "positionFunPermId:'" + positionFunPermId + '\'' +
                ", dataPermSetId:'" + dataPermSetId + '\'' +
                '}';
    }
}