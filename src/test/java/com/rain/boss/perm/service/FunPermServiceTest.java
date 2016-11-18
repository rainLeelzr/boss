package com.rain.boss.perm.service;

import com.rain.boss.AbstractTestClass;
import com.rain.boss.perm.entity.FunPerm;
import com.rain.boss.perm.mapper.FunPermMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FunPermServiceTest extends AbstractTestClass<FunPerm, FunPermMapper, FunPermService> {

    public FunPerm genEntity() {
        FunPerm entity = new FunPerm();
        entity.genId();
        entity.setFunPermName(RandomStringUtils.randomNumeric(60));
        entity.setFunPermType((byte) RandomUtils.nextInt(1, 5));
        entity.setFunPermUrl(RandomStringUtils.randomNumeric(60));
        entity.setEnabled((byte) RandomUtils.nextInt(0, 2));
        entity.setRemark(RandomStringUtils.randomNumeric(60));
        return entity;
    }

}
