package com.rain.boss.perm.service;

import com.rain.boss.perm.entity.DataPermGroup;
import com.rain.boss.perm.mapper.DataPermGroupMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class DataPermGroupService {
    @Resource
    DataPermGroupMapper dataPermGroupMapper;

    public int add(DataPermGroup entity) {
        return dataPermGroupMapper.add(entity);
    }

    public int batchAdd(Collection<DataPermGroup> entitys) {
        return dataPermGroupMapper.batchAdd(entitys);
    }

    public int delete(String id) {
        return dataPermGroupMapper.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return dataPermGroupMapper.deleteByIds(ids);
    }

    public int update(DataPermGroup entity) {
        return dataPermGroupMapper.update(entity);
    }

    public DataPermGroup get(String id) {
        return dataPermGroupMapper.get(id);
    }

    public int countAll() {
        return dataPermGroupMapper.countAll();
    }

    public List<DataPermGroup> find(Map<String, ?> params) {
        return dataPermGroupMapper.find(params);
    }

    public int count(Map<String, ?> params) {
        return dataPermGroupMapper.count(params);
    }
}
