package com.rain.boss.perm.biz;

import com.rain.boss.AbstractTestClass;
import com.rain.boss.perm.entity.PositionFunPermDataPermSet;
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
public class PositionFunPermDataPermSetBizTest extends AbstractTestClass {

    private static PositionFunPermDataPermSet globalEntity;
    private static Collection<PositionFunPermDataPermSet> globalEntitys;
    @Resource
    private PositionFunPermDataPermSetBiz biz;

    private static PositionFunPermDataPermSet genEntity() {
        PositionFunPermDataPermSet entity = new PositionFunPermDataPermSet();
        entity.setId();
        entity.setPositionFunPermId(RandomStringUtils.randomNumeric(60));
        entity.setDataPermSetId(RandomStringUtils.randomNumeric(60));
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
    public void test4Count() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Map<String, Object> params = PropertyUtils.describeWithoutNull(globalEntity);
        Assert.assertEquals(1, biz.count(params));
    }

    @Test
    public void test5Update() {
        PositionFunPermDataPermSet e = genEntity();
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
        Set<String> ids = new HashSet<>();
        globalEntitys.forEach(e -> ids.add(e.getId()));
        Assert.assertEquals(ids.size(), biz.deleteByIds(ids));
    }

    @Test
    public void test9CountAll() {
        biz.countAll();
    }

}