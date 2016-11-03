package com.rain.boss.perm.biz;

import com.rain.boss.perm.entity.User;
import com.rain.boss.perm.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserBiz {
    @Resource
    UserService userService;

    public int add(User entity) {
        return userService.add(entity);
    }

    public int batchAdd(Collection<User> entitys) {
        return userService.batchAdd(entitys);
    }

    public int delete(String id) {
        return userService.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return userService.deleteByIds(ids);
    }

    public int update(User entity) {
        return userService.update(entity);
    }

    public User get(String id) {
        return userService.get(id);
    }

    public int countAll() {
        return userService.countAll();
    }

    public List<User> find(Map<String, ?> params) {
        return userService.find(params);
    }

    public List<User> findAll() {
        Map<String, ?> params = new HashMap<>();
        return userService.find(params);
    }

    public int count(Map<String, ?> params) {
        return userService.count(params);
    }
}