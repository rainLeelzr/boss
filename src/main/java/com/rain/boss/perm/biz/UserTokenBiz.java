package com.rain.boss.perm.biz;

import com.rain.boss.perm.entity.UserToken;
import com.rain.boss.perm.service.UserTokenService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class UserTokenBiz {
    @Resource
    UserTokenService userTokenService;

    public int add(UserToken entity) {
        return userTokenService.add(entity);
    }

    public int batchAdd(Collection<UserToken> entitys) {
        return userTokenService.batchAdd(entitys);
    }

    public int delete(String id) {
        return userTokenService.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return userTokenService.deleteByIds(ids);
    }

    public int update(UserToken entity) {
        return userTokenService.update(entity);
    }

    public UserToken get(String id) {
        return userTokenService.get(id);
    }

    public int countAll() {
        return userTokenService.countAll();
    }

    public List<UserToken> find(Map<String, ?> params) {
        return userTokenService.find(params);
    }

    public int count(Map<String, ?> params) {
        return userTokenService.count(params);
    }
}