package com.rain.boss.interceptor;

import com.rain.boss.annotation.UnLoginResource;
import com.rain.boss.exception.acceptable.UnLoginException;
import com.rain.boss.interceptor.annotation.AnnotationCache;
import com.rain.boss.perm.entity.UserToken;
import com.rain.boss.perm.service.UserTokenService;
import com.rain.boss.web.Message;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@Component
@Aspect
@Order(2)
/**
 * ajax请求方面组件，判断请求是否需要登录系统后，才能进行访问
 */
public class CheckUserLoginHandler {

    @Resource
    private UserTokenService userTokenService;

    @Resource
    private HttpServletRequest request;

    @Around("within(com.rain..*.controller.*)")
    public Object log(ProceedingJoinPoint p) throws Throwable {
        //如果是需要登录才能访问的请求，则判断是否已经登录
        if (!AnnotationCache.hasAnnotation(p, UnLoginResource.class)) {
            String token = request.getParameter("token");
            if (token == null || token.length() == 0) {
                throw new UnLoginException(Message.unLogin.getMessage());
            }
            UserToken userToken = userTokenService.getByToken(token);
            if (userToken == null) {
                throw new UnLoginException(Message.unLogin.getMessage());
            }

            //过期时间比现在的时间早，则token已过期
            Calendar now = Calendar.getInstance();
            Calendar expireTime = Calendar.getInstance();
            expireTime.setTimeInMillis(userToken.getTokenExpireTime());
            System.out.println(userToken.getTokenCreateTime());

            if (expireTime.before(now)) {
                throw new UnLoginException(Message.loginTimeout.getMessage());
            }

            //如果没有超时，则以现在为开始，加30分钟，更新到超时时间里
            now.add(Calendar.MINUTE, 30);
            userToken.setTokenExpireTime(now.getTimeInMillis());

            userToken.setTokenCreateTime(null);
            userToken.setToken(null);
            userTokenService.update(userToken);
        }

        return p.proceed();
    }

}
