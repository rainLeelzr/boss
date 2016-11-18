package com.rain.boss.baseClass;

import com.rain.boss.baseClass.entity.BaseEntity;
import com.rain.boss.baseClass.mapper.BaseMapper;
import com.rain.boss.baseClass.service.BaseService;
import com.rain.boss.util.DateEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.sql.Date;

/**
 * 所有Controller的父类，用于封装一些公用的逻辑或算法。
 */
public abstract class BaseController<E extends BaseEntity, M extends BaseMapper<E>, S extends BaseService<E, M>> {

    @Autowired
    public S service;

    // InitBinder注解的含义是，告诉Spring在请求
    // 开始时(调用Controller方法前)先调用这个方法。
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // 声明java.sql.Date类型的参数注入，
        // 由DateEditor来完成。
        binder.registerCustomEditor(Date.class, new DateEditor());
    }

}
