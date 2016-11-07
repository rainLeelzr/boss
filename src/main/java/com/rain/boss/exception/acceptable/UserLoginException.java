package com.rain.boss.exception.acceptable;

public class UserLoginException extends AcceptableException {

    public UserLoginException() {
        super();
    }

    public UserLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserLoginException(String message) {
        super(message);
    }

    public UserLoginException(Throwable cause) {
        super(cause);
    }

    /**
     * 用户名或密码错误
     *
     * @return UserLoginException
     */
    public static UserLoginException accountOrPwdError() {
        return new UserLoginException("用户名或密码错误");
    }
}
