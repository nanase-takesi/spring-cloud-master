package com.shengda.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author takesi
 * @date 2019-12-23
 */
public class DateUtils {

    /**
     * 时间戳转换成date
     *
     * @param time time
     * @return date
     */
    public static Date parseLongToDate(Long time) {
        return new Date(time);
    }

    /**
     * 格式化日期
     *
     * @param date date
     * @param sdf  sdf
     * @return str
     */
    public static String parseDateToString(Date date, SimpleDateFormat sdf) {
        return sdf.format(date);
    }

    public static String parseDateToString(SimpleDateFormat sdf) {
        return parseDateToString(new Date(), sdf);
    }

    public static Long currentDateTime() {
        return System.currentTimeMillis();
    }
}
