package com.rain.boss.perm.entity;

import com.rain.boss.BaseEntity;

//功能权限
public class DataPermSet extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 岗位功能权限关系Id:
     */
    private String positionFunPermId;

    /**
     * 集名:
     */
    private String setName;


    /**
     * 集内权限分组关系:
     */
    private String groupRelationship;

    /**
     * 启用:
     */
    private Byte enabled;

    /**
     * 备注:
     */
    private String remark;

    public String getPositionFunPermId() {
        return positionFunPermId;
    }

    public void setPositionFunPermId(String positionFunPermId) {
        this.positionFunPermId = positionFunPermId;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getGroupRelationship() {
        return groupRelationship;
    }

    public void setGroupRelationship(String groupRelationship) {
        this.groupRelationship = groupRelationship;
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
        return "DataPermSet{" +
                "positionFunPermId:'" + positionFunPermId + '\'' +
                ", setName:'" + setName + '\'' +
                ", groupRelationship:'" + groupRelationship + '\'' +
                ", enabled:" + enabled +
                ", remark:'" + remark + '\'' +
                '}';
    }
}