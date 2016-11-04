package com.rain.boss.perm.biz;

import com.rain.boss.perm.entity.FieldPerm;
import com.rain.boss.perm.service.FieldPermService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class FieldPermBiz {
    @Resource
    FieldPermService fieldPermService;

    public int add(FieldPerm entity) {
        return fieldPermService.add(entity);
    }

    public int batchAdd(Collection<FieldPerm> entitys) {
        return fieldPermService.batchAdd(entitys);
    }

    public int delete(String id) {
        return fieldPermService.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return fieldPermService.deleteByIds(ids);
    }

    public int update(FieldPerm entity) {
        return fieldPermService.update(entity);
    }

    public FieldPerm get(String id) {
        return fieldPermService.get(id);
    }

    public int countAll() {
        return fieldPermService.countAll();
    }

    public List<FieldPerm> find(Map<String, ?> params) {
        return fieldPermService.find(params);
    }

    public int count(Map<String, ?> params) {
        return fieldPermService.count(params);
    }
}