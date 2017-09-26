package com.controller;

import com.helper.DateHelper;
import com.pojo.Weekly;
import com.service.DynamicService;
import com.service.WeeklyService;
import com.sun.xml.internal.bind.v2.TODO;
import com.util.*;
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
     * 添加周报；
     * 先根据所选时间查询日期所在周有无周报，若有，则返回周报；若无，则可以添加
     * @param wTime 所选日期
     * @param wSummary 周报总结
     * @param wChallenge 周报挑战
     * @param wTarget 周报目标
     * @param wMethod 周报解决措施
     * @param request
     * @return 返回0表示添加失败；返回1表示添加成功；返回2表示周报已存在
     */
    @RequestMapping(value = "addWeekly")
    @ResponseBody
    public AjaxResult addWeekly(@RequestParam("wTime")String wTime,
                                @RequestParam("wSummary")String wSummary,
                                @RequestParam("wChallenge")String wChallenge,
                                @RequestParam("wTarget")String wTarget,
                                @RequestParam("wMethod")String wMethod,
                                HttpServletRequest request){
        //从Session中取出用户信息
        int uId=new ObtainSession(request).getUser().getuId();
        System.out.println(uId);
        int tId=new ObtainSession(request).getTeam().gettId();
//        int pId=new ObtainSession(request).getProject().getpId();
        //先根据所选日期查询有无周报存在
        try {
            Weekly weekly = new Weekly();
            //格式化日期
            Date date = DateUtil.getDate(wTime,"yyyy-MM-dd");
            weekly.setwTime(date);
            weekly.settId(tId);
            //调用selectWeekly方法查询
            List<Weekly> weeklies = weeklyService.selectWeekly(weekly, 0);
            if(weeklies==null||weeklies.size()==0){
                //若无周报，添加数据
//              weekly.setpId(pId);
                weekly.setuId(uId);
                weekly.setwTime(date);
                weekly.setwChallenge(wChallenge);
                weekly.setwSummary(wSummary);
                weekly.setwMethod(wMethod);
                weekly.setwTarget(wTarget);
                //调用addWeekly方法进行添加周报
                int i = weeklyService.addWeekly(weekly);
//                    //动态操作
//                    DynamicTool d = new DynamicTool(i,"weekly","新建了一个周报",request,dynamicService);
//                    d.newDynamic();
                    return new AjaxResult(1,"添加周报成功");
            }else{
                return new AjaxResult(2,"周报已存在",weeklies.get(0));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 查询周报
     * @param wTime
     * @return
     */
    @RequestMapping(value = "selectWeekly",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult selectWeekly(@RequestParam("wTime")String wTime,HttpServletRequest request){
        Weekly weekly = new Weekly();
        int tId=new ObtainSession(request).getTeam().gettId();
        weekly.settId(tId);
        List<Weekly> weeklies1 = weeklyService.selectWeekly(weekly, 1);
        if(weeklies1!=null||weeklies1.size()!=0){
            //将页面传入的时间转化为date类型
            try{
                Date date = DateUtil.getDate(wTime, "yyyy-MM-dd");
                weekly.setwTime(date);
                //根据时间对周报进行查询
                List<Weekly> weeklies = weeklyService.selectWeekly(weekly, 0);
                if(weeklies!=null||weeklies.size()!=0){
                    return new AjaxResult(1,"查询周报成功",weeklies.get(0));
                }else{
                    return new AjaxResult(0,"查询周报失败");
                }
            }catch (ParseException e){
                e.printStackTrace();
                System.out.println("字符串异常无法解析");
            }
        }else{
            return new AjaxResult(2,"该团队未编写周报");
        }
        return null;
    }


    /**
     * 更新周报
     * @param wTime 所选时间
     * @param wSummary 周报总结
     * @param wChallenge 周报挑战
     * @param wTarget 周报目标
     * @param wMethod 周报解决措施
     * @return 返回1表示更新成功；返回0表示更新失败
     */
    @RequestMapping(value = "updateWeekly")
    @ResponseBody
    public AjaxResult updateWeekly(@RequestParam("wTime")String wTime,
                                   @RequestParam("wSummary")String wSummary,
                                   @RequestParam("wChallenge")String wChallenge,
                                   @RequestParam("wTarget")String wTarget,
                                   @RequestParam("wMethod")String wMethod){
        Weekly weekly = new Weekly();
        try {
            //将所选时间格式化，根据时间查询数据库
            Date date = DateUtil.getDate(wTime,"yyyy-MM-dd");
            weekly.setwTime(date);
            List<Weekly> weeklies = weeklyService.selectWeekly(weekly, 0);
            //若查询到周报，则进行更新数据
            if(weeklies.size()!=0){
                Integer weeklyId = weeklies.get(0).getWeeklyId();
                weekly.setWeeklyId(weeklyId);
                weekly.setwChallenge(wChallenge);
                weekly.setwSummary(wSummary);
                weekly.setwMethod(wMethod);
                weekly.setwTarget(wTarget);
                int i = weeklyService.updateWeekly(weekly);
                if(i==1){
                    //返回1表示更新成功
                    return new AjaxResult(1,"更新周报成功");
                }else{
                    //返回0表示更新失败
                    return new AjaxResult(0,"更新周报失败");
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 根据所选日期查询出日期所在的周
     * @param wTime 所选日期
     * @return 返回1表示查询周成功；返回0表示查询失败
     */
    @RequestMapping(value = "weekByday")
    @ResponseBody
    public AjaxResult weekByday(@RequestParam("wTime")String wTime){
        Weekly weekly =new Weekly();
        try {
            //将所选日期格式化
            Date date = DateUtil.getDate(wTime,"yyyy-MM-dd");
            weekly.setwTime(date);
            //得到所选日期所在周的周一
            Date monday = DateHelper.getMonday(weekly.getwTime());
            //得到所选日期所在周的周日
            Date sunday = DateHelper.getSunday(weekly.getwTime());
            if(monday!=null&&sunday!=null){
                //返回1表示查询成功
                return new AjaxResult(1,"查询周成功",monday, sunday);
            }else{
                //返回0表示查询失败
                return new AjaxResult(0,"查询失败");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}

