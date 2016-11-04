package com.rain.boss.perm.biz;

import com.rain.boss.perm.entity.FunPerm;
import com.rain.boss.perm.service.FunPermService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class FunPermBiz {
    @Resource
    FunPermService funPermService;

    public int add(FunPerm entity) {
        return funPermService.add(entity);
    }

    public int batchAdd(Collection<FunPerm> entitys) {
        return funPermService.batchAdd(entitys);
    }

    public int delete(String id) {
        return funPermService.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return funPermService.deleteByIds(ids);
    }

    public int update(FunPerm entity) {
        return funPermService.update(entity);
    }

    public FunPerm get(String id) {
        return funPermService.get(id);
    }

    public int countAll() {
        return funPermService.countAll();
    }

    public List<FunPerm> find(Map<String, ?> params) {
        return funPermService.find(params);
    }

    public int count(Map<String, ?> params) {
        return funPermService.count(params);
    }
}