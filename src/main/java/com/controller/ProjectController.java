package com.controller;

import com.dto.ProjectList;
import com.pojo.Project;
import com.pojo.User;
import com.service.DynamicService;
import com.service.ProjectService;
import com.service.UserService;
import com.util.AjaxResult;
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

    @Autowired
    DynamicService dynamicService;
    /**
     * 跳转到输入项目信息界面
     * @return
     */
    @RequestMapping("/goCreateProject")
    public String  goCreateProject(){

       return "project/createproject";
    }

    /**
     * 新增项目
     * @param project
     * @return
     */
    @RequestMapping("/putProject")
    public String putProject( Project project, @RequestParam("uId") List<Integer> uId,HttpServletRequest request){

        //调用实现类，插入项目数据(返回项目)
        Project projectback = projectService.addProject(project, uId);
        //存session
        request.getSession().setAttribute("project",projectback);
        //动态-->将操作信息存入动态表，因为用到session所以在Controller中控制，不再去Service中控制，减少代码使用
        //动态操作
        DynamicTool d=new DynamicTool(projectback.getpId(),"project","创建了这个项目",request,dynamicService);
        d.newDynamic();
        return "AllSuccess";
    }

    /**
     * 按照模糊查询名字 进行名字选择组员
     * @param uName  用户姓名
     * @return
     */
    @RequestMapping(value = "/selectName",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult checkName(@RequestParam("uName") String uName)
    {
        System.out.println(uName+"__________");
        // 模糊查询名字返回的List集合
        List<User> listUser=userService.listByUname(uName);
        if(listUser!=null){
            System.out.println(listUser.get(0));
            return new AjaxResult(1,"查找成功",listUser);
        }
        return new AjaxResult(0,"查找失败");
    }

    /**
     * 根据id查找修改项目对象
     * @param pId
     */
    @RequestMapping(value = "/selectProjectById", method = RequestMethod.GET)
    public AjaxResult selectProjectById(@RequestParam("pId") int pId, HttpServletRequest request) {
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
                return new AjaxResult(0,"查找失败");
            } else {
                project1 = projectList.get(0);
                _LOG.error(project1.toString());
                return new AjaxResult(1,"查找成功",project1);
            }
        }
        //将根据ID查找到的对象放到session域中
//        request.getSession().setAttribute("project", project1);

        // 动态-->将操作信息存入动态表,因为用到session所以在Controller中控制,不再去Service中控制,减少代码使用
        // 动态操作
//        DynamicTool d = new DynamicTool(project1.getpId(), "project", "进入了这个项目: ", request, dynamicService);
//        d.newDynamic();

        //跳转到修改页面
        return null;
    }


    /**
     * 修改项目信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateProject",method = RequestMethod.POST)
    public AjaxResult updateProject(HttpServletRequest request) {
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
            return new AjaxResult(1,"修改成功");
        }else {
            _LOG.error("修改项目失败!  ");
            return new AjaxResult(0,"修改失败");
        }
    }


    /**
     * 根据ID对项目进行删除
     *
     * @return
     */
    @RequestMapping(value = "/deleteProject", method = RequestMethod.GET)
    public AjaxResult deleteProject(HttpServletRequest request) {
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
            return new AjaxResult(1,"删除成功");
        }
        return new AjaxResult(0,"删除失败");
    }


    /**
     * 根据用户ID 和 团队ID，将其所参加的项目遍历出来
     *
     * @param tId
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryProjectByUserId", method = RequestMethod.GET)
    public AjaxResult queryProjectByUserId(HttpServletRequest request,@RequestParam("tId")int tId) {
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
            return new AjaxResult(1,"查找成功",projects);
        }
        _LOG.error("遍历该用户对应的项目表出错-->Controller层");
        return new AjaxResult(0,"查找失败");
    }


    /**
     * 根据uId查找返回项目信息
     * @param request
     * @param uId
     * @return
     */
    @RequestMapping(value = "ListByUid")
    @ResponseBody
    public AjaxResult ListByUid(HttpServletRequest request,@RequestParam("uId")int uId){
        System.out.println(".....");
        List<Project> projectList = projectService.QueryList(uId);
        if(projectList!=null&&projectList.size()!=0){
            return new AjaxResult(1,"查找成功",projectList);
        }else{
            return new AjaxResult(0,"查找失败");
        }
    }

    /**
     * 根据项目pId 将项目相关的所有信息遍历出来
     * @param pId
     * @param request
     * @return
     */
    @RequestMapping(value = "displayProject")
    @ResponseBody
    public AjaxResult displayProject(@RequestParam("pId")int pId,HttpServletRequest request){
        System.out.println("进来了dis");
        int uId=new ObtainSession(request).getUser().getuId();
        ProjectList projectList = projectService.projectALL(pId, uId);
        System.out.println(projectList.getpName());
        if (projectList!=null){
            return new AjaxResult(1,"成功",projectList);
        }
        return new AjaxResult(0,"失败");
    }
}
