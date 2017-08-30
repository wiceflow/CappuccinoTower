package com.service.impl;

import com.dao.ProjectMapper;
import com.pojo.Project;
import com.pojo.Team;
import com.service.ProjectService;
import com.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by WU on 2017/8/29.
 * 对应项目表的Service实现类
 * [ProjectMapper] [ProjectService]
 */
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectMapper projectMapper; //创建项目类的Mapper
    @Autowired
    TeamService teamService;  //创建团队的Service
    /**
     * 创建一个新的项目
     * @param project 项目实体类
     * @return
     */

    public int addProject(Project project) {
        //创建一个新的团队表
        Team team = new Team();
        team.setTName(project.getPName());
        team.setIsgroup(0);

        int tid = teamService.addTeam(team);
        //得到团队id
        project.setTId(tid);

        //判断是否有sensitive
        if(project.getPSensitive()==null)
        {
            project.setPSensitive(0);
        }

        projectMapper.insert(project);
        return 1;
    }

    /**
     * 查询有多少个成员
     * @param
     * @return
     */
    public int selectCountPeople(){return 0 ;}

    public int deleteProject(int pId) {
        return 0;
    }

    public int updateProject(Project project) {
        return 0;
    }

    public List<Project> selectProject(Project project, int i) {
        return null;
    }
}
