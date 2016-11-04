package com.rain.boss.perm.service;

import com.rain.boss.perm.entity.FieldResource;
import com.rain.boss.perm.mapper.FieldResourceMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class FieldResourceService {
    @Resource
    FieldResourceMapper fieldResourceMapper;

    public int add(FieldResource entity) {
        return fieldResourceMapper.add(entity);
    }

    public int batchAdd(Collection<FieldResource> entitys) {
        return fieldResourceMapper.batchAdd(entitys);
    }

    public int delete(String id) {
        return fieldResourceMapper.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return fieldResourceMapper.deleteByIds(ids);
    }

    public int update(FieldResource entity) {
        return fieldResourceMapper.update(entity);
    }

    public FieldResource get(String id) {
        return fieldResourceMapper.get(id);
    }

    public int countAll() {
        return fieldResourceMapper.countAll();
    }

    public List<FieldResource> find(Map<String, ?> params) {
        return fieldResourceMapper.find(params);
    }

    public int count(Map<String, ?> params) {
        return fieldResourceMapper.count(params);
    }
}
