package com.controller;

import com.dto.TeamforJsp;
import com.pojo.User;
import com.pojo.Userandteam;
import com.service.UserService;
import com.service.UserandteamService;
import com.util.AjaxResult;
import com.util.ObtainSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WU on 2017/9/21.
 */
@Controller
@RequestMapping("/userandteam")
public class UserandTeamController {

    @Autowired
    UserandteamService userandteamService;

    @Autowired
    UserService userService;

    /**
     * 用来判断用户是否是超级管理员
     * @param tId
     * @param request
     * @return
     */
    @RequestMapping("/judgeUser")
    @ResponseBody
    public AjaxResult judgeUser(@RequestParam("tId")int tId, HttpServletRequest request){
        int uId=new ObtainSession(request).getUser().getuId();
        Userandteam userandteam=new Userandteam();
        userandteam.setuId(uId);
        userandteam.settId(tId);
        List<Userandteam> userandteamList = userandteamService.selectUserandteam(userandteam, 3);
        if (userandteamList!=null){
            userandteam=userandteamList.get(0);
            System.out.println(userandteam+"--->controller判断");
            return new AjaxResult(1,"判断成功",userandteam);
        }
        return new AjaxResult(0,"判断失败");
    }

    @RequestMapping("/QueryUserByTid")
    @ResponseBody
    public AjaxResult QueryUserByTid(@RequestParam("tId")int tId,HttpServletRequest request){
        System.out.println("------>queryByid----->Controllor");
        List<TeamforJsp> teamforJspList = userService.QueryByTid(tId);
        if(teamforJspList!=null){
            System.out.println("----------->Controller->>>>返回");
        return new AjaxResult(1,"成功查找到组员",teamforJspList);
        }
        return new AjaxResult(0,"失败查找到组员");
    }
}
