package com.rain.boss.interceptor;

import com.rain.boss.exception.acceptable.AcceptableException;
import com.rain.boss.interceptor.annotation.AnnotationCache;
import com.rain.boss.web.Message;
import com.rain.boss.web.Resp;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
@Order(1)
/*
 * ajax请求方面组件，如果controller层抛出异常，且是ajax请求和属于AcceptableException，则将异常信息用json格式返回给用户，而不是返回一个异常网页
 */
public class AjaxRequestExceptionHandler {

    @Resource
    private HttpServletRequest request;

    @Around("within(com.rain..*.controller.*)")
    public Object log(ProceedingJoinPoint p) throws Throwable {
        Object obj;
        try {
            obj = p.proceed();
        } catch (Exception e) {
            if (AnnotationCache.hasAnnotation(p, ResponseBody.class)) {
                if (e instanceof AcceptableException) {
                    return Resp.fail(e.getMessage());
                } else {
                    return Resp.fail(Message.sysException);
                }
            }

            //非ajax请求，则继续抛出异常
            if (e instanceof AcceptableException) {
                request.setAttribute("exceptionMsg", e.getMessage());
            } else {
                request.setAttribute("exceptionMsg", Message.sysException);
            }
            throw e;
        }

        // 目标组件的返回值，用来找转发页面
        return obj;
    }

}
