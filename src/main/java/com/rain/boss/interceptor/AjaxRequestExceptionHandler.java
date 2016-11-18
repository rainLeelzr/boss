package com.rain.boss.interceptor;

import com.rain.boss.exception.acceptable.AcceptableException;
import com.rain.boss.exception.acceptable.UnLoginException;
import com.rain.boss.interceptor.annotation.AnnotationCache;
import com.rain.boss.util.SysConst;
import com.rain.boss.web.Message;
import com.rain.boss.web.Resp;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
@Order(1)
/*
 * ajax请求方面组件，如果controller层抛出异常，且是ajax请求和属于AcceptableException，则将异常信息用json格式返回给用户，而不是返回一个异常网页
 */
public class AjaxRequestExceptionHandler {

    @Around("within(com.rain..*.controller.*)")
    public Object exceptionHandler(ProceedingJoinPoint p) throws Throwable {
        Object obj;
        try {
            obj = p.proceed();
        } catch (Exception e) {
            if (AnnotationCache.hasAnnotation(p, ResponseBody.class)) {
                if (e instanceof UnLoginException) {
                    return Resp.fail(Message.unLogin);
                } else if (e instanceof AcceptableException) {
                    return Resp.fail(e.getMessage());
                } else {
                    return Resp.fail(Message.sysException);
                }
            }

            //非ajax请求，则继续抛出异常
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                    .getRequest();
            if (e instanceof AcceptableException) {
                request.setAttribute(SysConst.EXCEPTION_MSG_KEY, e.getMessage());
            } else {
                request.setAttribute(SysConst.EXCEPTION_MSG_KEY, Message.sysException);
            }
            throw e;
        }

        // 目标组件的返回值，用来找转发页面
        return obj;
    }

}
