package com.rain.boss.perm.service;

import com.rain.boss.baseClass.service.BaseService;
import com.rain.boss.perm.entity.User;
import com.rain.boss.perm.entity.UserToken;
import com.rain.boss.perm.mapper.UserTokenMapper;
import com.rain.boss.util.DateTimeUtils;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.UUID;

@Service
public class UserTokenService extends BaseService<UserToken, UserTokenMapper> {

    /**
     * 创建token并插入或更新数据库记录
     *
     * @param user 用户
     * @return UserToken 用户令牌
     */
//    public UserToken create(User user) {
//        String token = UUID.randomUUID().toString();
//
//        UserToken userToken = mapper.getByUserId(user.getId());
//        if (userToken != null) {
//            userToken.setToken(token);
//            userToken.setTokenCreateTime(DateTimeUtils.getCurrentDateTime());
//            userToken.setTokenExpireTime(DateTimeUtils.getNextMilliseconds(30, Calendar.MINUTE));
//
//            userToken.setUserId(null);
//            mapper.update(userToken);
//        } else {
//            userToken = new UserToken();
//            userToken.genId();
//            userToken.setUserId(user.getId());
//            userToken.setToken(token);
//            userToken.setTokenCreateTime(DateTimeUtils.getCurrentDateTime());
//            userToken.setTokenExpireTime(DateTimeUtils.getNextMilliseconds(30, Calendar.MINUTE));
//
//            mapper.add(userToken);
//        }
//
//        //查找
//        return userToken;
//    }

//    public UserToken getByToken(String token) {
//        return mapper.getByToken(token);
//    }
}
