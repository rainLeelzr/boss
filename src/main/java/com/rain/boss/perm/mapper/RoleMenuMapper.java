package com.rain.boss.perm.mapper;

import com.rain.boss.annotation.MyBatisMapper;
import com.rain.boss.perm.entity.RoleMenu;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@MyBatisMapper
public interface RoleMenuMapper {
    int add(RoleMenu entity);

    int batchAdd(Collection<RoleMenu> entitys);

    int delete(String id);

    int deleteByIds(Collection<String> ids);

    int update(RoleMenu entity);

    RoleMenu get(String id);

    List<RoleMenu> find(Map<String, ?> params);

    int count(Map<String, ?> params);

    int countAll();
}