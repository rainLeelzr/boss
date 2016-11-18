package com.rain.boss.baseClass.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface BaseMapper<E> {
    int add(E entity);

    int batchAdd(Collection<E> entitys);

    int delete(String id);

    int deleteByIds(Collection<String> ids);

    int update(E entity);

    E get(String id);

    List<E> findPage(Map<String, ?> params);

    int count(Map<String, ?> params);

    int countAll();
}