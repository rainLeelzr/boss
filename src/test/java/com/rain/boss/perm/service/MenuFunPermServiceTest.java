package com.rain.boss.perm.service;

import com.rain.boss.AbstractTestClass;
import com.rain.boss.perm.entity.MenuFunPerm;
import com.rain.boss.perm.mapper.MenuFunPermMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MenuFunPermServiceTest extends AbstractTestClass<MenuFunPerm, MenuFunPermMapper, MenuFunPermService> {

    public MenuFunPerm genEntity() {
        MenuFunPerm entity = new MenuFunPerm();
        entity.genId();
        entity.setMenuId(RandomStringUtils.randomNumeric(60));
        entity.setFunPermId(RandomStringUtils.randomNumeric(60));
        return entity;
    }

}
