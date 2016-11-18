package com.rain.boss.perm.service;

import com.rain.boss.AbstractTestClass;
import com.rain.boss.perm.entity.PositionFunPerm;
import com.rain.boss.perm.mapper.PositionFunPermMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PositionFunPermServiceTest extends AbstractTestClass<PositionFunPerm, PositionFunPermMapper,
        PositionFunPermService> {

    public PositionFunPerm genEntity() {
        PositionFunPerm entity = new PositionFunPerm();
        entity.genId();
        entity.setPositionId(RandomStringUtils.randomNumeric(60));
        entity.setFunPermId(RandomStringUtils.randomNumeric(60));
        return entity;
    }

}
