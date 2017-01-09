package com.rain.boss.perm.entity;

import com.rain.boss.baseClass.entity.BaseEntity;

//功能权限
public class Menu extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 父id:
     */
    private String parentId;

    /**
     * 菜单名:
     */
    private String menuName;

    /**
     * 主机ip:
     */
    private String ip;

    /**
     * 菜单链接:
     */
    private String menuUrl;

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

    @Override
    public String toString() {
        return "Menu{" +
                "parentId='" + parentId + '\'' +
                ", menuName='" + menuName + '\'' +
                ", ip=" + ip +
                ", menuUrl='" + menuUrl + '\'' +
                ", orderNum=" + orderNum +
                ", enabled=" + enabled +
                ", remark='" + remark + '\'' +
                '}';
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}