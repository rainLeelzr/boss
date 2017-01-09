package com.rain.boss.perm.controller;

import com.rain.boss.annotation.PublicResource;
import com.rain.boss.baseClass.BaseController;
import com.rain.boss.data.page.Page;
import com.rain.boss.perm.entity.User;
import com.rain.boss.perm.mapper.UserMapper;
import com.rain.boss.perm.service.UserService;
import com.rain.boss.web.Resp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

@Controller
@RequestMapping("/boss/perm")
public class UserController extends BaseController<User, UserMapper, UserService> {

    @RequestMapping(value = "/users/page", method = RequestMethod.GET)
    public String page() {
        return "boss/perm/users/page";
    }

    @RequestMapping(value = "/users/edit", method = RequestMethod.GET)
    @PublicResource
    public String edit() {
        return "boss/perm/users/edit";
    }

    @RequestMapping(value = "/users", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Resp users(User user, Page page) throws Exception {
        return commonEntityPage(user, page);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Resp getById(@PathVariable String id) throws IllegalAccessException, NoSuchMethodException,
            InvocationTargetException {
        User user = service.get(id);
        return Resp.success(user);
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Resp add(User user) {
        int count = service.add(user);
        return count == 1 ? Resp.success() : Resp.fail();
    }

    @RequestMapping(value = "/users/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Resp update(User user, HttpServletRequest request) {
        int count = service.update(user);
        return count == 1 ? Resp.success() : Resp.fail();
    }

    @RequestMapping(value = "/users/delete", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Resp delete(String ids) {
        return commonDelete(ids);
    }
}
