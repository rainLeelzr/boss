package com.rain.boss.perm.service;

import com.rain.boss.AbstractTestClass;
import com.rain.boss.perm.entity.UserPosition;
import com.rain.boss.perm.mapper.UserPositionMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserPositionServiceTest extends AbstractTestClass<UserPosition, UserPositionMapper, UserPositionService> {

    public UserPosition genEntity() {
        UserPosition entity = new UserPosition();
        entity.genId();
        entity.setUserId(RandomStringUtils.randomNumeric(4));
        entity.setPositionId(RandomStringUtils.randomNumeric(4));
        return entity;
    }

}
