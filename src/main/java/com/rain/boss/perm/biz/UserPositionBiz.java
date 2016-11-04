package com.rain.boss.perm.biz;

import com.rain.boss.perm.entity.UserPosition;
import com.rain.boss.perm.service.UserPositionService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class UserPositionBiz {
    @Resource
    UserPositionService userPositionService;

    public int add(UserPosition entity) {
        return userPositionService.add(entity);
    }

    public int batchAdd(Collection<UserPosition> entitys) {
        return userPositionService.batchAdd(entitys);
    }

    public int delete(String id) {
        return userPositionService.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return userPositionService.deleteByIds(ids);
    }

    public int update(UserPosition entity) {
        return userPositionService.update(entity);
    }

    public UserPosition get(String id) {
        return userPositionService.get(id);
    }

    public int countAll() {
        return userPositionService.countAll();
    }

    public List<UserPosition> find(Map<String, ?> params) {
        return userPositionService.find(params);
    }

    public int count(Map<String, ?> params) {
        return userPositionService.count(params);
    }
}