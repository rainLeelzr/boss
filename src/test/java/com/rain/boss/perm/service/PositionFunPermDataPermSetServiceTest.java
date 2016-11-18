package com.rain.boss.perm.service;

import com.rain.boss.AbstractTestClass;
import com.rain.boss.perm.entity.PositionFunPermDataPermSet;
import com.rain.boss.perm.mapper.PositionFunPermDataPermSetMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PositionFunPermDataPermSetServiceTest extends AbstractTestClass<PositionFunPermDataPermSet,
        PositionFunPermDataPermSetMapper, PositionFunPermDataPermSetService> {

    public PositionFunPermDataPermSet genEntity() {
        PositionFunPermDataPermSet entity = new PositionFunPermDataPermSet();
        entity.genId();
        entity.setPositionFunPermId(RandomStringUtils.randomNumeric(60));
        entity.setDataPermSetId(RandomStringUtils.randomNumeric(60));
        return entity;
    }

}
