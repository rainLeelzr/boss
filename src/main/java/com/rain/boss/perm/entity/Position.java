package com.rain.boss.perm.entity;

import com.rain.boss.BaseEntity;

//功能权限
public class Position extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**代码:*/
    private String code;

    /**岗位名:*/
    private String positionName;

    /**岗位类型:*/
    private Byte positionType;

    /**部门层级路由:*/
    private String route;

    /**启用:*/
    private Byte enabled;

    /**备注:*/
    private String remark;

    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getPositionName(){
        return positionName;
    }

    public void setPositionName(String positionName){
        this.positionName = positionName;
    }

    public Byte getPositionType(){
        return positionType;
    }

    public void setPositionType(Byte positionType){
        this.positionType = positionType;
    }

    public String getRoute(){
        return route;
    }

    public void setRoute(String route){
        this.route = route;
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
        return "Position{" +
                "code:'" + code + '\'' +
                ", positionName:'" + positionName + '\'' +
                ", positionType:" + positionType +
                ", route:'" + route + '\'' +
                ", enabled:" + enabled +
                ", remark:'" + remark + '\'' +
                '}';
    }
}