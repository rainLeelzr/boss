package com.rain.boss.perm.mapper;

import com.rain.boss.annotation.MyBatisMapper;
import com.rain.boss.perm.entity.DataPermGroup;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@MyBatisMapper
public interface DataPermGroupMapper {
    int add(DataPermGroup entity);

    int batchAdd(Collection<DataPermGroup> entitys);

    int delete(String id);

    int deleteByIds(Collection<String> ids);

    int update(DataPermGroup entity);

    DataPermGroup get(String id);

    List<DataPermGroup> find(Map<String, ?> params);

    int count(Map<String, ?> params);

    int countAll();
}