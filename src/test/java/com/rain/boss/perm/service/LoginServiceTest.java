package com.rain.boss.perm.service;

import com.rain.boss.perm.dto.LoginUser;
import com.rain.boss.perm.entity.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @Test
    public void testDoLogin() throws Exception {
        //增加用户
        User user = new User();
        user.genId();
        user.setUserAccount("testDoLogin");
        String pwd = "testDoLogin";
        String pwdMd5 = DigestUtils.md5Hex(pwd);
        String pwdAndUserAccountMd5 = DigestUtils.md5Hex(pwdMd5 + user.getUserAccount());
        user.setUserPwd(pwdAndUserAccountMd5);
        userService.add(user);

        //模拟用户登录
        String realVCode = "testVCode";
        String mockVCode = "testVCode";
        String mockPwd = "testDoLogin";
        String mockPwdMd5 = DigestUtils.md5Hex(mockPwd);
        String mockPwdAndUserAccountMd5 = DigestUtils.md5Hex(mockPwdMd5 + user.getUserAccount());
        String mockMd5AndVCode = DigestUtils.md5Hex(mockPwdAndUserAccountMd5 + mockVCode);
        user.setUserPwd(mockMd5AndVCode);
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36";
        LoginUser loginUser = loginService.doLogin(user, mockVCode, realVCode, userAgent);

        //断言
        Assert.assertEquals(user.getId(), loginUser.getUserId());
    }
}
