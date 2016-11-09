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

}
