package com.rain.boss.perm.entity;

import com.rain.boss.BaseEntity;

//功能权限
public class DataPermGroup extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**数据权限集id:*/
    private String dataPermSetId;

    /**分组类型:*/
    private Byte groupType;

    /**组名:*/
    private String groupName;

    /**父数据权限组id:*/
    private String parentId;

    /**组内数据权限关系:*/
    private String dataPermRelationship;

    /**顺序:*/
    private Integer orderNum;

    /**启用:*/
    private Byte enabled;

    /**备注:*/
    private String remark;

    public String getDataPermSetId(){
        return dataPermSetId;
    }

    public void setDataPermSetId(String dataPermSetId){
        this.dataPermSetId = dataPermSetId;
    }

    public Byte getGroupType(){
        return groupType;
    }

    public void setGroupType(Byte groupType){
        this.groupType = groupType;
    }

    public String getGroupName(){
        return groupName;
    }

    public void setGroupName(String groupName){
        this.groupName = groupName;
    }

    public String getParentId(){
        return parentId;
    }

    public void setParentId(String parentId){
        this.parentId = parentId;
    }

    public String getDataPermRelationship(){
        return dataPermRelationship;
    }

    public void setDataPermRelationship(String dataPermRelationship){
        this.dataPermRelationship = dataPermRelationship;
    }

    public Integer getOrderNum(){
        return orderNum;
    }

    public void setOrderNum(Integer orderNum){
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "DataPermGroup{" +
                "dataPermSetId:'" + dataPermSetId + '\'' +
                ", groupType:" + groupType +
                ", groupName:'" + groupName + '\'' +
                ", parentId:'" + parentId + '\'' +
                ", dataPermRelationship:'" + dataPermRelationship + '\'' +
                ", orderNum:" + orderNum +
                ", enabled:" + enabled +
                ", remark:'" + remark + '\'' +
                '}';
    }

    public Byte getEnabled(){
        return enabled;
    }

    public void setEnabled(Byte enabled){
        this.enabled = enabled;
    }

    public String getRemark(){
        return remark;
    }

    public void setRemark(String remark){
        this.remark = remark;
    }
}