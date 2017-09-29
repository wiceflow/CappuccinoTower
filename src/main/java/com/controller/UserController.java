package com.controller;

import com.pojo.*;
import com.service.*;
import com.util.AjaxResult;
import com.util.ObtainSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by BF on 2017/8/29.
 * 登录控制,用户表增删改查
 */
@Controller
@RequestMapping(value = "user")
public class UserController {
    //注入依赖[UserService]
    @Autowired
    private UserService userService;
    //注入依赖[TeamService]
    @Autowired
    private TeamService teamService;
    //注入依赖[ProjectService]
    @Autowired
    private ProjectService projectService;
    //注入依赖[UserandteamService]
    @Autowired
    private UserandteamService userandteamService;
    //注入依赖[UserandprojectService]
    @Autowired
    private UserandprojectService userandprojectService;

    /**
     * 这里不用 [User] 做返回值的原因是，怕就算密码错误返回了一个JSON到前台比人还是可以查看到整个用户信息
     *
     * @param user    封装前台信息
     * @param i       根据什么来查询
     * @param request
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult login(User user, @RequestParam("loginType") int i, HttpServletRequest request) {
        List<User> userList = userService.selectUser(user, i);
        //账号不存在  返回0 前台AJAX验证账号不存在 [0代表账号不存在，返回页面显示登录失败]
        if (userList == null || userList.get(0).getuId()==null) {
            return new AjaxResult(0,"账号不存在");
        } else {
            //获取返回的用户POJO
            User user1 = userList.get(0);
            //对比用户输入的密码是否与数据库存储的密码相同,相同则返回 2 [2代表登录成功，将用户信息存入seesion]
            if (user.getuPassword().equals(user1.getuPassword())) {
                request.getSession().setAttribute("user", user1);
                List<Team> teamList = teamService.selectTeam(user1.getuId());
                for (Team t : teamList){
                    System.out.println(t.toString());
                }
                request.getSession().setAttribute("team",teamList.get(0));
                return new AjaxResult(2,"登陆成功",user1);
            }
            //若用户输入密码与数据库读取的密码不同，则返回 1 [1代表密码错误，返回页面显示登录失败]
            else {
                return new AjaxResult(1,"密码错误");
            }
        }

    }

    /**
     * 新增用户
     * @param user 封装前台关于User表内容
     * @param team 封装前台关于Team表内容
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(User user, Team team) {
        // 新增用户
        int i = userService.addUser(user, team);
        if (i == 1) {
            System.out.println("插入新用户成功");
        } else if (i == 0) {
            System.out.println("插入新用户失败");
        }
        return "/login";
    }

    /**
     * 更新用户信息
     * @param uName 用户名
     * @param uEmail 用户邮箱
     * @param uPassword 用户密码
     * @param request
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public AjaxResult update(@RequestParam("uName")String uName,
                       @RequestParam("uEmail")String uEmail,
                       @RequestParam("uPassword")String uPassword,
                       HttpServletRequest request) {
        // 从session中获取当前用户的当前信息
        int uId = new ObtainSession(request).getUser().getuId();
        User user = new User();
        user.setuId(uId);
        user.setuEmail(uEmail);
        user.setuName(uName);
        user.setuPassword(uPassword);
        int i = userService.updateUser(user);
        if(i==1){
            return new AjaxResult(1,"更新成功");
        }
        return null;
    }

    /**
     * 获取所有团队
     * @return
     */
    @RequestMapping(value = "queryTeam", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult queryTeam(){
        List<Team> teamList = teamService.selectAll();
        return new AjaxResult(1,"获取全部团队成功",teamList);
    }

    /**
     * 变换团队
     * @param tId
     * @param request
     */
    @RequestMapping(value = "changeTeam", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult changeTeam(@RequestParam("tId")int tId,HttpServletRequest request){
        System.out.println("进入了changeTeam------>Controller");
        List<Team> teamList = teamService.selectAll();
        int i=0;
        for (Team team : teamList){
            if (team.gettId()==tId){
                request.getSession().setAttribute("team",team);
                teamList.add(0,teamList.remove(i));
                System.out.println(team.toString());
                return new AjaxResult(1,"成功");
            }
            i++;
        }
        teamService.backAll(teamList);
        return new AjaxResult(0,"失败");
    }

    /**
     * 根据用户ID查询用户
     * @param request
     * @return
     */
    @RequestMapping(value = "selectUser")
    @ResponseBody
    public AjaxResult selectUser(HttpServletRequest request){
        int uId = new ObtainSession(request).getUser().getuId();
        User user = new User();
        user.setuId(uId);
        List<User> userList = userService.selectUser(user, 0);
        if(userList!=null||userList.size()!=0){
            return new AjaxResult(1,"查询用户成功",userList.get(0));
        }else{
            return new AjaxResult(0,"查询用户失败");
        }
    }

}
