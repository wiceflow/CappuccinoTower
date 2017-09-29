package com.util;

import com.pojo.Dynamic;
import com.pojo.Project;
import com.pojo.Team;
import com.pojo.User;
import com.service.DynamicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


/**
 * Created by BF on 2017/9/6.
 * 动态添加工具类
 * 判断Action,减少累赘,封装方法
 */
public class DynamicTool {
    // slf4j日志配置
    private static final Logger _LOG = LoggerFactory.getLogger(DynamicTool.class);

    private DynamicService dynamicService;

    // HttpService
    HttpServletRequest request = null;
    // 创建Action变量
    private String action;
    // 被操作者
    private int beId;
    // 被操作表
    private String table;
    // 创建PO
    private Dynamic dynamic;
    // 操作者
    private User user;
    // 操作项目
    private Project project;
    // 操作时间
    private Date time;
    //团队
    private Team team;

    // 禁用无参构造函数
    private DynamicTool() {
    }

    // 有参构造函数
    public DynamicTool(int beId, String table, String action, HttpServletRequest request,DynamicService d) {
        System.out.println("进来有参构造器");
        this.dynamic = new Dynamic();
        this.beId = beId;
        this.action = action;
        this.request = request;
        this.table = table;
        this.dynamicService = d;
        this.user = (User) request.getSession().getAttribute("user");
        this.project = (Project) request.getSession().getAttribute("project");
        this.team = (Team) request.getSession().getAttribute("team");
        // 获取当前系统时间，格式为--> yyyy-MM-dd HH:mm:ss
        this.time = new TimeGetTrans().getTime();
    }

    public void newDynamic() {
        //System.out.println(user.toString() + "用户");
        //System.out.println(project.toString() + "项目");
        //System.out.println("uId="+user.getuId()+",\n"
        //                    +"pId=" + project.getpId()+",\n"
        //                    +"action=" + action +",\n"
        //                    +"be=" + beId +",\n"
        //                    +"table="+table+",\n"
        //                    +"time="+time+",\n");
        //TODO 累赘？
        System.out.println(user.getuId()+project.getpId());
        dynamic.setuId(user.getuId());
        dynamic.setpId(project.getpId());
        dynamic.setAction(action);
        dynamic.setBeTable(table);
        dynamic.setBeOperated(beId);
        dynamic.setdTime(time);
        dynamic.settId(team.gettId());
        System.out.println(dynamic.toString());
        // 新增动态
        dynamicService.addDynamic(dynamic);

    }

}
