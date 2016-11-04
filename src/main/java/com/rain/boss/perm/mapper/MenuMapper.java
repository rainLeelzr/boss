package com.rain.boss.perm.mapper;

import com.rain.boss.annotation.MyBatisMapper;
import com.rain.boss.perm.entity.Menu;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@MyBatisMapper
public interface MenuMapper {
    int add(Menu entity);

    int batchAdd(Collection<Menu> entitys);

    int delete(String id);

    int deleteByIds(Collection<String> ids);

    int update(Menu entity);

    Menu get(String id);

    List<Menu> find(Map<String, ?> params);

    int count(Map<String, ?> params);

    int countAll();
}