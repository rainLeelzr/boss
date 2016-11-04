package com.rain.boss.perm.mapper;

import com.rain.boss.annotation.MyBatisMapper;
import com.rain.boss.perm.entity.DataPermSet;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@MyBatisMapper
public interface DataPermSetMapper {
    int add(DataPermSet entity);

    int batchAdd(Collection<DataPermSet> entitys);

    int delete(String id);

    int deleteByIds(Collection<String> ids);

    int update(DataPermSet entity);

    DataPermSet get(String id);

    List<DataPermSet> find(Map<String, ?> params);

    int count(Map<String, ?> params);

    int countAll();
}