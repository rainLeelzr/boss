package com.rain.boss.perm.service;

import com.rain.boss.perm.entity.UserRole;
import com.rain.boss.perm.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class UserRoleService {
    @Resource
    UserRoleMapper userRoleMapper;

    public int add(UserRole entity) {
        return userRoleMapper.add(entity);
    }

    public int batchAdd(Collection<UserRole> entitys) {
        return userRoleMapper.batchAdd(entitys);
    }

    public int delete(String id) {
        return userRoleMapper.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return userRoleMapper.deleteByIds(ids);
    }

    public int update(UserRole entity) {
        return userRoleMapper.update(entity);
    }

    public UserRole get(String id) {
        return userRoleMapper.get(id);
    }

    public int countAll() {
        return userRoleMapper.countAll();
    }

    public List<UserRole> find(Map<String, ?> params) {
        return userRoleMapper.find(params);
    }

    public int count(Map<String, ?> params) {
        return userRoleMapper.count(params);
    }
}
