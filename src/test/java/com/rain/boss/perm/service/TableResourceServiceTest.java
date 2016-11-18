package com.rain.boss.perm.service;

import com.rain.boss.AbstractTestClass;
import com.rain.boss.perm.entity.TableResource;
import com.rain.boss.perm.mapper.TableResourceMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TableResourceServiceTest extends AbstractTestClass<TableResource, TableResourceMapper,
        TableResourceService> {

    public TableResource genEntity() {
        TableResource entity = new TableResource();
        entity.genId();
        entity.setTableName(RandomStringUtils.randomNumeric(60));
        entity.setNickName(RandomStringUtils.randomNumeric(60));
        entity.setRemark(RandomStringUtils.randomNumeric(60));
        return entity;
    }

}
