package com.controller;

import com.pojo.Dynamic;
import com.pojo.Project;
import com.pojo.User;
import com.service.DynamicService;
import com.service.ProjectService;
import com.service.UserService;
import com.util.DynamicTool;
import com.util.ObtainSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WU on 2017/8/29.
 */
@Controller
@RequestMapping("/project")
@Transactional
public class ProjectController {
    // slf4j日志配置
    private static final Logger _LOG = LoggerFactory.getLogger(ProjectController.class);
    // 注入项目服务依赖[ProjectService]
    @Autowired
    ProjectService projectService;
    //注入用户服务依赖[UserService]
    @Autowired
    UserService userService;
    // 注入DynamicService依赖 [添加动态]
    @Autowired
    DynamicService dynamicService;

    // 创建一个动态的PO
    Dynamic dynamic = new Dynamic();

    /**
     * 跳转到输入项目信息界面
     *
     * @return
     */
    @RequestMapping("/goCreateProject")
    public ModelAndView goCreateProject() {
        List<User> listUser = userService.QueryList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("listUser", listUser);
        modelAndView.setViewName("project/putProject");
        return modelAndView;
    }

    /**
     * 新增项目
     *
     * @param project
     * @return
     */
    @RequestMapping("/putProject")
    public ModelAndView putProject(Project project, @RequestParam("uId") List<Integer> uId, HttpServletRequest requestr) {

        // 从页面中接收 Project 数据
        String ProjectName = project.getpName();
        String ProjectDescribe = project.getpDescribe();

        // 项目创建者ID
        int superId = new ObtainSession(requestr).getUser().getuId();
        uId.add(superId);
        // 获取团队ID
        int teamId = new ObtainSession(requestr).getTeam().gettId();
        project.settId(teamId);
        // 调用实现类，插入项目数据(返回项目)
        Project projectback = projectService.addProject(project, uId);
        // 将新建的project丢入session中备用
        requestr.getSession().setAttribute("project", projectback);
        // 动态-->将操作信息存入动态表,因为用到session所以在Controller中控制,不再去Service中控制,减少代码使用
        // 动态操作
        DynamicTool d = new DynamicTool(projectback.getpId(), "project", "创建了这个项目: ", requestr, dynamicService);
        d.newDynamic();

        //将数据放到modelAndView
        //向页面返回项目 ID ，，名字，，描述
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pId", projectback.getpId());
        modelAndView.addObject("ProjectName", ProjectName);
        modelAndView.addObject("ProjectDescribe", ProjectDescribe);

        modelAndView.setViewName("project/afterProject");
        return modelAndView;
    }

    /**
     * 按照模糊查询名字 进行名字选择组员
     *
     * @param uName 用户姓名
     * @return
     */
    @RequestMapping("/selectName")
    public ModelAndView checkName(String uName) {
        // 模糊查询名字返回的List集合
        List<User> listUser = userService.listByUname(uName);
        ModelAndView modelAndView = new ModelAndView();
        // 将List放到ModelAndView中
        //将模糊查询到的List集合返回到页面中
        modelAndView.addObject("listUser", listUser);
        modelAndView.setViewName("project/afterselect");
        return modelAndView;
    }

    /**
     * 根据id查找修改项目对象
     *
     * @param pId
     */
    @RequestMapping(value = "/selectProjectById", method = RequestMethod.GET)
    public String selectProjectById(@RequestParam("pId") int pId, HttpServletRequest request) {
        Project project = new Project();
        project.setpId(pId);
        //调用select List
        //创建一个新的对象，用来接收返回的 List<Project>.get(0),因为根据ID只能查找到对象
        Project project1 = new Project();
        //判断project是否为空
        if (project != null) {
            List<Project> projectList = projectService.selectProject(project, 0);
            if (projectList == null || projectList.size() == 1) {
                _LOG.error("Project控制层获得的List列表为空 --> 根据id查找修改项目对象");
            } else {
                project1 = projectList.get(0);
                _LOG.error(project1.toString());
            }
        }
        //将根据ID查找到的对象放到session域中
        request.getSession().setAttribute("project", project1);

        // 动态-->将操作信息存入动态表,因为用到session所以在Controller中控制,不再去Service中控制,减少代码使用
        // 动态操作
        DynamicTool d = new DynamicTool(project1.getpId(), "project", "进入了这个项目: ", request, dynamicService);
        d.newDynamic();

        //跳转到修改页面
        return "project/updateProject";
    }


    /**
     * 修改项目信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateProject",method = RequestMethod.POST)
    public String updateProject(HttpServletRequest request) {
        //TODO 后面再修改获得的方式
        //将项目信息从页面的session中获取出来
        Project project = new ObtainSession(request).getProject();
        //将要修改的信息从JSP页面中获取
        //获取项目的名字
        String pName = request.getParameter("pName");
        //获取项目的描述
        String pDescribe = request.getParameter("pDescribe");
        //获取是否屏蔽敏感信息
        String qq = request.getParameter("pSensitive");
        int pSensitive = 0;
        if (qq != null) {
            pSensitive = 1;
        }
        //将要修改的信息放到Project中
        project.setpName(pName);
        project.setpDescribe(pDescribe);
        project.setpSensitive(pSensitive);

        //调用updatebyID的方法
        int i = projectService.updateProject(project);

        //判断是否成功
        if (i == 1) {
            _LOG.error("修改项目成功!  ");
            // 动态操作
            DynamicTool d = new DynamicTool(project.getpId(), "project", "修改了这个项目: ", request, dynamicService);
            d.newDynamic();
        }else {
            _LOG.error("修改项目失败!  ");
        }
        return "project/success";
    }


    /**
     * 根据ID对项目进行删除
     *
     * @return
     */
    @RequestMapping(value = "/deleteProject", method = RequestMethod.GET)
    public String deleteProject(HttpServletRequest request) {
        // 定义操作返回值，默认为0 [失败的意思]
        int issuccess = 0;
        // 获取session中当前的项目信息
        Project project1 = new ObtainSession(request).getProject();
        System.out.println(project1.toString() + "打印的project");
        // 删除项目
        issuccess = projectService.deleteProject(project1);
        //判断是否成功
        if (issuccess == 1) {
            // 动态操作
            DynamicTool d = new DynamicTool(project1.getpId(), "project", "删除了这个项目: ", request, dynamicService);
            d.newDynamic();
            _LOG.error(project1.getpName() + " 被成功删除");
        }
        return "project/success";
    }


    /**
     * 根据用户ID 和 团队ID，将其所参加的项目遍历出来
     *
     * @param tId
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryProjectByUserId", method = RequestMethod.GET)
    public String queryProjectByUserId(HttpServletRequest request,@RequestParam("tId")int tId) {
        // 将页面传来的用户ID变成int类型的
        int uId = new ObtainSession(request).getUser().getuId();
        List<Project> projectList = projectService.QueryList(uId);
        // TODO 当前团队的项目  是否可以修改在Service层
        List<Project> projects = new ArrayList<Project>();
        if (projectList != null && projectList.size() != 0) {
            for (Project project:projectList)
            {
                // 将匹配的Project存入新的List中
                if (project.gettId()==tId){
                    projects.add(project);
                }
            }
            return "project/querylist";
        }
        _LOG.error("遍历该用户对应的项目表出错-->Controller层");
        return "project/success";
    }
}
