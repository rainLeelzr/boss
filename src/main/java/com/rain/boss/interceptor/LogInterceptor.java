package com.rain.boss.interceptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rain.boss.base.entity.RequestLog;
import com.rain.boss.base.service.RequestLogService;
import com.rain.boss.exception.acceptable.AcceptableException;
import com.rain.boss.exception.acceptable.UnLoginException;
import com.rain.boss.init.SysParam;
import com.rain.boss.interceptor.annotation.AnnotationCache;
import com.rain.boss.perm.entity.User;
import com.rain.boss.util.ClientUtils;
import com.rain.boss.util.DateTimeUtils;
import com.rain.boss.util.Logger;
import com.rain.boss.web.Message;
import com.rain.boss.web.Resp;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import static com.rain.boss.init.SysParam.REQ_LOGINUSER;

/**
 * 记录日志记录的方面组件。
 * 记录请求的接入和响应信息；
 * 在下层逻辑处理中，发生异常时记录其日志信息。
 *
 * 统一响应内容方面组件，如果controller层抛出异常，且是ajax请求和属于AcceptableException，则将异常信息用json格式返回给用户，而不是返回一个异常网页
 */
@Component
@Aspect
@Order(1)
public class LogInterceptor {

    @Autowired(required = false)
    private HttpServletRequest request;

    @Resource
    private RequestLogService requestLogService;

    @Around("within(com.rain..*.controller.*)")
    public Object log(ProceedingJoinPoint p) throws Throwable {
        RequestLog requestLog = new RequestLog();
        initRequestLog(requestLog);

        Object obj;
        try {
            obj = p.proceed();

            setRequestLogSuccess(requestLog, obj);
        } catch (Throwable e) {
            exceptionLog(p, requestLog, e);
            setRequestLogError(requestLog, e);

            //ajax请求，封装统一格式的异常信息返回给客户端
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
            if (e instanceof AcceptableException) {
                request.setAttribute(SysParam.EXCEPTION_MSG_KEY, e.getMessage());
            } else {
                request.setAttribute(SysParam.EXCEPTION_MSG_KEY, Message.sysException);
            }
            throw e;
        } finally {
            addRequestLog(requestLog);
        }
        return obj;
    }

    private void addRequestLog(RequestLog requestLog) {
        User user = (User) request.getAttribute(REQ_LOGINUSER);
        if (user == null) {
            requestLog.setUserId("");
            requestLog.setUserName("");
        } else {
            requestLog.setUserId(user.getId());
            requestLog.setUserName(user.getUserName());
        }

        requestLog.setResponseTime(Timestamp.from(Instant.now()));
        requestLogService.add(requestLog);
    }

    private void setRequestLogError(RequestLog requestLog, Throwable e) {
        requestLog.setResponseText(e.getMessage());
        requestLog.setReqResult("失败");
    }

    private void setRequestLogSuccess(RequestLog requestLog, Object obj) throws JsonProcessingException {
        if (obj instanceof String) {
            requestLog.setResponseText((String) obj);
        } else {
            requestLog.setResponseText(new ObjectMapper().writeValueAsString(obj));
        }
        requestLog.setReqResult("成功");
    }

    private void exceptionLog(ProceedingJoinPoint p, RequestLog requestLog, Throwable e) {
        StringBuilder sb = new StringBuilder();
        String userId = "未登录";

        User user = (User) request.getAttribute(REQ_LOGINUSER);
        if (user == null) {
            user = new User();
        }

        String now = DateTimeUtils.getCurrentDateTime();
        String className = p.getTarget().getClass().getName();
        String methodName = p.getSignature().getName();

        sb.append("用户id[")
                .append(user.getId())
                .append("],IP[")
                .append(requestLog.getClientIp())
                .append("],在[")
                .append(now)
                .append("],调用[")
                .append(p.getSignature().toString())
                .append("]时，发生如下未捕捉异常：\n");

        StackTraceElement[] elems = e.getStackTrace();
        sb.append(e.toString()).append("\n");
        for (StackTraceElement elem : elems) {
            sb.append("\t").append(elem.toString()).append("\n");
        }

        Logger.error(sb.toString());
    }

    private void initRequestLog(RequestLog requestLog) {
        requestLog.genId();
        requestLog.setClientIp(ClientUtils.getIpAddress(request));
        requestLog.setRequestTime(Timestamp.from(Instant.now()));
        requestLog.setReqMethod(request.getMethod());
        requestLog.setReqUri(request.getRequestURI());
        requestLog.setUserAgent(request.getHeader("User-Agent"));

        Map<String, String> map = new HashMap<>();
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String[] values = request.getParameterValues(paramName);
            if (values.length == 1) {
                map.put(paramName, values[0]);
            } else {
                map.put(paramName, Arrays.toString(values));
            }

        }
        requestLog.setReqParam(map.toString());
    }

}
