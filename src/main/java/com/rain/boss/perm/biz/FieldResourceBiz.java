package com.rain.boss.perm.biz;

import com.rain.boss.perm.entity.FieldResource;
import com.rain.boss.perm.service.FieldResourceService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class FieldResourceBiz {
    @Resource
    FieldResourceService fieldResourceService;

    public int add(FieldResource entity) {
        return fieldResourceService.add(entity);
    }

    public int batchAdd(Collection<FieldResource> entitys) {
        return fieldResourceService.batchAdd(entitys);
    }

    public int delete(String id) {
        return fieldResourceService.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return fieldResourceService.deleteByIds(ids);
    }

    public int update(FieldResource entity) {
        return fieldResourceService.update(entity);
    }

    public FieldResource get(String id) {
        return fieldResourceService.get(id);
    }

    public int countAll() {
        return fieldResourceService.countAll();
    }

    public List<FieldResource> find(Map<String, ?> params) {
        return fieldResourceService.find(params);
    }

    public int count(Map<String, ?> params) {
        return fieldResourceService.count(params);
    }
}