package com.util;

import com.pojo.Project;
import com.pojo.Team;
import com.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by BF on 2017/9/1.
 * 获取页面Session工具类
 */
public class ObtainSession {

    // slf4j日志配置
    private static final Logger _LOG = LoggerFactory.getLogger(ObtainSession.class);

    private HttpServletRequest request;

    // [User实体类]  从Session中获取的User
    private User user;
    // [Team实体类]  从Session中获取的Team
    private Team team;
    // [Project实体类]  从Session中获取的Project
    private Project project;

    private HttpSession session;
    // 新的构造器
    public ObtainSession(HttpServletRequest request) {
        this.request = request;
        this.session = request.getSession();
    }
    // 将默认构造方法隐藏起来
    private ObtainSession(){}

    public  User getUser()
    {
        user = (User) session.getAttribute("user");
        if (user==null)
            _LOG.error("从session中获取User对象出错,为空");
        return this.user;
    }
    public Team getTeam(){
        team = (Team) session.getAttribute("team");
        if (team==null) {
            _LOG.error("从session中获取Team对象出错,为空");
            return null;
        }
        return this.team;
    }
    public Project getProject(){
        project = (Project) session.getAttribute("project");
        if (project==null)
            _LOG.error("从session中获取Project对象出错,为空");
        return this.project;
    }
}
