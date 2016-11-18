package com.rain.boss.perm.service;

import com.rain.boss.AbstractTestClass;
import com.rain.boss.perm.entity.DataPermGroup;
import com.rain.boss.perm.mapper.DataPermGroupMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DataPermGroupServiceTest extends AbstractTestClass<DataPermGroup, DataPermGroupMapper, DataPermGroupService> {

    public DataPermGroup genEntity() {
        DataPermGroup entity = new DataPermGroup();
        entity.genId();
        entity.setDataPermSetId(RandomStringUtils.randomNumeric(60));
        entity.setGroupType((byte) RandomUtils.nextInt(1, 5));
        entity.setGroupName(RandomStringUtils.randomNumeric(60));
        entity.setParentId(RandomStringUtils.randomNumeric(60));
        entity.setDataPermRelationship(RandomStringUtils.randomNumeric(60));
        entity.setOrderNum(RandomUtils.nextInt(0, 2));
        entity.setEnabled((byte) RandomUtils.nextInt(0, 2));
        entity.setRemark(RandomStringUtils.randomNumeric(60));
        return entity;
    }

}
