package com.service.impl;

import com.dao.ProjectMapper;
import com.pojo.*;
import com.service.ProjectService;
import com.service.TeamService;
import com.service.UserandteamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WU on 2017/8/29.
 * 对应项目表的Service实现类
 * [ProjectMapper] [ProjectService]
 */
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    //注入ProjectMapper依赖 [对数据库Project表进行操作的Dao层]
    @Autowired
    ProjectMapper projectMapper;

    //注入TeamService依赖
    @Autowired
    TeamService teamService;

    //注入团队和用户依赖
    @Autowired
    UserandteamService userandteamService;

    /**
     * 创建一个新的项目
     * @param project 项目实体类
     * @return 若成功添加返回1,用户名称已存在返回0
     */

    public int addProject(Project project,List<Integer> uId) {
        //创建一个新的团队表
        Team team = new Team();
        team.settName(project.getpName());
        team.setIsgroup(0);
        //返回团队表的ID
        int tid = teamService.addTeam(team);
        //创建UserAndTeam表

        for(int i=0;i<uId.size();i++)
        {
            Userandteam userandteam = new Userandteam();
            // 判断是否创建项目者本身 是则设置为超管
            if (i==uId.size()-1) {
                userandteam.setType(1);
            }
            else {
                userandteam.setType(0);
            }
            userandteam.setuId(uId.get(i));
            userandteam.settId(tid);
            userandteamService.addUserandteam(userandteam);
        }
        // 得到团队id
        project.settId(tid);
        // 判断是否有sensitive
        if(project.getpSensitive()==null) {
            project.setpSensitive(0);
        }

        projectMapper.insert(project);
        return project.getpId();
    }

    /**
     * 查询有多少个成员
     * @param
     * @return
     */
    public int selectCountPeople(){return 0 ;}


    /**
     * 根据ID进行删除
     * @param pId 根据什么来删除 （0代表ID，1代表项目名）
     * @return
     */
    public int deleteProject(int pId) {
        projectMapper.deleteByPrimaryKey(pId);
        return 1;
    }


    /**
     * 修改项目信息
     * @param project 项目实体类
     * @return
     */
    public int updateProject(Project project) {
        //Mybatis会默认为text类型的自动生成 withBlOBs 来对 数据库进行修改
        projectMapper.updateByPrimaryKeyWithBLOBs(project);
        return 1;
    }



    /**
     * 查找与选择[Project]
     *
     * @param project 项目实体类
     * @param i 根据什么来查找 （0代表ID，1代表项目名）
     * @return
     */
    public List<Project> selectProject(Project project, int i) {
        List<Project> projectList=new ArrayList<Project>();
        Project project1=null;
        //用ID主键进行查询
        if(i==0){
            project1=projectMapper.selectByPrimaryKey(project.getpId());
            System.out.println(project1.toString()+"aaa-----------------");
            projectList.add(project1);
            for (int a = 0;a<projectList.size();a++)
            {
                System.out.println(projectList.get(a).toString()+"b--------------");
            }

        }
        //若查询为空则返回null
        if (projectList == null || projectList.size() == 0) {
            System.out.println("返回了空");
            return null;
        }
        //否则返回这个list
        else {
            return projectList;
        }
    }

    /**
     * 对根据用户ID 对项目表进行遍历
     * @return
     */
    public List<Project> QueryList(int uId) {
        System.out.println("service.......");
        Userandteam userandteam=new Userandteam();
        //将uId放到userandteam对象中去
        userandteam.setuId(uId);
        //根据uId(用户ID)查询tId(团队编号)  通过Userandteam表
        //得到用户ID所参加的团队 List
        List<Userandteam> userandteamList = userandteamService.selectUserandteam(userandteam, 0);

        //创建一个项目List集合去接收通过tId查询到的项目
        List<Project> projectList=new ArrayList<Project>();

        //调用tId（团队编号）去查找pId(项目)  通过Project表
        for(int i=0;i<userandteamList.size();i++){
            ProjectExample projectExample=new ProjectExample();
            //userandteamList.get(i).gettId()   得到每个团队ID
            projectExample.createCriteria().andTIdEqualTo(userandteamList.get(i).gettId());
            List<Project> projects = projectMapper.selectByExample(projectExample);
            //将查到的项目放到项目List中
            projectList.add(projects.get(0));
        }
        //判断
        if(projectList.get(0).getpId()==null&&projectList==null)
        {
            System.out.println("没有查询到");
            return null;
        }
        else {
            System.out.println("返回集合");
            return projectList;
        }

    }

}
