package com.rain.boss.perm.biz;

import com.rain.boss.perm.entity.RoleMenu;
import com.rain.boss.perm.service.RoleMenuService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class RoleMenuBiz {
    @Resource
    RoleMenuService roleMenuService;

    public int add(RoleMenu entity) {
        return roleMenuService.add(entity);
    }

    public int batchAdd(Collection<RoleMenu> entitys) {
        return roleMenuService.batchAdd(entitys);
    }

    public int delete(String id) {
        return roleMenuService.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return roleMenuService.deleteByIds(ids);
    }

    public int update(RoleMenu entity) {
        return roleMenuService.update(entity);
    }

    public RoleMenu get(String id) {
        return roleMenuService.get(id);
    }

    public int countAll() {
        return roleMenuService.countAll();
    }

    public List<RoleMenu> find(Map<String, ?> params) {
        return roleMenuService.find(params);
    }

    public int count(Map<String, ?> params) {
        return roleMenuService.count(params);
    }
}