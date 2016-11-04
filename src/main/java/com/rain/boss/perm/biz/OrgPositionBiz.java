package com.rain.boss.perm.biz;

import com.rain.boss.perm.entity.OrgPosition;
import com.rain.boss.perm.service.OrgPositionService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class OrgPositionBiz {
    @Resource
    OrgPositionService orgPositionService;

    public int add(OrgPosition entity) {
        return orgPositionService.add(entity);
    }

    public int batchAdd(Collection<OrgPosition> entitys) {
        return orgPositionService.batchAdd(entitys);
    }

    public int delete(String id) {
        return orgPositionService.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return orgPositionService.deleteByIds(ids);
    }

    public int update(OrgPosition entity) {
        return orgPositionService.update(entity);
    }

    public OrgPosition get(String id) {
        return orgPositionService.get(id);
    }

    public int countAll() {
        return orgPositionService.countAll();
    }

    public List<OrgPosition> find(Map<String, ?> params) {
        return orgPositionService.find(params);
    }

    public int count(Map<String, ?> params) {
        return orgPositionService.count(params);
    }
}