package com.rain.boss.perm.controller;

import com.rain.boss.annotation.PublicResource;
import com.rain.boss.baseClass.BaseController;
import com.rain.boss.data.page.Page;
import com.rain.boss.init.SysParam;
import com.rain.boss.perm.entity.Menu;
import com.rain.boss.perm.entity.User;
import com.rain.boss.perm.mapper.MenuMapper;
import com.rain.boss.perm.service.MenuService;
import com.rain.boss.web.Resp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Controller
@RequestMapping("/boss/perm")
public class MenuController extends BaseController<Menu, MenuMapper, MenuService> {

    @RequestMapping(value = "/menus/page", method = RequestMethod.GET)
    public String page() {
        return "boss/perm/menus/page";
    }

    @RequestMapping(value = "/menus/edit", method = RequestMethod.GET)
    @PublicResource
    public String edit() {
        return "boss/perm/menus/edit";
    }

    @RequestMapping(value = "/menus", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Resp menus(Menu menu, Page page) throws Exception {
        return commonEntityPage(menu, page);
    }

    @RequestMapping(value = "/menus/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Resp getById(@PathVariable String id) throws IllegalAccessException, NoSuchMethodException,
            InvocationTargetException {
        Menu menu = service.get(id);
        return Resp.success(menu);
    }

    @RequestMapping(value = "/menus/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Resp add(Menu menu) {
        int count = service.add(menu);
        return count == 1 ? Resp.success() : Resp.fail();
    }

    @RequestMapping(value = "/menus/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Resp update(Menu menu, HttpServletRequest request) {
        int count = service.update(menu);
        return count == 1 ? Resp.success() : Resp.fail();
    }

    @RequestMapping(value = "/menus/delete", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Resp delete(String ids) {
        return commonDelete(ids);
    }

    /**
     * 获取当前用户拥有权限的菜单集合
     *
     * @param request request
     * @return Resp
     * @throws Exception Exception
     */
    @RequestMapping(value = "/menus/mine", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Resp myMenus(HttpServletRequest request) throws Exception {
        User user = (User) request.getAttribute(SysParam.REQ_LOGINUSER);
        List<Menu> menus = service.findMyMenus(user.getId());
        return Resp.success(menus);
    }

    /**
     * 获取当前菜单的下一级子菜单,如果当前菜单id为空，则获取顶级菜单
     *
     * @param parentId 当前菜单id
     * @return Resp
     * @throws Exception Exception
     */
    @RequestMapping(value = "/menus/subs", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Resp subMenus(String id) throws Exception {
        List<Menu> menus = service.findSubMenus(id);
        return Resp.success(menus);
    }

    /**
     * 获取所有含有子菜单的父菜单
     *
     * @param request request
     * @return Resp
     * @throws Exception Exception
     */
    //@RequestMapping(value = "/menus/parents", produces = "application/json;charset=UTF-8")
    //@ResponseBody
    //public Resp parentMenus(HttpServletRequest request) throws Exception {
    //    User user = (User) request.getAttribute(SysParam.REQ_LOGINUSER);
    //    List<Menu> menus = service.findParents();
    //    return Resp.success(menus);
    //}
}
