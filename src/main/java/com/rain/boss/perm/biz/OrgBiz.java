package com.rain.boss.perm.biz;

import com.rain.boss.perm.entity.Org;
import com.rain.boss.perm.service.OrgService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class OrgBiz {
    @Resource
    OrgService orgService;

    public int add(Org entity) {
        return orgService.add(entity);
    }

    public int batchAdd(Collection<Org> entitys) {
        return orgService.batchAdd(entitys);
    }

    public int delete(String id) {
        return orgService.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return orgService.deleteByIds(ids);
    }

    public int update(Org entity) {
        return orgService.update(entity);
    }

    public Org get(String id) {
        return orgService.get(id);
    }

    public int countAll() {
        return orgService.countAll();
    }

    public List<Org> find(Map<String, ?> params) {
        return orgService.find(params);
    }

    public int count(Map<String, ?> params) {
        return orgService.count(params);
    }
}