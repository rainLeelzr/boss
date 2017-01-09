package com.rain.boss.perm.mapper;

import com.rain.boss.annotation.MyBatisMapper;
import com.rain.boss.baseClass.mapper.BaseMapper;
import com.rain.boss.perm.entity.Menu;

import java.util.List;

@MyBatisMapper
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> findByUserId(String userId);

    List<Menu> findByParentId(String parentId);

    //List<Menu> findParents();
}