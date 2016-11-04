package com.rain.boss.perm.mapper;

import com.rain.boss.annotation.MyBatisMapper;
import com.rain.boss.perm.entity.PositionFunPerm;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@MyBatisMapper
public interface PositionFunPermMapper {
    int add(PositionFunPerm entity);

    int batchAdd(Collection<PositionFunPerm> entitys);

    int delete(String id);

    int deleteByIds(Collection<String> ids);

    int update(PositionFunPerm entity);

    PositionFunPerm get(String id);

    List<PositionFunPerm> find(Map<String, ?> params);

    int count(Map<String, ?> params);

    int countAll();
}