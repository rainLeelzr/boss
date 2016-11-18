package com.rain.boss.perm.service;

import com.rain.boss.exception.acceptable.UserLoginException;
import com.rain.boss.perm.dto.UserDto;
import com.rain.boss.perm.entity.User;
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
    public void testDoLogin() throws UserLoginException {
        User user = new User();
        user.genId();
        user.setUserAccount("testDoLogin");
        user.setUserPwd("testDoLogin");
        userService.add(user);

        UserDto userDto = loginService.doLogin(user);
        Assert.assertEquals(user.getId(), userDto.getUserId());
    }
}
