package com.rain.boss.perm.service;

import com.rain.boss.perm.entity.PositionFunPermDataPermSet;
import com.rain.boss.perm.mapper.PositionFunPermDataPermSetMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class PositionFunPermDataPermSetService {
    @Resource
    PositionFunPermDataPermSetMapper positionFunPermDataPermSetMapper;

    public int add(PositionFunPermDataPermSet entity) {
        return positionFunPermDataPermSetMapper.add(entity);
    }

    public int batchAdd(Collection<PositionFunPermDataPermSet> entitys) {
        return positionFunPermDataPermSetMapper.batchAdd(entitys);
    }

    public int delete(String id) {
        return positionFunPermDataPermSetMapper.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return positionFunPermDataPermSetMapper.deleteByIds(ids);
    }

    public int update(PositionFunPermDataPermSet entity) {
        return positionFunPermDataPermSetMapper.update(entity);
    }

    public PositionFunPermDataPermSet get(String id) {
        return positionFunPermDataPermSetMapper.get(id);
    }

    public int countAll() {
        return positionFunPermDataPermSetMapper.countAll();
    }

    public List<PositionFunPermDataPermSet> find(Map<String, ?> params) {
        return positionFunPermDataPermSetMapper.find(params);
    }

    public int count(Map<String, ?> params) {
        return positionFunPermDataPermSetMapper.count(params);
    }
}
