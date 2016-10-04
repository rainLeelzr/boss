package com.rain.boss.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.rain.boss.perm.entity.User;

/**
 * 登录检查拦截器，在用户访问除登录之外的任何 功能时，判断用户是否已经登录成功，若没有登录 则踢回登录页面。
 */
public class CheckUserLoginInterceptor implements HandlerInterceptor {

	/*
	 * 该方法在Controller业务方法前调用。 如果该方法返回true，则允许程序继续调用 Controller，否则不允许。
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object obj) throws Exception {
		User user = (User) request.getSession().getAttribute("");
		if (user == null) {
			response.sendRedirect(request.getContextPath()
					+ "/login/toLogin.do");
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
