package com.rain.boss.perm.service;

import com.rain.boss.BaseService;
import org.springframework.stereotype.Service;

import com.rain.boss.perm.entity.User;
import com.rain.boss.BaseMapper;

@Service
public class UserService extends BaseService<BaseMapper<User>, User> {
}
