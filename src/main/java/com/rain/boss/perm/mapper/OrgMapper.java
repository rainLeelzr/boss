package com.rain.boss.perm.mapper;

import com.rain.boss.annotation.MyBatisMapper;
import com.rain.boss.perm.entity.Org;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@MyBatisMapper
public interface OrgMapper {
    int add(Org entity);

    int batchAdd(Collection<Org> entitys);

    int delete(String id);

    int deleteByIds(Collection<String> ids);

    int update(Org entity);

    Org get(String id);

    List<Org> find(Map<String, ?> params);

    int count(Map<String, ?> params);

    int countAll();
}