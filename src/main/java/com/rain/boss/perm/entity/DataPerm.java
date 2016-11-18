package com.rain.boss.perm.entity;

import com.rain.boss.baseClass.entity.BaseEntity;

//功能权限
public class DataPerm extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 数据权限分组Id:
     */
    private String dataPermGroupId;

    /**
     * 字段资源Id:
     */
    private String fieldResourceId;

    /**
     * 字段资源是否主表:
     */
    private Byte isMainTable;

    /**
     * 数据权限类型:
     */
    private Byte funPermType;

    /**
     * 运算符:
     */
    private String operatorSymbol;

    /**
     * 运算值:
     */
    private String operatorValue;

    /**
     * 分组号:
     */
    private Byte groupNum;

    /**
     * 顺序:
     */
    private Integer orderNum;

    /**
     * 启用:
     */
    private Byte enabled;

    /**
     * 备注:
     */
    private String remark;

    public String getDataPermGroupId() {
        return dataPermGroupId;
    }

    public void setDataPermGroupId(String dataPermGroupId) {
        this.dataPermGroupId = dataPermGroupId;
    }

    public String getFieldResourceId() {
        return fieldResourceId;
    }

    public void setFieldResourceId(String fieldResourceId) {
        this.fieldResourceId = fieldResourceId;
    }

    public Byte getIsMainTable() {
        return isMainTable;
    }

    public void setIsMainTable(Byte isMainTable) {
        this.isMainTable = isMainTable;
    }

    public Byte getFunPermType() {
        return funPermType;
    }

    public void setFunPermType(Byte funPermType) {
        this.funPermType = funPermType;
    }

    public String getOperatorSymbol() {
        return operatorSymbol;
    }

    public void setOperatorSymbol(String operatorSymbol) {
        this.operatorSymbol = operatorSymbol;
    }

    public String getOperatorValue() {
        return operatorValue;
    }

    public void setOperatorValue(String operatorValue) {
        this.operatorValue = operatorValue;
    }

    public Byte getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(Byte groupNum) {
        this.groupNum = groupNum;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Byte getEnabled() {
        return enabled;
    }

    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "DataPerm{" +
                "dataPermGroupId:'" + dataPermGroupId + '\'' +
                ", fieldResourceId:'" + fieldResourceId + '\'' +
                ", isMainTable:" + isMainTable +
                ", funPermType:" + funPermType +
                ", operatorSymbol:'" + operatorSymbol + '\'' +
                ", operatorValue:'" + operatorValue + '\'' +
                ", groupNum:" + groupNum +
                ", orderNum:" + orderNum +
                ", enabled:" + enabled +
                ", remark:'" + remark + '\'' +
                '}';
    }
}