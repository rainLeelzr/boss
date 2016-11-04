package com.rain.boss.perm.mapper;

import com.rain.boss.annotation.MyBatisMapper;
import com.rain.boss.perm.entity.Position;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@MyBatisMapper
public interface PositionMapper {
    int add(Position entity);

    int batchAdd(Collection<Position> entitys);

    int delete(String id);

    int deleteByIds(Collection<String> ids);

    int update(Position entity);

    Position get(String id);

    List<Position> find(Map<String, ?> params);

    int count(Map<String, ?> params);

    int countAll();
}