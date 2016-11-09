package com.rain.boss.perm.biz;

import com.rain.boss.exception.acceptable.UserLoginException;
import com.rain.boss.perm.dto.UserDto;
import com.rain.boss.perm.entity.User;
import com.rain.boss.perm.entity.UserToken;
import com.rain.boss.perm.service.UserService;
import com.rain.boss.perm.service.UserTokenService;
import com.rain.boss.web.Message;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class LoginBiz {

    @Resource
    private UserService userService;

    @Resource
    private UserTokenService userTokenService;

    public UserDto doLogin(User user) throws UserLoginException {
        User _user = userService.getByAccountAndPwd(user.getUserAccount(), user.getUserPwd());
        if (_user == null) {
            throw new UserLoginException(Message.accountOrPwdError.getMessage());
        }

        UserToken userToken = userTokenService.create(_user);
        UserDto userDto = new UserDto(_user, userToken);
        return userDto;
    }
}
