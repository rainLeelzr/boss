package com.rain.boss.perm.service;

import com.rain.boss.AbstractTestClass;
import com.rain.boss.perm.entity.UserRole;
import com.rain.boss.perm.mapper.UserRoleMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRoleServiceTest extends AbstractTestClass<UserRole, UserRoleMapper, UserRoleService> {

    public UserRole genEntity() {
        UserRole entity = new UserRole();
        entity.genId();
        entity.setUserId(RandomStringUtils.randomNumeric(4));
        entity.setRoleId(RandomStringUtils.randomNumeric(4));
        return entity;
    }

}
