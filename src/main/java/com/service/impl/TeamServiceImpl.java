package com.service.impl;

import com.dao.ProjectMapper;
import com.dao.TeamMapper;
import com.pojo.*;
import com.service.TeamService;
import com.service.UserandteamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 2017/8/29.
 * 团队表的Service层 [Team]
 */
@Service
@Transactional
public class TeamServiceImpl implements TeamService {
    // 注入TeamMapper依赖 [对数据库Team表进行操作的Dao层]
    @Autowired
    private TeamMapper teamMapper;

    // 注入UserAndTeamService依赖 [对数据库UserAndTeam表进行间接操作]
    @Autowired
    private UserandteamService userandteamService;

    //注入ProjectMapper依赖
    @Autowired
    ProjectMapper projectMapper;

    private static List<Team> teamList = new ArrayList<Team>();
    public static List<Team> getTeamList() {
        return teamList;
    }
    public static void setTeamList(List<Team> teamList) {
        TeamServiceImpl.teamList = teamList;
    }


    /**
     * 新增一个团队表
     * @param team 团队实体类
     * @param uId 用户ID
     * @return 返回此次新增数据所自增的主键
     */
    public int addTeam(Team team,int uId) {
        // 团队与用户表的关系--> 新建一个管队的时候创建者必为超级管理员
        Userandteam u = new Userandteam();
        teamMapper.insert(team);
        u.settId(team.gettId());
        u.setuId(uId);
        u.setType(1);
        // 插入新的用户与团队关系
        userandteamService.addUserandteam(u);
        // 将新增的团队加入全局变量中
        List<Team> t = getTeamList();
        t.add(team);
        setTeamList(t);
        return team.gettId();
    }

    public int deleteTeam(int tId) {
        try {
            // 删除user和team的联袂关系
            userandteamService.deleteUserandteam(tId);
            // 删除team团队
            teamMapper.deleteByPrimaryKey(tId);
            // 成功删除
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }

    public int updateTeam(Team team) {
        return 0;
    }

    public List<Team> selectTeam(Team team, int i) {
        List<Team> teamList = new ArrayList<Team>();
        //当i=0，根据团队id查询团队名
        if(i==0){
            Team team1 = teamMapper.selectByPrimaryKey(team.gettId());
            if(team1!=null){
                teamList.add(team1);
                return teamList;
            }else{
                return null;
            }
        }
        return null;
    }


    /**
     * 用户登录 根据用户ID查找出他所属的所有团队
     * @param uId
     * @return
     */
    public List<Team> selectTeam(int uId){
        // 定义团队列表
        List<Team> teamList = new ArrayList<Team>();

        Userandteam u = new Userandteam();
        u.setuId(uId);
        List<Userandteam> userandteamList = userandteamService.selectUserandteam(u,0);
        if (userandteamList==null||userandteamList.size()==0){
            System.out.println("该用户没有团队");
            return null;
        }
        // 循环遍历所有userandTeam联袂关系 查取所有团队
        for (Userandteam ut : userandteamList){
            Team team = teamMapper.selectByPrimaryKey(ut.gettId());
            teamList.add(team);
            System.out.println(team.toString());
        }
        // 将用户对应的团队列表保存起来
        setTeamList(teamList);
        return teamList;
    }



    public List<Team> Query() {

        return null;
    }

    /**
     * 获取全部存在的团队信息
     * @return
     */
    public List<Team> selectAll(){
        return getTeamList();
    }

    /**
     * 设置TeamList
     * @param a
     */
    public void backAll(List<Team> a){
        TeamServiceImpl.setTeamList(a);
    }


    /**
     * 根据团队id查找所做的项目
     * @param tId
     * @return
     */
    public List<Project> ProjectByTid(int tId){
        System.out.println("进入了ProjectByTid------>Service");
        ProjectExample projectExample=new ProjectExample();
        projectExample.createCriteria().andTIdEqualTo(tId);
        //select * from project where tId=?
        List<Project> projectList = projectMapper.selectByExample(projectExample);
        if(projectList!=null&&projectList.size()!=0){
            return projectList;
        }
        return null;
    }
}
