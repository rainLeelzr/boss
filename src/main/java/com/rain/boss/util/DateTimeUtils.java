package com.rain.boss.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils {

    private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static String getCurrentDateTime() {
        return dateTimeFormat.format(new Date());
    }

    public static String getCurrentDate() {
        return dateFormat.format(new Date());
    }

    public static String getCurrentDate(String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(new Date());
    }

    /**
     * 获取下一个时间点的毫秒数
     *
     * @param next 下一个时间点
     * @param unit 下一个时间点的单位
     * @return
     */
    public static long getNextMilliseconds(int next, int unit) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(unit, next);
        return calendar.getTimeInMillis();
    }
}
