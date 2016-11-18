package com.rain.boss.perm.entity;

import com.rain.boss.baseClass.entity.BaseEntity;

//功能权限
public class TableResource extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**表名:*/
    private String tableName;

    /**表别名:*/
    private String nickName;

    /**备注:*/
    private String remark;

    public String getTableName(){
        return tableName;
    }

    public void setTableName(String tableName){
        this.tableName = tableName;
    }

    public String getNickName(){
        return nickName;
    }

    public void setNickName(String nickName){
        this.nickName = nickName;
    }

    public String getRemark(){
        return remark;
    }

    public void setRemark(String remark){
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "TableResource{" +
                "tableName:'" + tableName + '\'' +
                ", nickName:'" + nickName + '\'' +
                ", remark:'" + remark + '\'' +
                '}';
    }
}