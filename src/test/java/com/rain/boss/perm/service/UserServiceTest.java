package com.rain.boss.perm.service;

import com.rain.boss.AbstractTestClass;
import com.rain.boss.perm.entity.User;
import com.rain.boss.perm.mapper.UserMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest extends AbstractTestClass<User, UserMapper, UserService> {

    public User genEntity() {
        User entity = new User();
        entity.genId();
        entity.setUserAccount(RandomStringUtils.randomNumeric(4));
        entity.setUserPwd("123456abc_");
        entity.setUserName(RandomStringUtils.randomNumeric(4));
        entity.setGender((byte) RandomUtils.nextInt(1, 3));
        entity.setQq(RandomStringUtils.randomNumeric(9));
        entity.setTelephone(RandomStringUtils.randomNumeric(8));
        entity.setMobilePhone(RandomStringUtils.randomNumeric(11));
        entity.setEmail(RandomStringUtils.randomNumeric(11));
        entity.setEnabled((byte) RandomUtils.nextInt(1, 3));
        entity.setRemark(RandomStringUtils.randomNumeric(60));
        return entity;
    }

    @Test
    public void testGetByAccount() {
        User entity = genEntity();
        Assert.assertEquals(1, service.add(entity));

        Assert.assertEquals(entity.toString(), service.getByAccount(entity.getUserAccount()).toString());
    }

}
