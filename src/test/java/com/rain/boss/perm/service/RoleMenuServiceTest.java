package com.rain.boss.perm.service;

import com.rain.boss.AbstractTestClass;
import com.rain.boss.perm.entity.RoleMenu;
import com.rain.boss.perm.mapper.RoleMenuMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoleMenuServiceTest extends AbstractTestClass<RoleMenu, RoleMenuMapper, RoleMenuService> {

    public RoleMenu genEntity() {
        RoleMenu entity = new RoleMenu();
        entity.genId();
        entity.setRoleId(RandomStringUtils.randomNumeric(60));
        entity.setMenuId(RandomStringUtils.randomNumeric(60));
        return entity;
    }

}
