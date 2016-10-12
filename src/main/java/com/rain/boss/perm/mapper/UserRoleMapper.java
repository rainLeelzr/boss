package com.rain.boss.perm.mapper;

import com.rain.boss.annotation.MyBatisMapper;
import com.rain.boss.perm.entity.Role;
import com.rain.boss.perm.entity.UserRole;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@MyBatisMapper
public interface UserRoleMapper {
    int add(UserRole entity);

    int batchAdd(Collection<UserRole> entitys);

    int delete(String id);

    int deleteByIds(Collection<String> ids);

    int update(UserRole entity);

    UserRole get(String id);

    List<UserRole> find(Map<String, ?> params);

    int count(Map<String, ?> params);

    int countAll();
}