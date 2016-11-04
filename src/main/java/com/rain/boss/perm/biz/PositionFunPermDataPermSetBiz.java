package com.rain.boss.perm.biz;

import com.rain.boss.perm.entity.PositionFunPermDataPermSet;
import com.rain.boss.perm.service.PositionFunPermDataPermSetService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class PositionFunPermDataPermSetBiz {
    @Resource
    PositionFunPermDataPermSetService positionFunPermDataPermSetService;

    public int add(PositionFunPermDataPermSet entity) {
        return positionFunPermDataPermSetService.add(entity);
    }

    public int batchAdd(Collection<PositionFunPermDataPermSet> entitys) {
        return positionFunPermDataPermSetService.batchAdd(entitys);
    }

    public int delete(String id) {
        return positionFunPermDataPermSetService.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return positionFunPermDataPermSetService.deleteByIds(ids);
    }

    public int update(PositionFunPermDataPermSet entity) {
        return positionFunPermDataPermSetService.update(entity);
    }

    public PositionFunPermDataPermSet get(String id) {
        return positionFunPermDataPermSetService.get(id);
    }

    public int countAll() {
        return positionFunPermDataPermSetService.countAll();
    }

    public List<PositionFunPermDataPermSet> find(Map<String, ?> params) {
        return positionFunPermDataPermSetService.find(params);
    }

    public int count(Map<String, ?> params) {
        return positionFunPermDataPermSetService.count(params);
    }
}