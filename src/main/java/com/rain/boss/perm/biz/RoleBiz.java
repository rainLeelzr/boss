package com.rain.boss.perm.biz;

import com.rain.boss.perm.entity.Role;
import com.rain.boss.perm.service.RoleService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class RoleBiz {
    @Resource
    RoleService roleService;

    public int add(Role entity) {
        return roleService.add(entity);
    }

    public int batchAdd(Collection<Role> entitys) {
        return roleService.batchAdd(entitys);
    }

    public int delete(String id) {
        return roleService.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return roleService.deleteByIds(ids);
    }

    public int update(Role entity) {
        return roleService.update(entity);
    }

    public Role get(String id) {
        return roleService.get(id);
    }

    public int countAll() {
        return roleService.countAll();
    }

    public List<Role> find(Map<String, ?> params) {
        return roleService.find(params);
    }

    public int count(Map<String, ?> params) {
        return roleService.count(params);
    }
}