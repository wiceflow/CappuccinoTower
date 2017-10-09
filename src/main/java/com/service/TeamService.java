package com.service;

import com.pojo.Project;
import com.pojo.Team;
import com.service.impl.TeamServiceImpl;

import java.util.List;

/**
 * Created by chen on 2017/8/29.
 */
public interface TeamService {

    /**
     * 增加一个小组
     * @param team 小组实体类
     * @param uId 用户ID
     * @return 返回0代表失败，1代表成功
     */
    int addTeam(Team team,int uId);

    /**
     * 删除一个小组
     * @param tId 根据ID来删除
     * @return 返回0代表失败，1代表成功
     */
    int deleteTeam(int tId);

    /**
     * 更新一个小组
     * @param team 小组实体类
     * @return 返回0代表失败，1代表成功
     */
    int updateTeam(Team team);

    /**
     * 查询一个小组
     * @param team 小组实体类
     * @param i 根据什么查询（0代表ID，1代表名称）
     * @return 返回0代失败，1代表成功
     */
    List<Team> selectTeam(Team team,int i);


    /**
     * 用户登录 根据用户ID查找出他所属的所有团队
     * @param uId
     * @return
     */
    List<Team> selectTeam(int uId);
    List<Team> Query();

    /**
     * 获取全部存在的团队信息
     * @return
     */
    List<Team> selectAll();

    /**
     * 根据团队ID查找所做的所有项目
     */
    public List<Project> ProjectByTid(int tId);

    /**
     * 设置TeamList
     * @param a
     */
    void backAll(List<Team> a);
}
