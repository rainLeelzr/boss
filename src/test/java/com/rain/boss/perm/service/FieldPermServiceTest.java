package com.rain.boss.perm.service;

import com.rain.boss.AbstractTestClass;
import com.rain.boss.perm.entity.FieldPerm;
import com.rain.boss.perm.mapper.FieldPermMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FieldPermServiceTest extends AbstractTestClass<FieldPerm, FieldPermMapper, FieldPermService> {

    public FieldPerm genEntity() {
        FieldPerm entity = new FieldPerm();
        entity.genId();
        entity.setPositionFunPermId(RandomStringUtils.randomNumeric(60));
        entity.setFieldResourceId(RandomStringUtils.randomNumeric(60));
        entity.setIsMainTable((byte) RandomUtils.nextInt(1, 5));
        entity.setIsShow((byte) RandomUtils.nextInt(1, 5));
        entity.setOrderNum(RandomUtils.nextInt(1, 5));
        entity.setEnabled((byte) RandomUtils.nextInt(0, 2));
        entity.setRemark(RandomStringUtils.randomNumeric(60));
        return entity;
    }

}
