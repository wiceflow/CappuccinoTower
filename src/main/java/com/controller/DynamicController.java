package com.controller;

import com.dto.General;
import com.pojo.Dynamic;
import com.pojo.Project;
import com.pojo.User;
import com.pojo.Userandteam;
import com.service.DynamicService;
import com.service.ProjectService;
import com.service.UserService;
import com.service.UserandteamService;
import com.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by BF on 2017/9/5.
 * 用户动态
 */
@Controller
@RequestMapping(value = "dynamic")
public class DynamicController {
    public static List<General> getGL() {
        return GL;
    }

    public static void setGL(List<General> GL) {
        DynamicController.GL = GL;
    }

    private static List<General> GL = new ArrayList<General>();

    // 注入依赖[DynamicService]
    @Autowired
    DynamicService dynamicService;

    //注入项目依赖
    @Autowired
    ProjectService projectService;

    //注入用户依赖
    @Autowired
    UserService userService;

    //注入用户和团队依赖
    @Autowired
    UserandteamService userandteamService;

    @RequestMapping(value = "addDynamic")
    public AjaxResult addDynamic(Dynamic dynamic){
        int m = dynamicService.addDynamic(dynamic);
        if(m==1){
            //返回1，表示增加动态信息成功
            return new AjaxResult(1,"增加动态信息成功");
        }else if(m==0){
            //返回0，表示增加动态信息失败
            return new AjaxResult(0,"增加动态信息失败");
        }
        return null;
    }

    @RequestMapping(value = "DynamicList")
    @ResponseBody
    public AjaxResult DynamicList(@RequestParam("tId")int tId){
        Dynamic dynamic = new Dynamic();
        System.out.println(tId+"前台传入的tid团队编号******************");
        dynamic.settId(tId);
        List<General> generalList = dynamicService.QueryList(dynamic);
        setGL(generalList);
        if(generalList!=null){
            return new AjaxResult(1,"遍历动态列表成功",generalList);
        }else{
            return new AjaxResult(0,"遍历动态列表失败");
        }
    }

    @RequestMapping(value = "projectByUid")
    @ResponseBody
    public AjaxResult projectByUid(@RequestParam("uId")int uId, HttpServletRequest request){
        List<Project> projectList = projectService.QueryList(uId);
        if(projectList!=null&&projectList.size()!=0){
            return new AjaxResult(1,"项目遍历成功",projectList);
        }
        return new AjaxResult(0,"项目遍历失败");

    }

    @RequestMapping(value = "dynamicByPid")
    @ResponseBody
    public AjaxResult dynamicByPid(@RequestParam("pName")String pName,@RequestParam("uName")String uName,HttpServletRequest request){
        List<General> GL2  = new ArrayList<General>();
        //当选择“所有项目”
        if (pName.equals("0")){
            //选择“所有成员”
            if (uName.equals("0"))
            {
                return new AjaxResult(1,"遍历动态列表成功",getGL());
            }else {
                //选择当中一名成员
                for (int i=0;i<GL.size();i++){
                    if (uName.equals(GL.get(i).getUname())){
                        GL2.add(GL.get(i));
                    }
                }
                return new AjaxResult(1,"查找对应项目动态成功",GL2);
            }

        }else{
            //当选择“所有成员”
            if (uName.equals("0")){
                for (int i=0;i<GL.size();i++){
                    if (pName.equals(GL.get(i).getpName())){
                        GL2.add(GL.get(i));
                    }
                }
                return new AjaxResult(1,"查找对应项目动态成功",GL2);
            }else {
                //两个下拉框均没选择“所有”
                for (int i=0;i<GL.size();i++){
                    if (pName.equals(GL.get(i).getpName())&&uName.equals(GL.get(i).getUname())){
                        GL2.add(GL.get(i));
                    }
                }
                return new AjaxResult(1,"查找对应项目动态成功",GL2);
            }
        }
    }


    @RequestMapping(value = "userByTid")
    @ResponseBody
    public AjaxResult userByTid(@RequestParam("tId")int tId,HttpServletRequest request){
        List<User> userList = userService.QueryList(tId);
        if(userList!=null||userList.size()!=0){
            return new AjaxResult(1,"用户遍历成功",userList);
        }else{
            return new AjaxResult(0,"用户遍历失败");
        }
    }

}
