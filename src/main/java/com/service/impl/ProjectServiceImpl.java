package com.service.impl;

import com.dao.DiscusMapper;
import com.dao.ProjectMapper;
import com.dao.TeamMapper;
import com.dao.TotalfileMapper;
import com.dto.ProjectList;
import com.pojo.*;
import com.service.*;
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

    // 注入ProjectMapper依赖 [对数据库Project表进行操作的Dao层]
    @Autowired
    ProjectMapper projectMapper;
    // 注入TeamMapper依赖 [对数据库Team表进行操作的Dao层]
    @Autowired
    TeamMapper teamMapper;
    // 注入DiscusMapper依赖 [对数据库Discus表进行操作的Dao层]
    @Autowired
    DiscusMapper discusMapper;
    // 注入TatalfileMapper依赖 [对数据库TatalfileMapper表进行操作的Dao层]
    @Autowired
    TotalfileMapper tatalfileMapper;
    // 注入TeamService依赖
    @Autowired
    TeamService teamService;
    // 注入团队和用户依赖
    @Autowired
    UserandteamService userandteamService;
    // 注入项目和用户依赖
    @Autowired
    UserandprojectService userandprojectService;

    /**
     * 创建一个新的项目
     *
     * @param project 项目实体类
     * @return 若成功添加返回1, 用户名称已存在返回0
     */

    public Project addProject(Project project, List<Integer> uId) {
        project.settId(1);
        // 判断是否有sensitive
        if (project.getpSensitive() == null) {
            project.setpSensitive(0);
        }
        projectMapper.insert(project);
        // 创建UserAndProject表
        for (int i = 0; i < uId.size(); i++) {
            Userandproject userandproject = new Userandproject();
            // 判断是否创建项目者本身 是则设置为创建者
            if (i == uId.size() - 1) {
                userandproject.setType(1);
            } else {
                userandproject.setType(0);
            }
            userandproject.setuId(uId.get(i));
            // 设置项目ID
            userandproject.setpId(project.getpId());
            userandprojectService.addUserandproject(userandproject);
        }
        return project;
    }

    /**
     * 查询有多少个成员
     * @param
     * @return
     */
    public int selectCountPeople() {
        return 0;
    }


    /**
     * 根据ID进行删除
     * @param project 根据什么来删除
     * @return
     */
    public int deleteProject(Project project) {
        try {
            // 删除项目
            projectMapper.deleteByPrimaryKey(project.getpId());
            // TODO 还没写删除其子目录
            // 如果讨论不为空,则删除讨论总表
            if (project.getDiscusallid()!=null){
                discusMapper.deleteByPrimaryKey(project.getDiscusallid());
            }
            // 如果文件不为空，则删除文件总表
            if (project.getfTotalid()!=null){
                tatalfileMapper.deleteByPrimaryKey(project.getfTotalid());
            }
            return 1;
        } catch (Exception e) {
            System.out.println("删除失败");
            e.printStackTrace();
            return 0;
        }

    }


    /**
     * 修改项目信息
     * @param project 项目实体类
     * @return
     */
    public int updateProject(Project project) {
        //Mybatis会默认为text类型的自动生成 withBlOBs 来对 数据库进行修改
        try{
            projectMapper.updateByPrimaryKeyWithBLOBs(project);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }


    /**
     * 查找与选择[Project]
     * @param project 项目实体类
     * @param i       根据什么来查找 （0代表ID，1代表项目名）
     * @return
     */
    public List<Project> selectProject(Project project, int i) {
        List<Project> projectList = new ArrayList<Project>();
        Project project1 = null;
        //用ID主键进行查询
        if (i == 0) {
            project1 = projectMapper.selectByPrimaryKey(project.getpId());
            System.out.println(project1.toString() + "aaa-----------------");
            projectList.add(project1);
            for (int a = 0; a < projectList.size(); a++) {
                System.out.println(projectList.get(a).toString() + "b--------------");
            }
        }
        //若查询为空则返回null
        if (projectList == null || projectList.size() == 0) {
            System.out.println("返回了空");
            return null;
        }
        //否则返回这个list
        else {
            System.out.println("返回了List");
            return projectList;
        }
    }

    /**
     * 对根据用户ID 对项目表进行遍历
     * @return
     */
    public List<Project> QueryList(int uId) {
        System.out.println("service.......");
        Userandteam userandteam = new Userandteam();
        //将uId放到userandteam对象中去
        userandteam.setuId(uId);
        //根据uId(用户ID)查询tId(团队编号)  通过Userandteam表
        //得到用户ID所参加的团队 List
        List<Userandteam> userandteamList = userandteamService.selectUserandteam(userandteam, 0);

        //创建一个项目List集合去接收通过tId查询到的项目
        List<Project> projectList = new ArrayList<Project>();

        //调用tId（团队编号）去查找pId(项目)  通过Project表
        for (int i = 0; i < userandteamList.size(); i++) {
            ProjectExample projectExample = new ProjectExample();
            //userandteamList.get(i).gettId()   得到每个团队ID
            projectExample.createCriteria().andTIdEqualTo(userandteamList.get(i).gettId());
            List<Project> projects = projectMapper.selectByExample(projectExample);
            //将查到的项目放到项目List中
            projectList.add(projects.get(0));
        }
        //判断
        if (projectList.get(0).getpId() == null && projectList == null) {
            System.out.println("没有查询到");
            return null;
        } else {
            System.out.println("返回集合");
            return projectList;
        }

    }

    /**
     * 将项目的相关信息全部遍历出来
     * @return
     */
    public Project projectALL(int pId,int uId){
        //创建ProjectList,返回web层的对象
        ProjectList projectList=new ProjectList();
        //根据pId查找出项目的信息；
        Project project = projectMapper.selectByPrimaryKey(pId);
        //将查找到的project，放到projectList中，
        projectList.setpId(pId);
        projectList.setpName(project.getpName());
        projectList.setpDescribe(project.getpDescribe());
        projectList.setIspublic(project.getIspublic());
        projectList.setpSensitive(project.getpSensitive());
        return project;
    }

}
