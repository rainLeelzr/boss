package com.rain.boss.perm.service;

import com.rain.boss.AbstractTestClass;
import com.rain.boss.perm.entity.DataPermSet;
import com.rain.boss.perm.mapper.DataPermSetMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DataPermSetServiceTest extends AbstractTestClass<DataPermSet, DataPermSetMapper, DataPermSetService> {

    public DataPermSet genEntity() {
        DataPermSet entity = new DataPermSet();
        entity.genId();
        entity.setPositionFunPermId(RandomStringUtils.randomNumeric(60));
        entity.setSetName(RandomStringUtils.randomNumeric(60));
        entity.setGroupRelationship(RandomStringUtils.randomNumeric(60));
        entity.setEnabled((byte) RandomUtils.nextInt(0, 2));
        entity.setRemark(RandomStringUtils.randomNumeric(60));
        return entity;
    }

}
