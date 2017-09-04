package com.controller;

import com.pojo.Team;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by BF on 2017/8/29.
 * 登录控制,用户表增删改查
 */
@Controller
@RequestMapping(value = "User")
public class UserController {
    //注入依赖[UserService]
    @Autowired
    private UserService userService;


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
    public int login(User user, @RequestParam("loginType") int i, HttpServletRequest request) {
        List<User> userList = userService.selectUser(user, i);
        //账号不存在  返回0 前台AJAX验证账号不存在 [0代表账号不存在，返回页面显示登录失败]
        if (userList == null || userList.get(0).getuId()==null) {
            return 0;
        } else {
            //获取返回的用户POJO
            User user1 = userList.get(0);
            //对比用户输入的密码是否与数据库存储的密码相同,相同则返回 2 [2代表登录成功，将用户信息存入seesion]
            if (user.getuPassword().equals(user1.getuPassword())) {
                request.getSession().setAttribute("user", user1);
                return 2;
            }
            //若用户输入密码与数据库读取的密码不同，则返回 1 [1代表密码错误，返回页面显示登录失败]
            else {
                return 1;
            }
        }

    }

    /**
     * 新增用户
     *
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

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public void update(User user, HttpServletRequest request) {
        // 从session中获取当前用户的当前信息
        HttpSession session = request.getSession();
        User user1 = (User) session.getAttribute("user");

        if (user1 != null) {
            // 将用户ID赋值给将要进行修改的POJO类
            user.setuId(user1.getuId());
            try {
                userService.updateUser(user);
                System.out.println("更新用户成功");

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("更新用户失败");
            }
            // 更新session中用户的信息
            session.setAttribute("user",user);
        } else {
            System.out.println("错误的操作,用户信息错误,将其赶回登录界面");
        }
    }

}
