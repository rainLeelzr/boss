package com.rain.boss.perm.mapper;

import com.rain.boss.annotation.MyBatisMapper;
import com.rain.boss.baseClass.mapper.BaseMapper;
import com.rain.boss.perm.entity.User;

@MyBatisMapper
public interface UserMapper extends BaseMapper<User> {

    User getByAccount(String userAccount);

}