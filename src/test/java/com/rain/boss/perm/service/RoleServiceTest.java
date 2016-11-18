package com.rain.boss.perm.service;

import com.rain.boss.AbstractTestClass;
import com.rain.boss.perm.entity.Role;
import com.rain.boss.perm.mapper.RoleMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.util.UUID;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoleServiceTest extends AbstractTestClass<Role, RoleMapper, RoleService> {

    public Role genEntity() {
        Role entity = new Role();
        entity.genId();
        entity.setParentId(UUID.randomUUID().toString());
        entity.setRoleName(RandomStringUtils.randomNumeric(4));
        entity.setRoleType((byte) RandomUtils.nextInt(1, 3));
        entity.setEnabled((byte) RandomUtils.nextInt(0, 2));
        entity.setRemark(RandomStringUtils.randomNumeric(60));
        return entity;
    }

}
