package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by BF on 2017/8/29.
 * 登录控制
 */
@Controller
@RequestMapping(value = "User")
public class LoginController {
    //注入依赖[UserService]
    @Autowired
    private UserService userService;


    /**
     * 这里不用 [User] 做返回值的原因是，怕就算密码错误返回了一个JSON到前台比人还是可以查看到整个用户信息
     * @param user 封装前台信息
     * @param i    根据什么来查询
     * @param request
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public int login(User user, @RequestParam("aaa") int i, HttpServletRequest request) {
        List<User> userList = userService.selectUser(user, i);
        //账号不存在  返回0 前台AJAX验证账号不存在 [0代表账号不存在，返回页面显示登录失败]
        if (userList == null || userList.size() == 0) {
            return 0;
        }
        else {
            //获取返回的用户POJO
            User user1 = userList.get(0);
            //对比用户输入的密码是否与数据库存储的密码相同,相同则返回 2 [2代表登录成功，将用户信息存入seesion]
            if (user.getUPassword().equals(user1.getUPassword())) {
                request.getSession().setAttribute("user", user1);
                return 2;
            }
            //若用户输入密码与数据库读取的密码不同，则返回 1 [1代表密码错误，返回页面显示登录失败]
            else {
                return 1;
            }
        }
    }

}
