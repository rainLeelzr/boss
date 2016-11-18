package com.rain.boss.perm.service;

import com.rain.boss.AbstractTestClass;
import com.rain.boss.perm.entity.Org;
import com.rain.boss.perm.mapper.OrgMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrgServiceTest extends AbstractTestClass<Org, OrgMapper, OrgService> {

    public Org genEntity() {
        Org entity = new Org();
        entity.genId();
        entity.setParentId(RandomStringUtils.randomNumeric(60));
        entity.setOrgName(RandomStringUtils.randomNumeric(60));
        entity.setOrgNickName(RandomStringUtils.randomNumeric(60));
        entity.setOrgType((byte) RandomUtils.nextInt(1, 5));
        entity.setAddress(RandomStringUtils.randomNumeric(60));
        entity.setContact(RandomStringUtils.randomNumeric(60));
        entity.setOrderNum(RandomUtils.nextInt(0, 2));
        entity.setEnabled((byte) RandomUtils.nextInt(0, 2));
        entity.setRemark(RandomStringUtils.randomNumeric(60));
        return entity;
    }

}
