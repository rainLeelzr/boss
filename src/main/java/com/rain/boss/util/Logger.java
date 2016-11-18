package com.rain.boss.util;

import org.slf4j.LoggerFactory;

public class Logger {
    //< DEBUG < INFO < WARN < ERROR
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);

    /**
     * 功能：虽然发生错误事件，但仍然不影响系统的继续运行。
     */
    public static void error(String message) {
        if (logger.isErrorEnabled()) {
            logger.error(message);
        }
    }

    /**
     * 功能：虽然发生错误事件，但仍然不影响系统的继续运行。
     */
    public static void error(String message, Object... params) {
        if (logger.isErrorEnabled()) {
            logger.error(message, params);
        }
    }

    /**
     * 功能：系统会出现潜在错误的情形
     */
    public static void warn(String message) {
        if (logger.isWarnEnabled()) {
            logger.warn(message);
        }
    }

    /**
     * 功能：系统会出现潜在错误的情形
     */
    public static void warn(String message, Object... params) {
        if (logger.isWarnEnabled()) {
            logger.warn(message, params);
        }
    }

    /**
     * 功能：系统正常运行时的业务的操作和逻辑记录
     */
    public static void info(String message) {
        if (logger.isInfoEnabled()) {
            logger.info(message);
        }
    }

    /**
     * 功能：系统正常运行时的业务的操作和逻辑记录
     */
    public static void info(String message, Object... params) {
        if (logger.isInfoEnabled()) {
            logger.info(message, params);
        }
    }

    /**
     * 功能：开发时调试使用，生产环境不建议调到debug模式
     */
    public static void debug(String message) {
        if (logger.isDebugEnabled()) {
            logger.debug(message);
        }
    }

    /**
     * 功能：开发时调试使用，生产环境不建议调到debug模式
     */
    public static void debug(String message, Object... params) {
        if (logger.isDebugEnabled()) {
            logger.debug(message, params);
        }
    }
}
