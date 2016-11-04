package com.rain.boss.perm.service;

import com.rain.boss.perm.entity.Position;
import com.rain.boss.perm.mapper.PositionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class PositionService {
    @Resource
    PositionMapper positionMapper;

    public int add(Position entity) {
        return positionMapper.add(entity);
    }

    public int batchAdd(Collection<Position> entitys) {
        return positionMapper.batchAdd(entitys);
    }

    public int delete(String id) {
        return positionMapper.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return positionMapper.deleteByIds(ids);
    }

    public int update(Position entity) {
        return positionMapper.update(entity);
    }

    public Position get(String id) {
        return positionMapper.get(id);
    }

    public int countAll() {
        return positionMapper.countAll();
    }

    public List<Position> find(Map<String, ?> params) {
        return positionMapper.find(params);
    }

    public int count(Map<String, ?> params) {
        return positionMapper.count(params);
    }
}
