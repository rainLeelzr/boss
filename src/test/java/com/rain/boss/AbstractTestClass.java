package com.rain.boss;

import com.rain.boss.baseClass.entity.BaseEntity;
import com.rain.boss.baseClass.mapper.BaseMapper;
import com.rain.boss.baseClass.service.BaseService;
import com.rain.boss.data.page.Page;
import com.rain.boss.data.page.PaginationData;
import com.rain.boss.util.PropertyUtils;
import com.rain.boss.util.SysConst;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public abstract class AbstractTestClass<E extends BaseEntity, M extends BaseMapper<E>, S extends BaseService<E, M>>
        extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    protected S service;

    public abstract E genEntity();

    @Test
    public void testAdd() {
        E entity = genEntity();
        Assert.assertEquals(1, service.add(entity));
    }

    @Test
    public void testGet() {
        E entity = genEntity();
        Assert.assertEquals(1, service.add(entity));

        Assert.assertEquals(entity.toString(), service.get(entity.getId()).toString());
    }

    @Test
    public void testFindPage() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        E entity = genEntity();
        Assert.assertEquals(1, service.add(entity));
        Map<String, Object> params = PropertyUtils.describeWithoutNull(entity);

        Page page = new Page();
        page.setPageIndex(0);
        page.setPageSize(10);
        page.setSortField("id");
        page.setSortOrder("desc");
        page.calculate();
        params.put(SysConst.PAGE_KEY, page);
        PaginationData paginationData = service.findPage(params);

        Assert.assertEquals(1, paginationData.getCount());
        Assert.assertEquals(1, paginationData.getData().size());
    }

    @Test
    public void testCount() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        E entity = genEntity();
        Assert.assertEquals(1, service.add(entity));
        Map<String, Object> params = PropertyUtils.describeWithoutNull(entity);

        Assert.assertEquals(1, service.count(params));
    }

    @Test
    public void testUpdate() {
        E entity = genEntity();
        Assert.assertEquals(1, service.add(entity));

        E newEntity = genEntity();
        newEntity.setId(entity.getId());
        Assert.assertEquals(1, service.update(newEntity));
    }

    @Test
    public void testDelete() {
        E entity = genEntity();
        Assert.assertEquals(1, service.add(entity));

        Assert.assertEquals(1, service.delete(entity.getId()));
    }

    @Test
    public void testBatchAdd() {
        int testBatchCount = 10;
        List<E> entitys = new ArrayList<>(testBatchCount);
        for (int i = 0; i < testBatchCount; i++) {
            entitys.add(genEntity());
        }
        Assert.assertEquals(testBatchCount, service.batchAdd(entitys));
    }

    @Test
    public void testDeleteByIds() {
        int testBatchCount = 10;
        List<E> entitys = new ArrayList<>(testBatchCount);
        for (int i = 0; i < testBatchCount; i++) {
            entitys.add(genEntity());
        }
        Assert.assertEquals(testBatchCount, service.batchAdd(entitys));

        Set<String> ids = new HashSet<>();
        entitys.forEach(e -> ids.add(e.getId()));
        Assert.assertEquals(ids.size(), service.deleteByIds(ids));
    }

    @Test
    public void testCountAll() {
        service.countAll();
    }

}
