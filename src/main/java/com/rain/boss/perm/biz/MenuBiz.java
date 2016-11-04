package com.rain.boss.perm.biz;

import com.rain.boss.perm.entity.Menu;
import com.rain.boss.perm.service.MenuService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class MenuBiz {
    @Resource
    MenuService menuService;

    public int add(Menu entity) {
        return menuService.add(entity);
    }

    public int batchAdd(Collection<Menu> entitys) {
        return menuService.batchAdd(entitys);
    }

    public int delete(String id) {
        return menuService.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return menuService.deleteByIds(ids);
    }

    public int update(Menu entity) {
        return menuService.update(entity);
    }

    public Menu get(String id) {
        return menuService.get(id);
    }

    public int countAll() {
        return menuService.countAll();
    }

    public List<Menu> find(Map<String, ?> params) {
        return menuService.find(params);
    }

    public int count(Map<String, ?> params) {
        return menuService.count(params);
    }
}