package com.rain.boss.perm.mapper;

import com.rain.boss.annotation.MyBatisMapper;
import com.rain.boss.perm.entity.DataPerm;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@MyBatisMapper
public interface DataPermMapper {
    int add(DataPerm entity);

    int batchAdd(Collection<DataPerm> entitys);

    int delete(String id);

    int deleteByIds(Collection<String> ids);

    int update(DataPerm entity);

    DataPerm get(String id);

    List<DataPerm> find(Map<String, ?> params);

    int count(Map<String, ?> params);

    int countAll();
}