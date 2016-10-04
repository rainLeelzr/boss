package com.rain.boss.perm.controller;

import javax.annotation.Resource;

import com.rain.boss.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rain.boss.perm.biz.UserBiz;

@Controller
@RequestMapping("/boss/user")
public class UserController extends BaseController {

	@Resource
	private UserBiz userBiz;

	@RequestMapping("/list")
	public String list() {
		System.err.println(userBiz.countAll());
		
		System.out.println("-----gdsg----dg0dsdgsdgdddddddddddddddddddddddddd000");
		System.out.println(234);

		return "list";

	}

	@RequestMapping("/lis2")
	public String list2() {
		System.err.println(userBiz.countAll());

		System.out.println("-s--s--21111111dd1111222");

		return "list";

	}


	@RequestMapping("/lis3")
	public String list3() {
		System.err.println(userBiz.countAll());

		System.out.println("-s--s--21111111dd1111222");

		return "list";

	}

}
