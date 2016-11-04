package com.rain.boss.perm.service;

import com.rain.boss.perm.entity.RoleMenu;
import com.rain.boss.perm.mapper.RoleMenuMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class RoleMenuService {
    @Resource
    RoleMenuMapper roleMenuMapper;

    public int add(RoleMenu entity) {
        return roleMenuMapper.add(entity);
    }

    public int batchAdd(Collection<RoleMenu> entitys) {
        return roleMenuMapper.batchAdd(entitys);
    }

    public int delete(String id) {
        return roleMenuMapper.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return roleMenuMapper.deleteByIds(ids);
    }

    public int update(RoleMenu entity) {
        return roleMenuMapper.update(entity);
    }

    public RoleMenu get(String id) {
        return roleMenuMapper.get(id);
    }

    public int countAll() {
        return roleMenuMapper.countAll();
    }

    public List<RoleMenu> find(Map<String, ?> params) {
        return roleMenuMapper.find(params);
    }

    public int count(Map<String, ?> params) {
        return roleMenuMapper.count(params);
    }
}
