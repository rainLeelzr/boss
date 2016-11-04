package com.rain.boss.perm.mapper;

import com.rain.boss.annotation.MyBatisMapper;
import com.rain.boss.perm.entity.TableResource;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@MyBatisMapper
public interface TableResourceMapper {
    int add(TableResource entity);

    int batchAdd(Collection<TableResource> entitys);

    int delete(String id);

    int deleteByIds(Collection<String> ids);

    int update(TableResource entity);

    TableResource get(String id);

    List<TableResource> find(Map<String, ?> params);

    int count(Map<String, ?> params);

    int countAll();
}