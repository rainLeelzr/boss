package com.rain.boss.exception.system;

/**
 * 系统内部发生异常，此异常信息不应给用户直接看到，可输出“系统异常、网络异常”等泛化信息给用户。
 */
public class SystemException extends Exception {

    public SystemException() {
        super();
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(Throwable cause) {
        super(cause);
    }
}
