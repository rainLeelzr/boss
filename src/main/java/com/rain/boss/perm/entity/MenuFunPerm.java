package com.rain.boss.perm.entity;

import com.rain.boss.BaseEntity;

//功能权限
public class MenuFunPerm extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单id:
     */
    private String menuId;

    /**
     * 功能id:
     */
    private String funPermId;


    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getFunPermId() {
        return funPermId;
    }

    public void setFunPermId(String funPermId) {
        this.funPermId = funPermId;
    }

    @Override
    public String toString() {
        return "MenuFunPerm{" +
                "menuId:'" + menuId + '\'' +
                ", funPermId:'" + funPermId + '\'' +
                '}';
    }
}