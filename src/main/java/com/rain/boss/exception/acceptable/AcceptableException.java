package com.rain.boss.exception.acceptable;


/**
 * 用户可接收的异常，可以直接输出异常信息给用户。例如登录时的用户名或密码错误等异常。
 */
public class AcceptableException extends Exception {

    public AcceptableException() {
        super();
    }

    public AcceptableException(String message, Throwable cause) {
        super(message, cause);
    }

    public AcceptableException(String message) {
        super(message);
    }

    public AcceptableException(Throwable cause) {
        super(cause);
    }

    /**
     * 用户名或密码错误
     *
     * @return UserLoginException
     */
    public static AcceptableException accountOrPwdError() {
        return new AcceptableException("用户名或密码错误");
    }
}
