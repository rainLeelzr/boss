package com.rain.boss.perm.service;

import com.rain.boss.perm.entity.DataPermSet;
import com.rain.boss.perm.mapper.DataPermSetMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class DataPermSetService {
    @Resource
    DataPermSetMapper dataPermSetMapper;

    public int add(DataPermSet entity) {
        return dataPermSetMapper.add(entity);
    }

    public int batchAdd(Collection<DataPermSet> entitys) {
        return dataPermSetMapper.batchAdd(entitys);
    }

    public int delete(String id) {
        return dataPermSetMapper.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return dataPermSetMapper.deleteByIds(ids);
    }

    public int update(DataPermSet entity) {
        return dataPermSetMapper.update(entity);
    }

    public DataPermSet get(String id) {
        return dataPermSetMapper.get(id);
    }

    public int countAll() {
        return dataPermSetMapper.countAll();
    }

    public List<DataPermSet> find(Map<String, ?> params) {
        return dataPermSetMapper.find(params);
    }

    public int count(Map<String, ?> params) {
        return dataPermSetMapper.count(params);
    }
}
