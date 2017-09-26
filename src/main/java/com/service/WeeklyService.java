package com.service;

import com.pojo.Weekly;

import java.util.List;

/**
 * Created by chen on 2017/9/19.
 */
public interface WeeklyService {

    /**
     * 增加一个周报
     * @param weekly 周报实体类
     * @return 返回1代表成功，0代表失败
     */
    int addWeekly(Weekly weekly);


    /**
     * 删除一个周报
     * @param wId 周报ID
     * @return 返回1代表成功，0代表失败
     */
    int deleteWeekly(int wId);

    /**
     * 更新一个周报
     * @param weekly 周报ID
     * @return 返回1代表成功，0代表失败
     */
    int updateWeekly(Weekly weekly);

    /**
     * 查询一个周报
     * @param weekly 周报实体类
     * @param i 根据什么查询
     * @return 返回1代表成功，0代表失败
     */
    List<Weekly> selectWeekly(Weekly weekly,int i);

    List<Weekly> Query();
}
