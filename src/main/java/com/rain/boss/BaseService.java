package com.rain.boss;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.rain.boss.BaseMapper;

public abstract class BaseService<T extends BaseMapper<E>, E> {
	@Resource
	T mapper;

	public int add(E entity) {
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
		return mapper.get(id);
	}

	public int countAll() {
		return mapper.countAll();
	}

	public List<E> find(Map<String, ?> params) {
		return mapper.find(params);
	}

	public int count(Map<String, ?> params) {
		return mapper.count(params);
	}
}
