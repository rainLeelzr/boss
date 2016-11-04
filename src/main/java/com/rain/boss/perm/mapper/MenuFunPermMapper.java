package com.rain.boss.perm.mapper;

import com.rain.boss.annotation.MyBatisMapper;
import com.rain.boss.perm.entity.MenuFunPerm;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@MyBatisMapper
public interface MenuFunPermMapper {
    int add(MenuFunPerm entity);

    int batchAdd(Collection<MenuFunPerm> entitys);

    int delete(String id);

    int deleteByIds(Collection<String> ids);

    int update(MenuFunPerm entity);

    MenuFunPerm get(String id);

    List<MenuFunPerm> find(Map<String, ?> params);

    int count(Map<String, ?> params);

    int countAll();
}