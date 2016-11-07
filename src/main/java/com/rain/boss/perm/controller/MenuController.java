package com.rain.boss.perm.controller;

import com.rain.boss.BaseController;
import com.rain.boss.perm.biz.MenuBiz;
import com.rain.boss.perm.entity.Menu;
import com.rain.boss.web.Resp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/boss/perm")
public class MenuController extends BaseController {

    @Resource
    private MenuBiz menuBiz;

    @RequestMapping(value = "/menus/page", method = RequestMethod.GET)
    public String page() {
        return "boss/perm/menus/page";
    }

    @RequestMapping(value = "/menus", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Resp menus() {
        List<Menu> menus = menuBiz.findAll();
        System.out.println("/boss/user/list");
        return Resp.success(menus);
    }

    @RequestMapping(value = "/menus", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Resp add(Menu menu) {
        System.out.println(menu);
        int count = menuBiz.add(menu);
        return count == 1 ? Resp.success() : Resp.fail();
    }
}
