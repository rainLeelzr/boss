package com.rain.boss.perm.service;

import com.rain.boss.baseClass.service.BaseService;
import com.rain.boss.perm.entity.Menu;
import com.rain.boss.perm.mapper.MenuMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableCaching
public class MenuService extends BaseService<Menu, MenuMapper> {

    /**
     * 查找某个用户拥有的已启用的菜单集合
     *
     * @param userId 用户id
     * @return 已启用的菜单集合
     */
    @Cacheable(cacheNames = "bossPermMenu", key = "'userId'+#userId")
    public List<Menu> findMyMenus(String userId) {
        return mapper.findByUserId(userId);
    }

    /**
     * 查找当前菜单的下一级子菜单
     *
     * @param id 当前菜单id
     * @return List<Menu>
     */
    @Cacheable(cacheNames = "bossPermMenu", key = "'parentId'+#id")
    public List<Menu> findSubMenus(String id) {
        return mapper.findByParentId(id);
    }

    /**
     * 获取所有含有子菜单的父菜单
     * @return List<Menu>
     */
    //public List<Menu> findParents() {
    //    return mapper.findParents();
    //}

}
