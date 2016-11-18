package com.rain.boss.perm.controller;

import com.rain.boss.annotation.UnLoginResource;
import com.rain.boss.exception.acceptable.UserLoginException;
import com.rain.boss.perm.dto.UserDto;
import com.rain.boss.perm.entity.User;
import com.rain.boss.perm.service.LoginService;
import com.rain.boss.web.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/boss")
public class LoginController {

    @Autowired
    private LoginService service;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @UnLoginResource
    public String loginPage() {
        return "boss/perm/login/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    @UnLoginResource
    public Resp login(User user) throws UserLoginException {
        UserDto userDto;
        userDto = service.doLogin(user);
        return Resp.success(userDto);
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainPage() {
        return "boss/perm/login/main";
    }

    @RequestMapping(value = "/heartbeat", method = RequestMethod.GET)
    @ResponseBody
    public Resp heartbeat() throws UserLoginException {
        return Resp.success();
    }

}
