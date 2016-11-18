package com.rain.boss.perm.entity;

import com.rain.boss.baseClass.entity.BaseEntity;

//功能权限
public class Org extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**父id:*/
    private String parentId;

    /**机构部门名:*/
    private String orgName;

    /**机构部门简称:*/
    private String orgNickName;

    /**机构部门类型:*/
    private Byte orgType;

    /**机构部门地址:*/
    private String address;

    /**联系方式:*/
    private String contact;

    /**顺序:*/
    private Integer orderNum;

    /**启用:*/
    private Byte enabled;

    /**备注:*/
    private String remark;

    public String getParentId(){
        return parentId;
    }

    public void setParentId(String parentId){
        this.parentId = parentId;
    }

    public String getOrgName(){
        return orgName;
    }

    public void setOrgName(String orgName){
        this.orgName = orgName;
    }

    public String getOrgNickName(){
        return orgNickName;
    }

    public void setOrgNickName(String orgNickName){
        this.orgNickName = orgNickName;
    }

    public Byte getOrgType(){
        return orgType;
    }

    public void setOrgType(Byte orgType){
        this.orgType = orgType;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getContact(){
        return contact;
    }

    public void setContact(String contact){
        this.contact = contact;
    }

    public Integer getOrderNum(){
        return orderNum;
    }

    public void setOrderNum(Integer orderNum){
        this.orderNum = orderNum;
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

    @Override
    public String toString() {
        return "Org{" +
                "parentId:'" + parentId + '\'' +
                ", orgName:'" + orgName + '\'' +
                ", orgNickName:'" + orgNickName + '\'' +
                ", orgType:" + orgType +
                ", address:'" + address + '\'' +
                ", contact:'" + contact + '\'' +
                ", orderNum:" + orderNum +
                ", enabled:" + enabled +
                ", remark:'" + remark + '\'' +
                '}';
    }
}