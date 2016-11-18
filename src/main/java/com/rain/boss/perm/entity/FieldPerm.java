package com.rain.boss.perm.entity;

import com.rain.boss.baseClass.entity.BaseEntity;

//功能权限
public class FieldPerm extends BaseEntity {

    private static final long serialVersionUID = 1L;

   /**岗位功能权限关系id:*/
    private String positionFunPermId;

    /**字段资源Id:*/
    private String fieldResourceId;

    /**字段资源是否主表:*/
    private Byte isMainTable;

    /**是否显示:*/
    private Byte isShow;

    /**顺序:*/
    private Integer orderNum;

    /**启用:*/
    private Byte enabled;

    /**备注:*/
    private String remark;

    public String getPositionFunPermId(){
        return positionFunPermId;
    }

    public void setPositionFunPermId(String positionFunPermId){
        this.positionFunPermId = positionFunPermId;
    }

    public String getFieldResourceId(){
        return fieldResourceId;
    }

    public void setFieldResourceId(String fieldResourceId){
        this.fieldResourceId = fieldResourceId;
    }

    public Byte getIsMainTable(){
        return isMainTable;
    }

    public void setIsMainTable(Byte isMainTable){
        this.isMainTable = isMainTable;
    }

    public Byte getIsShow(){
        return isShow;
    }

    public void setIsShow(Byte isShow){
        this.isShow = isShow;
    }

    @Override
    public String toString() {
        return "FieldPerm{" +
                "positionFunPermId:'" + positionFunPermId + '\'' +
                ", fieldResourceId:'" + fieldResourceId + '\'' +
                ", isMainTable:" + isMainTable +
                ", isShow:" + isShow +
                ", orderNum:" + orderNum +
                ", enabled:" + enabled +
                ", remark:'" + remark + '\'' +
                '}';
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
}