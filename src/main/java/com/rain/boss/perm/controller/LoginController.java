package com.rain.boss.perm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rain.boss.annotation.PublicResource;
import com.rain.boss.init.SysParam;
import com.rain.boss.perm.dto.LoginUser;
import com.rain.boss.perm.dto.Token;
import com.rain.boss.perm.entity.User;
import com.rain.boss.perm.service.LoginService;
import com.rain.boss.perm.service.UserService;
import com.rain.boss.util.security.CryptoUtil;
import com.rain.boss.web.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/boss")
public class LoginController {

    @Autowired
    private LoginService service;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @PublicResource
    public String loginPage(HttpSession session) {
        session.setAttribute(SysParam.V_CODE, "3");
        return "boss/perm/login/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    @PublicResource
    public Resp login(HttpSession session, HttpServletRequest request, User user, String vCode) throws Exception {
        LoginUser loginUser;
        try {
            loginUser = service.doLogin(user, vCode, (String) session.getAttribute("vCode"), request.getHeader("User-Agent"));
        } finally {
            session.removeAttribute(SysParam.V_CODE);
        }
        return Resp.success(loginUser);
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    @PublicResource
    public String mainPage() {
        return "boss/perm/login/main";
    }

    @RequestMapping(value = "/login/reToken")
    @ResponseBody
    public Resp reToken(HttpServletRequest request) throws Exception {
        Token t = (Token) request.getAttribute(SysParam.REQ_TOKEN);
        t.setExpireTime(System.currentTimeMillis());

        return Resp.success(CryptoUtil.aesEncrypt(new ObjectMapper().writeValueAsString(t)));
    }

}
