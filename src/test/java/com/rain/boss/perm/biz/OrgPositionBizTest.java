package com.rain.boss.perm.biz;

import com.rain.boss.AbstractTestClass;
import com.rain.boss.perm.entity.OrgPosition;
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
public class OrgPositionBizTest extends AbstractTestClass {

    private static OrgPosition globalEntity;
    private static Collection<OrgPosition> globalEntitys;
    @Resource
    private OrgPositionBiz biz;

    private static OrgPosition genEntity() {
        OrgPosition entity = new OrgPosition();
        entity.setId();
        entity.setOrgId(RandomStringUtils.randomNumeric(60));
        entity.setPositionId(RandomStringUtils.randomNumeric(60));
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
        OrgPosition e = genEntity();
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