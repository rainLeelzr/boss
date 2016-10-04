package com.rain.boss;

import java.sql.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.rain.boss.util.DateEditor;

/**
 * 所有Controller的父类，用于封装一些公用的逻辑或算法。
 */
public class BaseController {

	// InitBinder注解的含义是，告诉Spring在请求
	// 开始时(调用Controller方法前)先调用这个方法。
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// 声明java.sql.Date类型的参数注入，
		// 由DateEditor来完成。
		binder.registerCustomEditor(Date.class, new DateEditor());
	}

}
