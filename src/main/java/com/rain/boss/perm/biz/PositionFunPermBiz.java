package com.rain.boss.perm.biz;

import com.rain.boss.perm.entity.PositionFunPerm;
import com.rain.boss.perm.service.PositionFunPermService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class PositionFunPermBiz {
    @Resource
    PositionFunPermService positionFunPermService;

    public int add(PositionFunPerm entity) {
        return positionFunPermService.add(entity);
    }

    public int batchAdd(Collection<PositionFunPerm> entitys) {
        return positionFunPermService.batchAdd(entitys);
    }

    public int delete(String id) {
        return positionFunPermService.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return positionFunPermService.deleteByIds(ids);
    }

    public int update(PositionFunPerm entity) {
        return positionFunPermService.update(entity);
    }

    public PositionFunPerm get(String id) {
        return positionFunPermService.get(id);
    }

    public int countAll() {
        return positionFunPermService.countAll();
    }

    public List<PositionFunPerm> find(Map<String, ?> params) {
        return positionFunPermService.find(params);
    }

    public int count(Map<String, ?> params) {
        return positionFunPermService.count(params);
    }
}