package com.rain.boss.perm.entity;

import com.rain.boss.BaseEntity;

public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 父id:
     */
    private String parentId;

    /**
     * 角色名:
     */
    private String roleName;

    /**
     * 角色类型:
     */
    private Byte roleType;

    /**
     * 启用:
     */
    private Byte enabled;

    /**
     * 备注:
     */
    private String remark;

    public Byte getRoleType() {
        return roleType;
    }

    public void setRoleType(Byte roleType) {
        this.roleType = roleType;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public boolean isEnable() {
        return enabled == (byte) 1;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id:'" + id + '\'' +
                ", parentId:'" + parentId + '\'' +
                ", roleName:'" + roleName + '\'' +
                ", roleType:" + roleType +
                ", enabled:" + enabled +
                ", remark:'" + remark + '\'' +
                '}';
    }
}