package com.rain.boss.perm.controller;

import com.rain.boss.baseClass.BaseController;
import com.rain.boss.data.page.Page;
import com.rain.boss.data.page.PaginationData;
import com.rain.boss.perm.entity.User;
import com.rain.boss.perm.mapper.UserMapper;
import com.rain.boss.perm.service.UserService;
import com.rain.boss.util.PropertyUtils;
import com.rain.boss.util.SysConst;
import com.rain.boss.web.Resp;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("/boss/perm")
public class UserController extends BaseController<User, UserMapper, UserService> {

    @RequestMapping(value = "/users/page", method = RequestMethod.GET)
    public String page() {
        return "boss/perm/users/page";
    }

    @RequestMapping(value = "/users/edit", method = RequestMethod.GET)
    public String edit() {
        return "boss/perm/users/edit";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Resp users(User user, Page page) throws IllegalAccessException, NoSuchMethodException,
            InvocationTargetException {
        //字段查询参数
        Map<String, Object> params = PropertyUtils.describeWithoutNull(user);

        //分页查询参数
        page.calculate();
        params.put(SysConst.PAGE_KEY, page);

        PaginationData users = service.findPage(params);
        return Resp.success(users);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Resp getUserById(@PathVariable String id) throws IllegalAccessException, NoSuchMethodException,
            InvocationTargetException {
        User user = service.get(id);
        return Resp.success(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Resp add(User user) {
        int count = service.add(user);
        return count == 1 ? Resp.success() : Resp.fail();
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Resp update(User user, HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        int count = service.update(user);
        return count == 1 ? Resp.success() : Resp.fail();
    }

    @RequestMapping(value = "/users/{ids}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Resp delete(@PathVariable String ids) {
        if (StringUtils.isEmpty(ids)) {
            return Resp.fail("参数错误，ids为空");
        }
        String[] idArr = ids.split(",");
        if (idArr.length == 1) {
            int count = service.delete(ids);
            return count == 1 ? Resp.success() : Resp.fail();
        } else {
            int count = service.deleteByIds(Arrays.asList(idArr));
            return count == idArr.length ? Resp.success() : Resp.fail();
        }
    }
}
