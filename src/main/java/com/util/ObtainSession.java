package com.util;

import com.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by BF on 2017/9/1.
 * 获取页面Session工具类
 */
public class ObtainSession {
    // [User实体类]  从Session中获取的User
    private User user;

    private HttpSession session;

    public  User getUser(HttpServletRequest request)
    {
        this.session = request.getSession();
        user = (User) session.getAttribute("user");
        return this.user;
    }
}
