package com.rain.boss.perm.mapper;

import com.rain.boss.annotation.MyBatisMapper;
import com.rain.boss.perm.entity.OrgPosition;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@MyBatisMapper
public interface OrgPositionMapper {
    int add(OrgPosition entity);

    int batchAdd(Collection<OrgPosition> entitys);

    int delete(String id);

    int deleteByIds(Collection<String> ids);

    int update(OrgPosition entity);

    OrgPosition get(String id);

    List<OrgPosition> find(Map<String, ?> params);

    int count(Map<String, ?> params);

    int countAll();
}