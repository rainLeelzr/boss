package com.rain.boss.perm.mapper;

import com.rain.boss.annotation.MyBatisMapper;
import com.rain.boss.perm.entity.PositionFunPermDataPermSet;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@MyBatisMapper
public interface PositionFunPermDataPermSetMapper {
    int add(PositionFunPermDataPermSet entity);

    int batchAdd(Collection<PositionFunPermDataPermSet> entitys);

    int delete(String id);

    int deleteByIds(Collection<String> ids);

    int update(PositionFunPermDataPermSet entity);

    PositionFunPermDataPermSet get(String id);

    List<PositionFunPermDataPermSet> find(Map<String, ?> params);

    int count(Map<String, ?> params);

    int countAll();
}