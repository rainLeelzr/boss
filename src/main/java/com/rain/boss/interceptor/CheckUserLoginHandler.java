package com.rain.boss.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rain.boss.annotation.PublicResource;
import com.rain.boss.exception.acceptable.UnLoginException;
import com.rain.boss.init.SysParam;
import com.rain.boss.interceptor.annotation.AnnotationCache;
import com.rain.boss.perm.dto.Token;
import com.rain.boss.perm.entity.User;
import com.rain.boss.perm.service.UserService;
import com.rain.boss.util.security.CryptoUtil;
import com.rain.boss.web.Message;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

@Component
@Aspect
@Order(2)
/*
 * 用户登录检查，如果是需要登录才能访问的资源，但是客户端未登录，则不允许继续访问业务逻辑
 */
public class CheckUserLoginHandler {

    @Resource
    UserService userService;

    @Around("within(com.rain..*.controller.*)")
    public Object check(ProceedingJoinPoint p) throws Throwable {
        //如果是需要登录才能访问的请求，则判断是否已经登录
        if (!AnnotationCache.hasAnnotation(p, PublicResource.class)) {
            //1：解密token，得到userId、expireTime、userAgent
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                    .getRequest();
            String token = request.getParameter(SysParam.TOKEN_KEY);
            if (StringUtils.isBlank(token)) {
                throw new UnLoginException(Message.unLogin.getMessage());
            }
            //get请求，参数含有+号会被转为空格，所以需要将空格转回+
            if (token.contains(" ")) {
                token = token.replaceAll(" ", "+");
            }
            token = CryptoUtil.aesDecrypt(token);
            ObjectMapper mapper = new ObjectMapper();
            Token t = mapper.readValue(token, Token.class);

            //2：根据userId是否能查找到用户
            User user = userService.get(t.getUserId());
            if (user == null) {
                throw new UnLoginException(Message.unLogin.getMessage());
            }

            //3：根据expireTime和服务器当前时间判断token是否已过期
            if (SysParam.TOKEN_EXPIRE_TIME > 0) {//配置的TOKEN_EXPIRE_TIME参数大于0时，才启用超时判断。等于0时，永不超时
                long now = System.currentTimeMillis();
                if (now > t.getExpireTime()) {
                    System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(t.getExpireTime()));
                    System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(now));
                    throw new UnLoginException(Message.tokenExpired.getMessage());
                }
            }

            //4：根据userAgent与请求头的userAgent判断是否相同
            String userAgent = request.getHeader("User-Agent");
            if (!t.getUserAgent().equals(userAgent)) {
                throw new UnLoginException(Message.userAgentNotMatch.getMessage());
            }

            //5：记录token验证日志

            //添加当前登录的信息到request，以便后续逻辑用到
            request.setAttribute(SysParam.REQ_LOGINUSER, user);
            request.setAttribute(SysParam.REQ_TOKEN, t);
        }

        return p.proceed();
    }

}
