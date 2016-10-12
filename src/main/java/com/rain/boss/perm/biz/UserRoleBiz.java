package com.rain.boss.perm.biz;

import com.rain.boss.perm.entity.UserRole;
import com.rain.boss.perm.service.UserRoleService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class UserRoleBiz {
    @Resource
    UserRoleService userRoleService;

    public int add(UserRole entity) {
        return userRoleService.add(entity);
    }

    public int batchAdd(Collection<UserRole> entitys) {
        return userRoleService.batchAdd(entitys);
    }

    public int delete(String id) {
        return userRoleService.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return userRoleService.deleteByIds(ids);
    }

    public int update(UserRole entity) {
        return userRoleService.update(entity);
    }

    public UserRole get(String id) {
        return userRoleService.get(id);
    }

    public int countAll() {
        return userRoleService.countAll();
    }

    public List<UserRole> find(Map<String, ?> params) {
        return userRoleService.find(params);
    }

    public int count(Map<String, ?> params) {
        return userRoleService.count(params);
    }
}