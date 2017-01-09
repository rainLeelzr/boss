package com.rain.boss.perm.service;

import com.rain.boss.AbstractTestClass;
import com.rain.boss.perm.entity.Menu;
import com.rain.boss.perm.mapper.MenuMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MenuServiceTest extends AbstractTestClass<Menu, MenuMapper, MenuService> {

    public Menu genEntity() {
        Menu entity = new Menu();
        entity.genId();
        entity.setParentId(RandomStringUtils.randomNumeric(60));
        entity.setMenuName(RandomStringUtils.randomNumeric(60));
        entity.setIp(RandomStringUtils.randomNumeric(60));
        entity.setMenuUrl(RandomStringUtils.randomNumeric(60));
        entity.setOrderNum(RandomUtils.nextInt(0, 2));
        entity.setEnabled((byte) RandomUtils.nextInt(0, 2));
        entity.setRemark(RandomStringUtils.randomNumeric(60));
        return entity;
    }

    @Test
    public void TestFindMyMenus() {
        List<Menu> menus = service.findMyMenus("3dd66b9e-0b3a-48a6-9adc-3a9d78e5f40d");
        Assert.assertTrue(menus.size() > 0);
    }

    //@Test
    //public void TestFindParents() {
    //    List<Menu> parentMenus = service.findParents();
    //    Assert.assertTrue(parentMenus.size() > 0);
    //}

    @Test
    public void TestFindSubMenus() {
        Menu parent = genEntity();
        Menu sub = genEntity();
        sub.setParentId(parent.getId());

        service.add(parent);
        service.add(sub);

        List<Menu> subMenus = service.findSubMenus(parent.getId());
        Assert.assertEquals(subMenus.size(), 2);
    }


}
