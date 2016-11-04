package com.rain.boss.perm.service;

import com.rain.boss.perm.entity.Menu;
import com.rain.boss.perm.mapper.MenuMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class MenuService {
    @Resource
    MenuMapper menuMapper;

    public int add(Menu entity) {
        return menuMapper.add(entity);
    }

    public int batchAdd(Collection<Menu> entitys) {
        return menuMapper.batchAdd(entitys);
    }

    public int delete(String id) {
        return menuMapper.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return menuMapper.deleteByIds(ids);
    }

    public int update(Menu entity) {
        return menuMapper.update(entity);
    }

    public Menu get(String id) {
        return menuMapper.get(id);
    }

    public int countAll() {
        return menuMapper.countAll();
    }

    public List<Menu> find(Map<String, ?> params) {
        return menuMapper.find(params);
    }

    public int count(Map<String, ?> params) {
        return menuMapper.count(params);
    }
}
