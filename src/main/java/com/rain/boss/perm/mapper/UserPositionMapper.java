package com.rain.boss.perm.mapper;

import com.rain.boss.annotation.MyBatisMapper;
import com.rain.boss.perm.entity.UserPosition;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@MyBatisMapper
public interface UserPositionMapper {
    int add(UserPosition entity);

    int batchAdd(Collection<UserPosition> entitys);

    int delete(String id);

    int deleteByIds(Collection<String> ids);

    int update(UserPosition entity);

    UserPosition get(String id);

    List<UserPosition> find(Map<String, ?> params);

    int count(Map<String, ?> params);

    int countAll();
}