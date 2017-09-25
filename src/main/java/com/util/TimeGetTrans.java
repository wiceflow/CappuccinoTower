package com.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by WU on 2017/9/4.
 */
public class TimeGetTrans {
    // slf4j日志配置
    private static final Logger _LOG = LoggerFactory.getLogger(TimeGetTrans.class);

    // 得到系统当前时间并且转换成Date类型
    public Date getTime(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time=null;
        try {
            time= sdf.parse(sdf.format(new Date()));

        } catch (ParseException e) {
            _LOG.error("[TimeGetTrans工具类] 获取系统时间错误");
            e.printStackTrace();
        }
        return time;
    }

}
