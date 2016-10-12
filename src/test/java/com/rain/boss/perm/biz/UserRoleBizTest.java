package com.rain.boss.perm.biz;

import com.rain.boss.AbstractTestClass;
import com.rain.boss.perm.entity.UserRole;
import com.rain.boss.util.Page;
import com.rain.boss.util.PropertyUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRoleBizTest extends AbstractTestClass {

    private static UserRole globalEntity;
    private static Collection<UserRole> globalEntitys;
    @Resource
    private UserRoleBiz biz;

    private static UserRole genEntity() {
        UserRole entity = new UserRole();
        entity.setId();
        entity.setUserId(RandomStringUtils.randomNumeric(4));
        entity.setRoleId(RandomStringUtils.randomNumeric(4));
        return entity;
    }

    @Test
    public void test1Add() {
        globalEntity = genEntity();
        Assert.assertEquals(1, biz.add(globalEntity));
    }

    @Test
    public void test2Get() {
        Assert.assertEquals(globalEntity.toString(), biz.get(globalEntity.getId()).toString());
    }

    @Test
    public void test3Find() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Map<String, Object> params = PropertyUtils.describeWithoutNull(globalEntity);

        Page page = new Page(1, 10, "id desc");
        params.put("page", page);
        Assert.assertEquals(1, biz.find(params).size());
    }

    @Test
    public void test4Count() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Map<String, Object> params = PropertyUtils.describeWithoutNull(globalEntity);
        Assert.assertEquals(1, biz.count(params));
    }

    @Test
    public void test5Update() {
        UserRole e = genEntity();
        e.setId(globalEntity.getId());
        Assert.assertEquals(1, biz.update(e));
    }

    @Test
    public void test6Delete() {
        Assert.assertEquals(1, biz.delete(globalEntity.getId()));
    }

    @Test
    public void test7BatchAdd() {
        int testCount = 10;
        globalEntitys = new ArrayList<>(testCount);
        for (int i = 0; i < testCount; i++) {
            globalEntitys.add(genEntity());
        }
        Assert.assertEquals(testCount, biz.batchAdd(globalEntitys));
    }

    @Test
    public void test8DeleteByIds() {
        Set<String> entityIds = new HashSet<>();
        globalEntitys.forEach(e -> entityIds.add(e.getId()));
        Assert.assertEquals(entityIds.size(), biz.deleteByIds(entityIds));
    }

    @Test
    public void test9CountAll() {
        biz.countAll();
    }

}
