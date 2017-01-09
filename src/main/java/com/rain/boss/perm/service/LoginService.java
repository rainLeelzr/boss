package com.rain.boss.perm.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rain.boss.exception.acceptable.UserLoginException;
import com.rain.boss.init.SysParam;
import com.rain.boss.perm.dto.LoginUser;
import com.rain.boss.perm.dto.Token;
import com.rain.boss.perm.entity.User;
import com.rain.boss.util.security.CryptoUtil;
import com.rain.boss.web.Message;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class LoginService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserTokenService userTokenService;

    public LoginUser doLogin(User user, String vCode, String realVCode, String userAgent) throws Exception {
        //1：验证码是否正确
        if (StringUtils.isBlank(realVCode) || !realVCode.equalsIgnoreCase(vCode)) {
            throw new UserLoginException(Message.vCodeError.getMessage());
        }
        //2：根据userAccount是否能查找到userId
        User userInSystem = userService.getByAccount(user.getUserAccount());
        if (userInSystem == null) {
            throw new UserLoginException(Message.accountOrPwdError.getMessage());
        }

        //3：执行 md5(数据库uesrPwd + vCode)，是否前台的userPwd相等
        String dbPwdAndVCodeMd5 = DigestUtils.md5Hex(userInSystem.getUserPwd() + vCode);
        if (!(dbPwdAndVCodeMd5.length() > 0) || !dbPwdAndVCodeMd5.equals(user.getUserPwd())) {
            throw new UserLoginException(Message.accountOrPwdError.getMessage());
        }

        //4：计算expireTime
        long expireTime = 0;
        if (SysParam.TOKEN_EXPIRE_TIME > 0) {
            expireTime = System.currentTimeMillis() + (60 * 1000 * SysParam.TOKEN_EXPIRE_TIME);
        }
//        System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(now)));

        //5：加密userId + expireTime + userAgent
        Token t = new Token(userInSystem.getId(), expireTime, userAgent);
        ObjectMapper mapper = new ObjectMapper();
        String Json = mapper.writeValueAsString(t);
        String token = CryptoUtil.aesEncrypt(Json);

        //6：记录登录验证

        //7：返回结果
        LoginUser loginUser = new LoginUser(userInSystem, token);
        return loginUser;
    }

    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        now = now + (60 * 30 * 1000);
        System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(now)));
        System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(1152494699000L)));
        System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(1476674948118L)));
        System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(1483174860885L)));
    }
}
