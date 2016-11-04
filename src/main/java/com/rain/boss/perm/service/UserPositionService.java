package com.rain.boss.perm.service;

import com.rain.boss.perm.entity.UserPosition;
import com.rain.boss.perm.mapper.UserPositionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class UserPositionService {
    @Resource
    UserPositionMapper userPositionMapper;

    public int add(UserPosition entity) {
        return userPositionMapper.add(entity);
    }

    public int batchAdd(Collection<UserPosition> entitys) {
        return userPositionMapper.batchAdd(entitys);
    }

    public int delete(String id) {
        return userPositionMapper.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return userPositionMapper.deleteByIds(ids);
    }

    public int update(UserPosition entity) {
        return userPositionMapper.update(entity);
    }

    public UserPosition get(String id) {
        return userPositionMapper.get(id);
    }

    public int countAll() {
        return userPositionMapper.countAll();
    }

    public List<UserPosition> find(Map<String, ?> params) {
        return userPositionMapper.find(params);
    }

    public int count(Map<String, ?> params) {
        return userPositionMapper.count(params);
    }
}
