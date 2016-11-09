package com.rain.boss.perm.controller;

import com.rain.boss.BaseController;
import com.rain.boss.annotation.UnLoginResource;
import com.rain.boss.exception.acceptable.UserLoginException;
import com.rain.boss.perm.biz.LoginBiz;
import com.rain.boss.perm.dto.UserDto;
import com.rain.boss.perm.entity.User;
import com.rain.boss.web.Resp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/boss")
public class LoginController extends BaseController {

    @Resource
    private LoginBiz loginBiz;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @UnLoginResource
    public String loginPage() {
        System.out.println("im /boss/login  get");
        return "boss/perm/login/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    @UnLoginResource
    public Resp login(User user) throws UserLoginException {
        UserDto userDto;
        userDto = loginBiz.doLogin(user);
//        } catch (UserLoginException e) {
//            return Resp.fail(e.getMessage());
        return Resp.success(userDto);
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainPage() {
        return "boss/perm/login/main";
    }


}
