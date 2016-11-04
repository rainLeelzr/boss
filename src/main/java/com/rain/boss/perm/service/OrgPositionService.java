package com.rain.boss.perm.service;

import com.rain.boss.perm.entity.OrgPosition;
import com.rain.boss.perm.mapper.OrgPositionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class OrgPositionService {
    @Resource
    OrgPositionMapper orgPositionMapper;

    public int add(OrgPosition entity) {
        return orgPositionMapper.add(entity);
    }

    public int batchAdd(Collection<OrgPosition> entitys) {
        return orgPositionMapper.batchAdd(entitys);
    }

    public int delete(String id) {
        return orgPositionMapper.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return orgPositionMapper.deleteByIds(ids);
    }

    public int update(OrgPosition entity) {
        return orgPositionMapper.update(entity);
    }

    public OrgPosition get(String id) {
        return orgPositionMapper.get(id);
    }

    public int countAll() {
        return orgPositionMapper.countAll();
    }

    public List<OrgPosition> find(Map<String, ?> params) {
        return orgPositionMapper.find(params);
    }

    public int count(Map<String, ?> params) {
        return orgPositionMapper.count(params);
    }
}
