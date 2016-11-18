package com.rain.boss.perm.service;

import com.rain.boss.AbstractTestClass;
import com.rain.boss.perm.entity.UserToken;
import com.rain.boss.perm.mapper.UserTokenMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserTokenServiceTest extends AbstractTestClass<UserToken, UserTokenMapper, UserTokenService> {

    public UserToken genEntity() {
        UserToken entity = new UserToken();
        entity.genId();
        entity.setToken(RandomStringUtils.randomNumeric(4));
        entity.setTokenExpireTime(RandomUtils.nextLong(1, 1000));
        entity.setTokenCreateTime(RandomStringUtils.randomNumeric(4));
        entity.setUserId(RandomStringUtils.randomNumeric(4));
        return entity;
    }

}
