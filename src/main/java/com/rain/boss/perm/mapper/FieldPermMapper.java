package com.rain.boss.perm.mapper;

import com.rain.boss.annotation.MyBatisMapper;
import com.rain.boss.perm.entity.FieldPerm;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@MyBatisMapper
public interface FieldPermMapper {
    int add(FieldPerm entity);

    int batchAdd(Collection<FieldPerm> entitys);

    int delete(String id);

    int deleteByIds(Collection<String> ids);

    int update(FieldPerm entity);

    FieldPerm get(String id);

    List<FieldPerm> find(Map<String, ?> params);

    int count(Map<String, ?> params);

    int countAll();
}