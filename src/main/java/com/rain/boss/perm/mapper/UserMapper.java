package com.rain.boss.perm.mapper;

import com.rain.boss.annotation.MyBatisMapper;
import com.rain.boss.perm.entity.User;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@MyBatisMapper
public interface UserMapper {
    int add(User entity);

    int batchAdd(Collection<User> entitys);

    int delete(String id);

    int deleteByIds(Collection<String> ids);

    int update(User entity);

    User get(String id);

    User getByAccountAndPwd(String userAccount, String userPwd);

    List<User> find(Map<String, ?> params);

    int count(Map<String, ?> params);

    int countAll();
}