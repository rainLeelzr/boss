package com.rain.boss.perm.service;

import com.rain.boss.AbstractTestClass;
import com.rain.boss.perm.entity.FieldResource;
import com.rain.boss.perm.mapper.FieldResourceMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FieldResourceServiceTest extends AbstractTestClass<FieldResource, FieldResourceMapper,
        FieldResourceService> {

    public FieldResource genEntity() {
        FieldResource entity = new FieldResource();
        entity.genId();
        entity.setTableResourceId(RandomStringUtils.randomNumeric(60));
        entity.setFieldName(RandomStringUtils.randomNumeric(60));
        entity.setFieldDataType((byte) RandomUtils.nextInt(1, 5));
        entity.setFieldValueType((byte) RandomUtils.nextInt(1, 5));
        entity.setRemark(RandomStringUtils.randomNumeric(60));
        return entity;
    }

}
