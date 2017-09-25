package com.controller;

import com.helper.DateHelper;
import com.pojo.Weekly;
import com.service.DynamicService;
import com.service.WeeklyService;
import com.util.AjaxResult;
import com.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by chen on 2017/9/19.
 */
@RequestMapping(value = "weekly")
@Controller
public class WeeklyController {
    @Autowired
    WeeklyService weeklyService;
    @Autowired
    private DynamicService dynamicService;


    /**
     * 写周报
     * @param weekly 周报实体类
     * @param request
     * @return 返回1代表增加成功，返回0代表失败
     */
    @RequestMapping(value = "addWeekly")
    public AjaxResult addWeekly(Weekly weekly, HttpServletRequest request){


        int i = weeklyService.addWeekly(weekly,0);
        if(i==1){
            int wId = weekly.getWeeklyId();
//            //动态操作
//            DynamicTool d = new DynamicTool(wId,"weekly","新建了一个任务",request,dynamicService);
//            d.newDynamic();
            return new AjaxResult(1,"添加周报成功");
        }else{
            return new AjaxResult(0,"添加周报失败");
        }
    }

    /**
     * 查询周报
     * @param wTime 周报创建时间，根据时间查询周报
     * @return 返回1代表成功，返回0代表失败
     */
    @RequestMapping(value = "selectWeekly",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult selectWeekly(@RequestParam("wTime")String wTime){
        Weekly weekly = new Weekly();
        //将页面传入的时间转化为date类型
        try{
            Date date = DateUtil.getDate(wTime, "yyyy-MM-dd");
            weekly.setwTime(date);
            //根据时间对周报进行查询
            List<Weekly> weeklies = weeklyService.selsectWeekly(weekly, 0);
            if(weeklies!=null||weeklies.size()!=0){
                return new AjaxResult(1,"查询周报成功",weeklies.get(0));
            }else{
                return new AjaxResult(0,"查询周报失败");
            }
        }catch (ParseException e){
            e.printStackTrace();
            System.out.println("字符串异常无法解析");
        }
        return null;
    }


    @RequestMapping(value = "updateWeekly")
    @ResponseBody
    public AjaxResult updateWeekly(@RequestParam("wTime")String wTime,
                                   @RequestParam("wSummary")String wSummary,
                                   @RequestParam("wChallenge")String wChallenge,
                                   @RequestParam("wTarget")String wTarget,
                                   @RequestParam("wMethod")String wMethod){
        System.out.println("进来了update-----------");
        Weekly weekly = new Weekly();
        try {
            Date date = DateUtil.getDate(wTime,"yyyy-MM-dd");
            weekly.setwTime(date);
            List<Weekly> weeklies = weeklyService.selsectWeekly(weekly, 0);
            if(weeklies.size()!=0){
                Integer weeklyId = weeklies.get(0).getWeeklyId();
                weekly.setWeeklyId(weeklyId);
                weekly.setwChallenge(wChallenge);
                weekly.setwSummary(wSummary);
                weekly.setwMethod(wMethod);
                weekly.setwTarget(wTarget);
                int i = weeklyService.updateWeekly(weekly);
                if(i==1){
                    return new AjaxResult(1,"更新周报成功");
                }else{
                    return new AjaxResult(0,"更新周报失败");
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping(value = "weekByday")
    @ResponseBody
    public AjaxResult weekByday(@RequestParam("wTime")String wTime){
        Weekly weekly =new Weekly();
        try {
            Date date = DateUtil.getDate(wTime,"yyyy-MM-dd");
            weekly.setwTime(date);
            Date monday = DateHelper.getMonday(weekly.getwTime());
            Date sunday = DateHelper.getSunday(weekly.getwTime());
            if(monday!=null&&sunday!=null){
                return new AjaxResult(1,"查询周成功",monday, sunday);
            }else{
                return new AjaxResult(0,"查询失败");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}

