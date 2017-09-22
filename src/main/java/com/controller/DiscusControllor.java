package com.controller;

import com.pojo.Discus;
import com.pojo.Project;
import com.service.DiscusService;
import com.service.ProjectService;
import com.util.AjaxResult;
import com.util.ObtainSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**讨论表
 * Created by WU on 2017/9/15.
 */
@Controller
@RequestMapping("/discus")
public class DiscusControllor {
    // slf4j日志配置
    private static final Logger _LOG = LoggerFactory.getLogger(ProjectController.class);

    //注入项目Service
    @Autowired
    ProjectService projectService;
    //注入讨论Service
    @Autowired
    DiscusService discusService;

    /**
     * 新建讨论
     * @param pId
     * @param discus
     * @return
     */
    @RequestMapping(value ="/creatDiscus")
    @ResponseBody
    public AjaxResult creatDiscus(@RequestParam("pId")int pId, Discus discus, HttpServletRequest request){
        System.out.println("我进入了creatDiscus");
        System.out.println(new ObtainSession(request).getUser().getuId());
        //通过session取值将uid uName
        discus.setuId(new ObtainSession(request).getUser().getuId());
        discus.setuName(new ObtainSession(request).getUser().getuName());
        //将项目Id放入其中
        Project project=new Project();
        project.setpId(pId);
        List<Project> projectList = projectService.selectProject(project, 0);
        System.out.println(projectList.get(0)+"hhahhhhhhhh");
        if (projectList.get(0)!=null){
                Discus discus1 = discusService.addDiscus(discus, projectList.get(0));
                System.out.println(discus1+"11111111111111");
                System.out.println("进入这里了");
                return new AjaxResult(1,"成功",discus1);
            }else {
                return new AjaxResult(0,"badness");
        }
    }

    /**
     * 遍历该项目中所有的评论
     * @return
     */
    @RequestMapping(value = "/QueryDiscus")
    @ResponseBody
    public AjaxResult QueryDiscus(@RequestParam("pId")int pId){
        System.out.println("进入了query");
        List<Discus> discusList = discusService.QueryDiscus(pId);
        if (discusList!=null){
            System.out.println("query到这里了");
            for(int i=0;i<discusList.size();i++){
                System.out.println(discusList.get(i));
            }
            return new AjaxResult(1,"成功",discusList);
        }else {
            return new AjaxResult(0,"失败");
        }
    }
}
