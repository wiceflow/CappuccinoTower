package com.service;

import com.pojo.Project;

import java.util.List;

/**
 * Created by chen on 2017/8/29.
 */
public interface ProjectService {
    /**
     * 增加一个新的项目
     * @param project 项目实体类
     * @return 返回0代表失败，1代表成功
     */
    int addProject(Project project);

    /**
     * 删除一个项目
     * @param pId 根据什么来删除 （0代表ID，1代表项目名）
     * @return 返回0代表失败 1代表成功
     */
    int deleteProject(int pId);

    /**
     * 更新一个项目
     * @param project 项目实体类
     * @return
     */
    int updateProject(Project project);

    /**
     * 查找一个项目
     * @param project 项目实体类
     * @param i 根据什么来查找 （0代表ID，1代表项目名）
     * @return 返回0代表失败，1代表成功
     */
    List<Project> selectProject(Project project,int i);
}
