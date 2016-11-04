package com.rain.boss.perm.biz;

import com.rain.boss.perm.entity.Position;
import com.rain.boss.perm.service.PositionService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class PositionBiz {
    @Resource
    PositionService positionService;

    public int add(Position entity) {
        return positionService.add(entity);
    }

    public int batchAdd(Collection<Position> entitys) {
        return positionService.batchAdd(entitys);
    }

    public int delete(String id) {
        return positionService.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return positionService.deleteByIds(ids);
    }

    public int update(Position entity) {
        return positionService.update(entity);
    }

    public Position get(String id) {
        return positionService.get(id);
    }

    public int countAll() {
        return positionService.countAll();
    }

    public List<Position> find(Map<String, ?> params) {
        return positionService.find(params);
    }

    public int count(Map<String, ?> params) {
        return positionService.count(params);
    }
}