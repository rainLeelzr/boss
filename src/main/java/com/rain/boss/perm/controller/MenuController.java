package com.rain.boss.perm.controller;

import com.rain.boss.baseClass.BaseController;
import com.rain.boss.perm.entity.Menu;
import com.rain.boss.perm.mapper.MenuMapper;
import com.rain.boss.perm.service.MenuService;
import com.rain.boss.web.Resp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/boss/perm")
public class MenuController extends BaseController<Menu, MenuMapper, MenuService> {

    @RequestMapping(value = "/menus/page", method = RequestMethod.GET)
    public String page() {
        return "boss/perm/menus/page";
    }

    @RequestMapping(value = "/menus", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Resp menus() {
        return Resp.success();
    }

    @RequestMapping(value = "/menus", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Resp add(Menu menu) {
        int count = service.add(menu);
        return count == 1 ? Resp.success() : Resp.fail();
    }
}
