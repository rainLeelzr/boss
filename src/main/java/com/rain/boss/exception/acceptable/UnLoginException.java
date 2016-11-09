package com.rain.boss.exception.acceptable;

public class UnLoginException extends AcceptableException {

    public UnLoginException() {
        super();
    }

    public UnLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnLoginException(String message) {
        super(message);
    }

    public UnLoginException(Throwable cause) {
        super(cause);
    }

}
