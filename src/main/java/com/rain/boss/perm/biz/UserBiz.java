package com.rain.boss.perm.biz;

import com.rain.boss.BaseBiz;
import org.springframework.stereotype.Component;

import com.rain.boss.perm.entity.User;
import com.rain.boss.BaseMapper;
import com.rain.boss.BaseService;

@Component
public class UserBiz extends BaseBiz<BaseService<BaseMapper<User>, User>, User> {

}