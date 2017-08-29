package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by BF on 2017/8/29.
 * 登录控制
 */
@Controller
@RequestMapping(value = "User")
public class LoginController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public boolean login(User user,@RequestParam("aaa") int i){
        List<User> userList = userService.selectUser(user,i);
        if (userList.size()==0)
        {
            System.out.println("账号不存在");
            return false;
        }
        else
        {
            User user1 = userList.get(0);
            System.out.println("登录成功");
            System.out.println(user1.toString());
            return true;
        }
    }

}
