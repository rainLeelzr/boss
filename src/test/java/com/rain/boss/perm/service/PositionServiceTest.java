package com.rain.boss.perm.service;

import com.rain.boss.AbstractTestClass;
import com.rain.boss.perm.entity.Position;
import com.rain.boss.perm.mapper.PositionMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PositionServiceTest extends AbstractTestClass<Position, PositionMapper, PositionService> {

    public Position genEntity() {
        Position entity = new Position();
        entity.genId();
        entity.setCode(RandomStringUtils.randomNumeric(60));
        entity.setPositionName(RandomStringUtils.randomNumeric(60));
        entity.setPositionType((byte) RandomUtils.nextInt(1, 5));
        entity.setRoute(RandomStringUtils.randomNumeric(60));
        entity.setEnabled((byte) RandomUtils.nextInt(0, 2));
        entity.setRemark(RandomStringUtils.randomNumeric(60));
        return entity;
    }

}
