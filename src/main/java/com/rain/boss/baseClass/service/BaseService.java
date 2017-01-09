package com.rain.boss.baseClass.service;

import com.rain.boss.baseClass.entity.BaseEntity;
import com.rain.boss.baseClass.mapper.BaseMapper;
import com.rain.boss.data.page.PaginationData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/*
    此类的方法要受spring事务管理，所以要放到service包
 */
public abstract class BaseService<E extends BaseEntity, M extends BaseMapper<E>> {
    @Autowired
    public M mapper;

    public int add(E entity) {
        if (StringUtils.isEmpty(entity.getId())) {
            entity.genId();
        }
        return mapper.add(entity);
    }

    public int batchAdd(Collection<E> entitys) {
        return mapper.batchAdd(entitys);
    }

    public int delete(String id) {
        return mapper.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return mapper.deleteByIds(ids);
    }

    public int update(E entity) {
        return mapper.update(entity);
    }

    public E get(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return mapper.get(id);
    }

    public int countAll() {
        return mapper.countAll();
    }

    public PaginationData findPage(Map<String, ?> params) {
        List<E> entitys = mapper.findPage(params);
        int count = mapper.count(params);

        PaginationData paginationData = new PaginationData();
        paginationData.setData(entitys);
        paginationData.setCount(count);

        return paginationData;
    }

    public int count(Map<String, ?> params) {
        return mapper.count(params);
    }

}
