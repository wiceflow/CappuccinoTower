package com.helper;

import com.util.DateUtil;

import java.util.Date;

/**
 * Created by chen on 2017/9/20.
 * 日期操作助手类
 */
public final class DateHelper {

    /**
     * 获得指定日期的所在的那一周的周一
     * @param date [Date]指定日期
     * @return
     */
    public static Date getMonday(Date date) {
        return getDayOfWeek(date, 1);
    }

    /**
     * 获得指定日期的所在的那一周的周日
     * @param date [Date]指定日期
     * @return
     */
    public static Date getSunday(Date date) {
        return getDayOfWeek(date, 7);
    }

    /**
     * 获得指定日期所在的那一周的星期几
     * @param date [Date]指定日期
     * @param dayOfWeek [Integer]星期几,1:星期一,2:星期二...,7：星期日
     * @return
     */
    private static Date getDayOfWeek(Date date, Integer dayOfWeek) {
        // 获得这一天是这一周的星期几
        int nowDayOfWeek = DateUtil.getDayOfWeek(date);
        if(nowDayOfWeek == dayOfWeek) {
            return date;
        } else {
            return DateUtil.addDay(date, dayOfWeek - nowDayOfWeek);
        }
    }

    /**
     * 获得指定日期下一周的周一
     * @param date [Date]指定日期
     * @return
     */
    public static Date getNextMonday(Date date) {
        return getMonday(DateUtil.addDay(date, 7));
    }

}
