package com.controller;

import com.pojo.Project;
import com.pojo.User;
import com.service.ProjectService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by WU on 2017/8/29.
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService; //创建项目接口

    @Autowired
    UserService userService; //创建用户接口
    /**
     * 跳转到输入项目信息界面
     * @return
     */
    @RequestMapping("/goCreateProject")
    public ModelAndView goCreateProject(){
        //将遍历用户表的list返回
        List<User> userList = userService.QueryUser();

        ModelAndView modelAndView=new ModelAndView();

        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("project/putProject");
       return modelAndView;
    }

    /**
     * 向数据库插入信息
     * @param project
     * @return
     */
    @RequestMapping("/putProject")
    public ModelAndView putProject(Project project){
        //从页面中接收 Project 数据
        String ProjectName=project.getPName();
        String ProjectDescribe=project.getPDescribe();

        //调用实现类，插入项目数据
        projectService.addProject(project);

        ModelAndView modelAndView=new ModelAndView();

        //将数据放到modelAndView
        modelAndView.addObject("ProjectName",ProjectName);
        modelAndView.addObject("ProjectDescribe",ProjectDescribe);

        modelAndView.setViewName("project/afterProject");
        return modelAndView;
    }
}
