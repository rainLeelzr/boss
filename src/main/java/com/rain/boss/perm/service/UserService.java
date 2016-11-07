package com.rain.boss.perm.service;

import com.rain.boss.perm.entity.User;
import com.rain.boss.perm.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Resource
    UserMapper userMapper;

    public int add(User entity) {
        return userMapper.add(entity);
    }

    public int batchAdd(Collection<User> entitys) {
        return userMapper.batchAdd(entitys);
    }

    public int delete(String id) {
        return userMapper.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return userMapper.deleteByIds(ids);
    }

    public int update(User entity) {
        return userMapper.update(entity);
    }

    public User get(String id) {
        return userMapper.get(id);
    }

    public User getByAccountAndPwd(String userAccount, String userPwd) {
        return userMapper.getByAccountAndPwd(userAccount, userPwd);
    }

    public int countAll() {
        return userMapper.countAll();
    }

    public List<User> find(Map<String, ?> params) {
        return userMapper.find(params);
    }

    public int count(Map<String, ?> params) {
        return userMapper.count(params);
    }
}
