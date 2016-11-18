package com.rain.boss.interceptor;

import com.rain.boss.perm.entity.UserToken;
import com.rain.boss.perm.service.UserTokenService;
import com.rain.boss.util.DateTimeUtils;
import com.rain.boss.util.Logger;
import com.rain.boss.util.SysConst;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 记录异常日志的方面组件， 在controller包中的类发生异常时记录其日志信息；
 */
@Component
@Aspect
@Order(2)
public class ExceptionLogger {

    @Resource
    private UserTokenService userTokenService;

    @Around("within(com.rain..*.controller.*)")
    public Object log(ProceedingJoinPoint p) throws Throwable {
        Object obj;
        try {
            obj = p.proceed();
        } catch (Throwable e) {
            StringBuffer sb = new StringBuffer();
            String userId = "未登录";
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                    .getRequest();
            String token = request.getParameter(SysConst.TOKEN_KEY);
            if (token != null && token.length() != 0) {
                UserToken userToken = userTokenService.getByToken(token);
                if (userToken != null) {
                    userId = userToken.getUserId();
                }
            }

            String ip = request.getRemoteHost();
            String now = DateTimeUtils.getCurrentDateTime();
            String className = p.getTarget().getClass().getName();
            String methodName = p.getSignature().getName();
            sb.append("用户id[").append(userId).append("],IP[").append(ip)
                    .append("],在[").append(now).append("],调用[")
                    .append(p.getSignature().toString()).append("]时，发生如下未捕捉异常：\n");

            StackTraceElement[] elems = e.getStackTrace();
            sb.append(e.toString()).append("\n");
            for (StackTraceElement elem : elems) {
                sb.append("\t").append(elem.toString()).append("\n");
            }

            Logger.error(sb.toString());

            throw e;
        }

        // 目标组件的返回值，用来找转发页面
        return obj;
    }

}
