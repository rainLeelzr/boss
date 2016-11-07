package com.rain.boss.interceptor;

import com.rain.boss.web.Resp;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Aspect
@Order(1)
/**
 * ajax请求方面组件，如果controller层抛出异常，切是ajax请求，则将异常信息用json格式返回给用户，而不是返回一个异常网页
 */
public class AjaxRequestExceptionHandler {

    private static final String ajaxAnnotation = "org.springframework.web.bind.annotation.ResponseBody";
    /**
     * 缓存本系统中controller层的ajax方法
     * key：包名.类名.方法名()
     */
    private static final List<String> ajaxClassMethods = Collections.synchronizedList(new ArrayList<String>());
    @Resource
    private HttpServletRequest request;

    @Around("within(com.rain..*.controller.*)")
    public Object log(ProceedingJoinPoint p) throws Throwable {
        Object obj;
        try {
            obj = p.proceed();
        } catch (Throwable e) {
            Signature signature = p.getSignature();
            String fullMethodName = signature.toString();

            //缓存中包含此方法，则是ajax请求
            if (ajaxClassMethods.contains(fullMethodName)) {
                return Resp.fail(e.getMessage());
            }

            //缓存中没有此方法，则判断此方法是否ajax
            if (isAjaxMethod(signature)) {
                ajaxClassMethods.add(fullMethodName);
                return Resp.fail(e.getMessage());
            }

            //非ajax请求，继续抛出异常
            throw e;
        }

        // 目标组件的返回值，用来找转发页面
        return obj;
    }

    /**
     * 判断signature是否ajax请求
     *
     * @param signature 方法签名
     * @return boolean
     */
    private boolean isAjaxMethod(Signature signature) throws ClassNotFoundException {
        Class<?> controllerClass = Class.forName(signature.getDeclaringTypeName());
        Method[] methods = controllerClass.getDeclaredMethods();
        for (Method method : methods) {
            Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
            for (Annotation annotation : declaredAnnotations) {
                Class<? extends Annotation> aClass = annotation.annotationType();
                if (ajaxAnnotation.equals(aClass.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

}
