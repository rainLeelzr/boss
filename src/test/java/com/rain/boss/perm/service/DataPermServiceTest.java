package com.rain.boss.perm.service;

import com.rain.boss.AbstractTestClass;
import com.rain.boss.perm.entity.DataPerm;
import com.rain.boss.perm.mapper.DataPermMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DataPermServiceTest extends AbstractTestClass<DataPerm, DataPermMapper, DataPermService> {

    public DataPerm genEntity() {
        DataPerm entity = new DataPerm();
        entity.genId();
        entity.setDataPermGroupId(RandomStringUtils.randomNumeric(6));
        entity.setFieldResourceId(RandomStringUtils.randomNumeric(6));
        entity.setIsMainTable((byte) RandomUtils.nextInt(0, 2));
        entity.setFunPermType((byte) RandomUtils.nextInt(0, 2));
        entity.setOperatorSymbol(RandomStringUtils.randomNumeric(6));
        entity.setOperatorValue(RandomStringUtils.randomNumeric(6));
        entity.setGroupNum((byte) RandomUtils.nextInt(0, 2));
        entity.setOrderNum(RandomUtils.nextInt(1, 5));
        entity.setEnabled((byte) RandomUtils.nextInt(0, 2));
        entity.setRemark(RandomStringUtils.randomNumeric(60));
        return entity;
    }

}
