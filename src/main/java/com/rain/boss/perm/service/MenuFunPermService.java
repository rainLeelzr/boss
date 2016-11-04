package com.rain.boss.perm.service;

import com.rain.boss.perm.entity.MenuFunPerm;
import com.rain.boss.perm.mapper.MenuFunPermMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class MenuFunPermService {
    @Resource
    MenuFunPermMapper menuFunPermMapper;

    public int add(MenuFunPerm entity) {
        return menuFunPermMapper.add(entity);
    }

    public int batchAdd(Collection<MenuFunPerm> entitys) {
        return menuFunPermMapper.batchAdd(entitys);
    }

    public int delete(String id) {
        return menuFunPermMapper.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return menuFunPermMapper.deleteByIds(ids);
    }

    public int update(MenuFunPerm entity) {
        return menuFunPermMapper.update(entity);
    }

    public MenuFunPerm get(String id) {
        return menuFunPermMapper.get(id);
    }

    public int countAll() {
        return menuFunPermMapper.countAll();
    }

    public List<MenuFunPerm> find(Map<String, ?> params) {
        return menuFunPermMapper.find(params);
    }

    public int count(Map<String, ?> params) {
        return menuFunPermMapper.count(params);
    }
}
