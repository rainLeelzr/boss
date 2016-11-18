package com.rain.boss.perm.service;

import com.rain.boss.AbstractTestClass;
import com.rain.boss.perm.entity.OrgPosition;
import com.rain.boss.perm.mapper.OrgPositionMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrgPositionServiceTest extends AbstractTestClass<OrgPosition, OrgPositionMapper, OrgPositionService> {

    public OrgPosition genEntity() {
        OrgPosition entity = new OrgPosition();
        entity.genId();
        entity.setOrgId(RandomStringUtils.randomNumeric(60));
        entity.setPositionId(RandomStringUtils.randomNumeric(60));
        return entity;
    }

}
