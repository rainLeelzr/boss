package com.rain.boss.perm.service;

import com.rain.boss.perm.entity.DataPerm;
import com.rain.boss.perm.mapper.DataPermMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class DataPermService {
    @Resource
    DataPermMapper dataPermMapper;

    public int add(DataPerm entity) {
        return dataPermMapper.add(entity);
    }

    public int batchAdd(Collection<DataPerm> entitys) {
        return dataPermMapper.batchAdd(entitys);
    }

    public int delete(String id) {
        return dataPermMapper.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return dataPermMapper.deleteByIds(ids);
    }

    public int update(DataPerm entity) {
        return dataPermMapper.update(entity);
    }

    public DataPerm get(String id) {
        return dataPermMapper.get(id);
    }

    public int countAll() {
        return dataPermMapper.countAll();
    }

    public List<DataPerm> find(Map<String, ?> params) {
        return dataPermMapper.find(params);
    }

    public int count(Map<String, ?> params) {
        return dataPermMapper.count(params);
    }
}
