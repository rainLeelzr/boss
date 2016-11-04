package com.rain.boss.perm.service;

import com.rain.boss.perm.entity.FunPerm;
import com.rain.boss.perm.mapper.FunPermMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class FunPermService {
    @Resource
    FunPermMapper funPermMapper;

    public int add(FunPerm entity) {
        return funPermMapper.add(entity);
    }

    public int batchAdd(Collection<FunPerm> entitys) {
        return funPermMapper.batchAdd(entitys);
    }

    public int delete(String id) {
        return funPermMapper.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return funPermMapper.deleteByIds(ids);
    }

    public int update(FunPerm entity) {
        return funPermMapper.update(entity);
    }

    public FunPerm get(String id) {
        return funPermMapper.get(id);
    }

    public int countAll() {
        return funPermMapper.countAll();
    }

    public List<FunPerm> find(Map<String, ?> params) {
        return funPermMapper.find(params);
    }

    public int count(Map<String, ?> params) {
        return funPermMapper.count(params);
    }
}
