package com.rain.boss.perm.service;

import com.rain.boss.baseClass.service.BaseService;
import com.rain.boss.perm.entity.User;
import com.rain.boss.perm.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User, UserMapper> {

    public User getByAccount(String userAccount) {
        return mapper.getByAccount(userAccount);
    }

}
