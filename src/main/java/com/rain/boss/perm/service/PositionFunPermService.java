package com.rain.boss.perm.service;

import com.rain.boss.perm.entity.PositionFunPerm;
import com.rain.boss.perm.mapper.PositionFunPermMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class PositionFunPermService {
    @Resource
    PositionFunPermMapper positionFunPermMapper;

    public int add(PositionFunPerm entity) {
        return positionFunPermMapper.add(entity);
    }

    public int batchAdd(Collection<PositionFunPerm> entitys) {
        return positionFunPermMapper.batchAdd(entitys);
    }

    public int delete(String id) {
        return positionFunPermMapper.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return positionFunPermMapper.deleteByIds(ids);
    }

    public int update(PositionFunPerm entity) {
        return positionFunPermMapper.update(entity);
    }

    public PositionFunPerm get(String id) {
        return positionFunPermMapper.get(id);
    }

    public int countAll() {
        return positionFunPermMapper.countAll();
    }

    public List<PositionFunPerm> find(Map<String, ?> params) {
        return positionFunPermMapper.find(params);
    }

    public int count(Map<String, ?> params) {
        return positionFunPermMapper.count(params);
    }
}
