package com.service.impl;

import com.dao.WeeklyMapper;
import com.helper.DateHelper;
import com.pojo.Weekly;
import com.pojo.WeeklyExample;
import com.service.WeeklyService;
import com.util.DateUtil;
import com.util.TimeGetTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by chen on 2017/9/19.
 */
@Service
@Transactional
public class WeeklyServiceImpl implements WeeklyService {
    @Autowired
    WeeklyMapper weeklyMapper;

    public int addWeekly(Weekly weekly) {
        weeklyMapper.insert(weekly);
        return weekly.getWeeklyId();
    }



    public int deleteWeekly(int wId) {
        return 0;
    }

    public int updateWeekly(Weekly weekly) {
        WeeklyExample weeklyExample = new WeeklyExample();
        weeklyExample.createCriteria().andWeeklyIdEqualTo(weekly.getWeeklyId());
        int i = weeklyMapper.updateByExample(weekly, weeklyExample);
        if(i>0){
            //返回1，表示更新成功
            return 1;
        }else {
            //返回0，表示更新失败
            return 0;
        }
    }

    public List<Weekly> selectWeekly(Weekly weekly, int i) {
        //根据日期查询周报
        if(i==0){
            WeeklyExample weeklyExample = new WeeklyExample();
            //前台传入日期需大于等于所在周的周一，小于下一周周一的时间
            weeklyExample.createCriteria().andWTimeGreaterThanOrEqualTo(
                    DateHelper.getMonday(weekly.getwTime())).andWTimeLessThan(
                    DateHelper.getNextMonday(weekly.getwTime())).andTIdEqualTo(weekly.gettId());
            List<Weekly> weeklies = weeklyMapper.selectByExample(weeklyExample);
            if(weeklies!=null||weeklies.size()!=0){
                return weeklies;
            }else{
                return null;
            }
        }
        //根据团队id查询当前团队是否有周报
        else if(i==1){
            WeeklyExample weeklyExample = new WeeklyExample();
            weeklyExample.createCriteria().andTIdEqualTo(weekly.gettId());
            List<Weekly> weeklies1 = weeklyMapper.selectByExample(weeklyExample);
            if(weeklies1!=null||weeklies1.size()!=0){
                return weeklies1;
            }else{
                return null;
            }
        }
        return null;
    }

    public List<Weekly> Query() {

        return null;
    }
}
