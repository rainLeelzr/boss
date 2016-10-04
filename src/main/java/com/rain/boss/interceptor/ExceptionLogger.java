package com.rain.boss.interceptor;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.rain.boss.perm.entity.User;

/**
 * 记录异常日志的方面组件， 在系统发生异常时记录其日志信息；
 */
//@Component
@Aspect
public class ExceptionLogger {

	@Resource
	private HttpServletRequest request;

	@Around("within(com.rain..*)")
	public Object log(ProceedingJoinPoint p) {
		Object obj = null;
		try {
			obj = p.proceed();
		} catch (Throwable e) {
			// 记录日志
			StringBuffer sb = new StringBuffer();

			User player = (User) request.getSession().getAttribute("admin");
			if (player != null) {
				String adminCode = player.getUserAccount();
				String ip = request.getRemoteHost();
				String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.format(new Date());
				String className = p.getTarget().getClass().getName();
				String methodName = p.getSignature().getName();
				sb.append("用户[").append(adminCode).append("],IP[").append(ip)
						.append("],在[").append(now).append("],调用[")
						.append(className).append(".").append(methodName)
						.append("()]时，发生如下未捕捉异常：\n");
			}

			StackTraceElement[] elems = e.getStackTrace();
			sb.append(e.toString()).append("\n");
			for (StackTraceElement elem : elems) {
				sb.append("\t").append(elem.toString()).append("\n");
			}

			Logger logger = Logger.getLogger(ExceptionLogger.class.getName());
			logger.error(sb.toString());

			// 记录完日志后，将异常抛出，由ExceptionResolver继续处理异常
			throw new RuntimeException(e);
		}

		// 目标组件的返回值，用来找转发页面
		return obj;
	}

}
