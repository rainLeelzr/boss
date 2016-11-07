package com.rain.boss.perm.service;

import com.rain.boss.perm.entity.User;
import com.rain.boss.perm.entity.UserToken;
import com.rain.boss.perm.mapper.UserTokenMapper;
import com.rain.boss.util.DateTimeUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class UserTokenService {
    @Resource
    UserTokenMapper userTokenMapper;

    public int add(UserToken entity) {
        return userTokenMapper.add(entity);
    }

    public int batchAdd(Collection<UserToken> entitys) {
        return userTokenMapper.batchAdd(entitys);
    }

    public int delete(String id) {
        return userTokenMapper.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return userTokenMapper.deleteByIds(ids);
    }

    public int update(UserToken entity) {
        return userTokenMapper.update(entity);
    }

    public UserToken get(String id) {
        return userTokenMapper.get(id);
    }

    public int countAll() {
        return userTokenMapper.countAll();
    }

    public List<UserToken> find(Map<String, ?> params) {
        return userTokenMapper.find(params);
    }

    public int count(Map<String, ?> params) {
        return userTokenMapper.count(params);
    }

    public UserToken getByUserId(String userId) {
        return userTokenMapper.getByUserId(userId);
    }

    /**
     * 创建token并插入或更新数据库记录
     *
     * @param user 用户
     * @return UserToken 用户令牌
     */
    public UserToken create(User user) {
        String token = UUID.randomUUID().toString();

        UserToken userToken = userTokenMapper.getByUserId(user.getId());
        if (userToken != null) {
            userToken.setToken(token);
            userToken.setTokenCreateTime(DateTimeUtils.getCurrentDateTime());
            userToken.setTokenExpireTime(DateTimeUtils.getNextMilliseconds(30, Calendar.MINUTE));

            userToken.setUserId(null);
            userTokenMapper.update(userToken);
        } else {
            userToken = new UserToken();
            userToken.genId();
            userToken.setUserId(user.getId());
            userToken.setToken(token);
            userToken.setTokenCreateTime(DateTimeUtils.getCurrentDateTime());
            userToken.setTokenExpireTime(DateTimeUtils.getNextMilliseconds(30, Calendar.MINUTE));

            userTokenMapper.add(userToken);
        }

        //查找
        return userToken;
    }
}
