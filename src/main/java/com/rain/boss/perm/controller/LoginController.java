package com.rain.boss.perm.controller;

import com.rain.boss.BaseController;
import com.rain.boss.perm.biz.UserBiz;
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
    private UserBiz userBiz;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "boss/perm/login/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login() {
        return "redirect:/boss/main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainPage() {
        return "boss/perm/login/main";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Resp add(User user) {
        System.out.println(user);
        int count = userBiz.add(user);
        return count == 1 ? Resp.success() : Resp.fail();
    }
}
