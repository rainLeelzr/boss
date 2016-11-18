package com.rain.boss.perm.mapper;

import com.rain.boss.annotation.MyBatisMapper;
import com.rain.boss.baseClass.mapper.BaseMapper;
import com.rain.boss.perm.entity.UserToken;

@MyBatisMapper
public interface UserTokenMapper extends BaseMapper<UserToken> {

    UserToken getByToken(String token);

    UserToken getByUserId(String id);
}