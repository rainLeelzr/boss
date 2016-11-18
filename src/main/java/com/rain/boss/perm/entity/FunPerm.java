package com.rain.boss.perm.entity;

import com.rain.boss.baseClass.entity.BaseEntity;

//功能权限
public class FunPerm extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 功能名:
     */
    private java.lang.String funPermName;

    /**
     * 功能类型:
     */
    private Byte funPermType;

    /**
     * 功能链接:
     */
    private java.lang.String funPermUrl;

    /**
     * 启用:
     */
    private Byte enabled;

    /**
     * 备注:
     */
    private java.lang.String remark;

    public String getFunPermName() {
        return funPermName;
    }

    public void setFunPermName(String funPermName) {
        this.funPermName = funPermName;
    }

    public Byte getFunPermType() {
        return funPermType;
    }

    public void setFunPermType(Byte funPermType) {
        this.funPermType = funPermType;
    }

    public String getFunPermUrl() {
        return funPermUrl;
    }

    public void setFunPermUrl(String funPermUrl) {
        this.funPermUrl = funPermUrl;
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
        return "FunPerm{" +
                "funPermName:'" + funPermName + '\'' +
                ", funPermType:'" + funPermType + '\'' +
                ", funPermUrl:'" + funPermUrl + '\'' +
                ", enabled:'" + enabled + '\'' +
                ", remark:'" + remark + '\'' +
                '}';
    }
}