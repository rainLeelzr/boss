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
import java.util.List;

@Controller
@RequestMapping("/boss/perm")
public class UserController extends BaseController {

    @Resource
    private UserBiz userBiz;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String page() {
        System.out.println("/boss/perm/user/page");
        return "boss/perm/user/page";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Resp users() {
        List<User> users = userBiz.findAll();
        System.out.println("/boss/user/list");
        return Resp.success(users);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Resp add(User user) {
        System.out.println(user);
        int count = userBiz.add(user);
        return count == 1 ? Resp.success() : Resp.fail();
    }
}
