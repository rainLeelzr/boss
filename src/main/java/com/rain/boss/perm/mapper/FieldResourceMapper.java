package com.rain.boss.perm.mapper;

import com.rain.boss.annotation.MyBatisMapper;
import com.rain.boss.perm.entity.FieldResource;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@MyBatisMapper
public interface FieldResourceMapper {
    int add(FieldResource entity);

    int batchAdd(Collection<FieldResource> entitys);

    int delete(String id);

    int deleteByIds(Collection<String> ids);

    int update(FieldResource entity);

    FieldResource get(String id);

    List<FieldResource> find(Map<String, ?> params);

    int count(Map<String, ?> params);

    int countAll();
}