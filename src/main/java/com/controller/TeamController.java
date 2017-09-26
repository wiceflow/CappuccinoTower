package com.controller;

import com.dao.TeamMapper;
import com.pojo.Project;
import com.pojo.Team;
import com.pojo.Userandteam;
import com.service.TeamService;
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
 * Created by chen on 2017/9/15.
 */
@RequestMapping(value = "team")
@Controller
public class TeamController {
    @Autowired
    TeamService teamService;
    @Autowired
    UserandteamService userandteamService;

    /**
     * 根据用户ID查找团队
     * @param uId
     * @param userandteam
     * @param request
     * @return
     */
    @RequestMapping(value = "TeamByUid")
    @ResponseBody
    public AjaxResult TeamByUid(@RequestParam("uId")int uId, Userandteam userandteam, HttpServletRequest request){
        List<Team> teamList1 = new ArrayList<Team>();
        userandteam.setuId(uId);
        List<Userandteam> userandteamList = userandteamService.selectUserandteam(userandteam, 0);
        if(userandteamList!=null||userandteamList.size()!=0){
            for(int i=0;i<userandteamList.size();i++){
                Team team = new Team();
                team.settId(userandteamList.get(i).gettId());
                List<Team> teamList = teamService.selectTeam(team, 0);
                teamList1.add(teamList.get(0));
                }
                return new AjaxResult(1,"返回团队列表成功",teamList1);
            }else{
            return new AjaxResult(0,"返回团队列表失败");
        }
    }

    /**
     * 根据团队ID遍历出团队所做的项目
     * @param
     * @return
     */
    @RequestMapping("ProjectByTid")
    @ResponseBody
    public AjaxResult ProjectByTid(HttpServletRequest request){
        System.out.println("进入了ProjectByTid-------->Controller");
        //从session中取出tId
        int tId=new ObtainSession(request).getTeam().gettId();
        System.out.println("这是项目的ID:"+tId);
        List<Project> projectList = teamService.ProjectByTid(tId);
        if(projectList!=null){
            return new AjaxResult(1,"成功",projectList);
        }
        return new AjaxResult(0,"失败");
    }
}
