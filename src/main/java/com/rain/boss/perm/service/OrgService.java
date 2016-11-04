package com.rain.boss.perm.service;

import com.rain.boss.perm.entity.Org;
import com.rain.boss.perm.mapper.OrgMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class OrgService {
    @Resource
    OrgMapper orgMapper;

    public int add(Org entity) {
        return orgMapper.add(entity);
    }

    public int batchAdd(Collection<Org> entitys) {
        return orgMapper.batchAdd(entitys);
    }

    public int delete(String id) {
        return orgMapper.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return orgMapper.deleteByIds(ids);
    }

    public int update(Org entity) {
        return orgMapper.update(entity);
    }

    public Org get(String id) {
        return orgMapper.get(id);
    }

    public int countAll() {
        return orgMapper.countAll();
    }

    public List<Org> find(Map<String, ?> params) {
        return orgMapper.find(params);
    }

    public int count(Map<String, ?> params) {
        return orgMapper.count(params);
    }
}
