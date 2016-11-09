package com.rain.boss.perm.mapper;

import com.rain.boss.annotation.MyBatisMapper;
import com.rain.boss.perm.entity.UserToken;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@MyBatisMapper
public interface UserTokenMapper {
    int add(UserToken entity);

    int batchAdd(Collection<UserToken> entitys);

    int delete(String id);

    int deleteByIds(Collection<String> ids);

    int update(UserToken entity);

    UserToken get(String id);

    UserToken getByUserId(String userId);

    List<UserToken> find(Map<String, ?> params);

    int count(Map<String, ?> params);

    int countAll();

    UserToken getByToken(String token);
}