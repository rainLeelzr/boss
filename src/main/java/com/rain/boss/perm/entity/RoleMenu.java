package com.rain.boss.perm.entity;

import com.rain.boss.BaseEntity;

public class RoleMenu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**角色id:*/
    private String roleId;

    /**菜单id:*/
    private String menuId;

    public String getRoleId(){
        return roleId;
    }

    public void setRoleId(String roleId){
        this.roleId = roleId;
    }

    public String getMenuId(){
        return menuId;
    }

    public void setMenuId(String menuId){
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "RoleMenu{" +
                "roleId:'" + roleId + '\'' +
                ", menuId:'" + menuId + '\'' +
                '}';
    }
}