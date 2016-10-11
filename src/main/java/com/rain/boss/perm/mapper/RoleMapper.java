package com.rain.boss.perm.mapper;

import com.rain.boss.annotation.MyBatisMapper;
import com.rain.boss.perm.entity.Role;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@MyBatisMapper
public interface RoleMapper {
    int add(Role entity);

    int batchAdd(Collection<Role> entitys);

    int delete(String id);

    int deleteByIds(Collection<String> ids);

    int update(Role entity);

    Role get(String id);

    List<Role> find(Map<String, ?> params);

    int count(Map<String, ?> params);

    int countAll();
}