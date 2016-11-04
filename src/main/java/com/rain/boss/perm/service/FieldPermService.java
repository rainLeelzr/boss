package com.rain.boss.perm.service;

import com.rain.boss.perm.entity.FieldPerm;
import com.rain.boss.perm.mapper.FieldPermMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class FieldPermService {
    @Resource
    FieldPermMapper fieldPermMapper;

    public int add(FieldPerm entity) {
        return fieldPermMapper.add(entity);
    }

    public int batchAdd(Collection<FieldPerm> entitys) {
        return fieldPermMapper.batchAdd(entitys);
    }

    public int delete(String id) {
        return fieldPermMapper.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return fieldPermMapper.deleteByIds(ids);
    }

    public int update(FieldPerm entity) {
        return fieldPermMapper.update(entity);
    }

    public FieldPerm get(String id) {
        return fieldPermMapper.get(id);
    }

    public int countAll() {
        return fieldPermMapper.countAll();
    }

    public List<FieldPerm> find(Map<String, ?> params) {
        return fieldPermMapper.find(params);
    }

    public int count(Map<String, ?> params) {
        return fieldPermMapper.count(params);
    }
}
