package com.rain.boss.perm.service;

import com.rain.boss.AbstractTestClass;
import com.rain.boss.perm.entity.Menu;
import com.rain.boss.perm.mapper.MenuMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MenuServiceTest extends AbstractTestClass<Menu, MenuMapper, MenuService> {

    public Menu genEntity() {
        Menu entity = new Menu();
        entity.genId();
        entity.setParentId(RandomStringUtils.randomNumeric(60));
        entity.setMenuName(RandomStringUtils.randomNumeric(60));
        entity.setMenuUrl(RandomStringUtils.randomNumeric(60));
        entity.setOrderNum(RandomUtils.nextInt(0, 2));
        entity.setEnabled((byte) RandomUtils.nextInt(0, 2));
        entity.setRemark(RandomStringUtils.randomNumeric(60));
        return entity;
    }

}
