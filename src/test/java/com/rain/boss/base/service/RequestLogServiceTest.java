package com.rain.boss.base.service;

import com.rain.boss.AbstractTestClass;
import com.rain.boss.base.entity.RequestLog;
import com.rain.boss.base.mapper.RequestLogMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.sql.Timestamp;
import java.time.Instant;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RequestLogServiceTest extends AbstractTestClass<RequestLog, RequestLogMapper, RequestLogService> {

    public RequestLog genEntity() {
        RequestLog entity = new RequestLog();
        entity.genId();
        entity.setClientIp(RandomStringUtils.randomNumeric(6));
        Timestamp ts = Timestamp.from(Instant.now());
        ts.setNanos(0);
        entity.setRequestTime(ts);
        entity.setResponseTime(ts);
        entity.setReqMethod(RandomStringUtils.randomNumeric(6));
        entity.setReqUri(RandomStringUtils.randomNumeric(6));
        entity.setReqParam(RandomStringUtils.randomNumeric(6));
        entity.setResponseText(RandomStringUtils.randomNumeric(6));
        entity.setUserAgent(RandomStringUtils.randomNumeric(6));
        entity.setReqResult(RandomStringUtils.randomNumeric(6));
        entity.setUserId(RandomStringUtils.randomNumeric(6));
        entity.setUserName(RandomStringUtils.randomNumeric(6));
        entity.setOrgId(RandomStringUtils.randomNumeric(6));
        entity.setOrgName(RandomStringUtils.randomNumeric(6));
        entity.setRemark(RandomStringUtils.randomNumeric(6));
        return entity;
    }

}
