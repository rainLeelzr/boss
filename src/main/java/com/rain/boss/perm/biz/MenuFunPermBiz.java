package com.rain.boss.perm.biz;

import com.rain.boss.perm.entity.MenuFunPerm;
import com.rain.boss.perm.service.MenuFunPermService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class MenuFunPermBiz {
    @Resource
    MenuFunPermService menuFunPermService;

    public int add(MenuFunPerm entity) {
        return menuFunPermService.add(entity);
    }

    public int batchAdd(Collection<MenuFunPerm> entitys) {
        return menuFunPermService.batchAdd(entitys);
    }

    public int delete(String id) {
        return menuFunPermService.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return menuFunPermService.deleteByIds(ids);
    }

    public int update(MenuFunPerm entity) {
        return menuFunPermService.update(entity);
    }

    public MenuFunPerm get(String id) {
        return menuFunPermService.get(id);
    }

    public int countAll() {
        return menuFunPermService.countAll();
    }

    public List<MenuFunPerm> find(Map<String, ?> params) {
        return menuFunPermService.find(params);
    }

    public int count(Map<String, ?> params) {
        return menuFunPermService.count(params);
    }
}