package com.rain.boss.perm.service;

import com.rain.boss.perm.entity.Role;
import com.rain.boss.perm.mapper.RoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class RoleService {
    @Resource
    RoleMapper roleMapper;

    public int add(Role entity) {
        return roleMapper.add(entity);
    }

    public int batchAdd(Collection<Role> entitys) {
        return roleMapper.batchAdd(entitys);
    }

    public int delete(String id) {
        return roleMapper.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return roleMapper.deleteByIds(ids);
    }

    public int update(Role entity) {
        return roleMapper.update(entity);
    }

    public Role get(String id) {
        return roleMapper.get(id);
    }

    public int countAll() {
        return roleMapper.countAll();
    }

    public List<Role> find(Map<String, ?> params) {
        return roleMapper.find(params);
    }

    public int count(Map<String, ?> params) {
        return roleMapper.count(params);
    }
}
