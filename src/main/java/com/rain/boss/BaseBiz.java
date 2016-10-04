package com.rain.boss;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.rain.boss.BaseMapper;
import com.rain.boss.BaseService;

public abstract class BaseBiz<T extends BaseService<BaseMapper<E>, E>, E> {
	@Resource
	T service;

	public int add(E entity) {
		return service.add(entity);
	}

	public int batchAdd(Collection<E> entitys) {
		return service.batchAdd(entitys);
	}

	public int delete(String id) {
		return service.delete(id);
	}

	public int deleteByIds(Collection<String> ids) {
		return service.deleteByIds(ids);
	}

	public int update(E entity) {
		return service.update(entity);
	}

	public E get(String id) {
		return service.get(id);
	}

	public int countAll() {
		return service.countAll();
	}

	public List<E> find(Map<String, ?> params) {
		return service.find(params);
	}

	public int count(Map<String, ?> params) {
		return service.count(params);
	}
}
