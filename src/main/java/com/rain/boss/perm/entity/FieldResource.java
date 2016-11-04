package com.rain.boss.perm.entity;

import com.rain.boss.BaseEntity;

//功能权限
public class FieldResource extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**表资源Id:*/
    private String tableResourceId;

    /**字段名:*/
    private String fieldName;

    /**字段数据类型:*/
    private Byte fieldDataType;

    /**字段值类型:*/
    private Byte fieldValueType;

    /**备注:*/
    private String remark;

    public String getTableResourceId(){
        return tableResourceId;
    }

    public void setTableResourceId(String tableResourceId){
        this.tableResourceId = tableResourceId;
    }

    public String getFieldName(){
        return fieldName;
    }

    public void setFieldName(String fieldName){
        this.fieldName = fieldName;
    }

    public Byte getFieldDataType(){
        return fieldDataType;
    }

    public void setFieldDataType(Byte fieldDataType){
        this.fieldDataType = fieldDataType;
    }

    @Override
    public String toString() {
        return "FieldResource{" +
                "tableResourceId:'" + tableResourceId + '\'' +
                ", fieldName:'" + fieldName + '\'' +
                ", fieldDataType:" + fieldDataType +
                ", fieldValueType:" + fieldValueType +
                ", remark:'" + remark + '\'' +
                '}';
    }

    public Byte getFieldValueType(){
        return fieldValueType;
    }

    public void setFieldValueType(Byte fieldValueType){
        this.fieldValueType = fieldValueType;
    }

    public String getRemark(){
        return remark;
    }

    public void setRemark(String remark){
        this.remark = remark;
    }
}