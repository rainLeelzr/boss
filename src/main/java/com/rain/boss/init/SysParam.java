package com.rain.boss.init;

import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;

@Component
public class SysParam implements InitializingBean {
    // token
    public static String SECRET_KEY;// 秘钥

    public static String TOKEN_KEY = "token";// key

    public static int TOKEN_EXPIRE_TIME = -1;// 过期时间，单位：分钟

    // request Attribute
    public static String REQ_LOGINUSER = "req_loginUser";//登录的用户

    public static String REQ_LOGINORG = "req_loginOrg";//登录的用户所在的机构

    public static String REQ_TOKEN = "req_token";//登录的用户的token

    // 异常
    public static String EXCEPTION_MSG_KEY = "exceptionMsg";

    // 分页
    public static String PAGE_KEY = "page";

    // 验证码
    public static String V_CODE = "vCode";

    // 代码真实路径
    public static String REAL_PATH;

    // 树形结构的顶级记录的parentId为-1
    public static String topParentId = "-1";

    @Override
    public void afterPropertiesSet() throws Exception {
        XMLConfiguration config = new XMLConfiguration("sysParam.xml");

        // token秘钥
        SECRET_KEY = config.getString("token.secretKey");
        if (StringUtils.isBlank(SECRET_KEY)) {
            throw new RuntimeException("token.secretKey参数未配置");
        }

        // token过期时间
        TOKEN_EXPIRE_TIME = config.getInt("token.expireTime");
        if (TOKEN_EXPIRE_TIME == -1) {
            throw new RuntimeException("token.expireTime参数未配置");
        }

        // 代码真实路径
        URL url = this.getClass().getClassLoader().getResource("");
        System.out.println(url.getFile());
        File webRoot = new File(url.getFile().replace("/WEB-INF/classes", ""));
        if (webRoot.isDirectory()) {
            REAL_PATH = webRoot.getPath();
        }
        if (StringUtils.isBlank(REAL_PATH)) {
            throw new RuntimeException("REAL_PATH参数初始化错误。url：" + url.getPath() + " new File():" + webRoot.getPath());
        }

        System.out.println("sysParam:" + SECRET_KEY);

    }

}
