package com.rain.boss.perm.mapper;

import com.rain.boss.annotation.MyBatisMapper;
import com.rain.boss.perm.entity.FunPerm;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@MyBatisMapper
public interface FunPermMapper {
    int add(FunPerm entity);

    int batchAdd(Collection<FunPerm> entitys);

    int delete(String id);

    int deleteByIds(Collection<String> ids);

    int update(FunPerm entity);

    FunPerm get(String id);

    List<FunPerm> find(Map<String, ?> params);

    int count(Map<String, ?> params);

    int countAll();
}