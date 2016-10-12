package com.rain.boss.perm.entity;

import com.rain.boss.BaseEntity;

public class UserRole extends BaseEntity {

	private static final long serialVersionUID = 1L;

    /**
     * 主键:
     */
    private java.lang.String id;

    /**
     * 用户id:
     */
    private java.lang.String userId;

    /**
     * 角色id:
     */
    private java.lang.String roleId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id:'" + id + '\'' +
                ", userId:'" + userId + '\'' +
                ", roleId:'" + roleId + '\'' +
                '}';
    }
}