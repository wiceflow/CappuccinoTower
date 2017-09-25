package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by chen on 2017/9/20.
 * 日期时间操作工具类
 */
public final class DateUtil {

    /**
     * 时间格式字符串转Date对象
     * <pre>
     *
     *     dataStr : “2017-9-20 21:57:57”
     *     format  : "yyyy-MM-dd hh:mm:dd"
     *
     * </pre>
     * @param dateStr [String]时间格式字符串
     * @param format [String]字符串时间格式
     * @return
     * @throws ParseException 时间格式异常
     */
    public static Date getDate(String dateStr, String format) throws ParseException {
        // 获得时间格式对象
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(dateStr);
    }

    /**
     * 日期添加指定天
     * <pre>
     *     传入负数时间表示减去天数
     * </pre>
     * @param date [Date]待添加日期
     * @param addDay [int]添加天数
     * @return
     */
    public static Date addDay(Date date, int addDay) {
        Calendar calendar = getCalender(date);
        calendar.add(Calendar.DAY_OF_MONTH, addDay);
        return calendar.getTime();
    }


    /**
     * 日期添加指定小时
     * <pre>
     *     传入负数时间表示减去小时数
     * </pre>
     * @param date [Date]待添加日期
     * @param addHour [int]添加小时数
     * @return
     */
    public static Date addHour(Date date, int addHour) {
        Calendar calendar = getCalender(date);
        calendar.add(Calendar.HOUR_OF_DAY, addHour);
        return calendar.getTime();
    }

    /**
     * 获得传入日期是星期几
     * <pre>
     *     周一 ： 1
     *     周二 ： 2
     *     周三 ： 3
     *     周四 ： 4
     *     周五 ： 5
     *     周六 ： 6
     *     周天 ： 7
     * </pre>
     * @param date [Date]日期
     * @return
     */
    public static int getDayOfWeek(Date date) {
        Calendar calendar = getCalender(date);
        int res = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        return res == 0 ? 7 : res;
    }

    /**
     * 获得一个指定日期的日历对象
     * @param date [Date]日期
     * @return
     */
    public static Calendar getCalender(Date date) {
        // 新创建一个日期对象
        Date copyDate = new Date(date.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(copyDate);
        return calendar;
    }

}
