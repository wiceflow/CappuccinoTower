package com.controller;

import com.pojo.Project;
import com.pojo.Taskinfo;
import com.service.TaskinfoService;
import com.util.ObtainSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by chen on 2017/9/5.
 * 任务清单控制器
 */
@Controller
@Transactional
@RequestMapping(value = "TaskInfo")
public class TaskinfoController {
    // slf4j日志配置
    private static final Logger _LOG = LoggerFactory.getLogger(TaskinfoController.class);


    @Autowired
    private TaskinfoService taskinfoService;

    /**
     * 新增任务清单
     * @param taskinfo
     * @param request
     * @return
     */
    @RequestMapping(value = "addTaskInfo")
    public String addTaskInfo(Taskinfo taskinfo, HttpServletRequest request){
        int pId = new ObtainSession(request).getProject().getpId();
        //调用addTaskinfo方法   --> 返回了任务清单的ID
        taskinfo = taskinfoService.addTaskinfo(taskinfo,pId);
        //TODO 将刚创建的任务清单对象存入session中
        request.getSession().setAttribute("taskinfo",taskinfo);
        if(taskinfo==null){
            _LOG.error("向数据库插入数据失败");
        }
        return "AllFail";
    }

    /**
     * 任务清单创建后的信息显示    无用，整合完后看是否删除
     * @param taskinfo
     * @param taskinfoid
     * @param request
     * @return
     */
    @RequestMapping(value = "TaskInfoinformation",method = RequestMethod.GET)
    public String TaskInfoinformation(Taskinfo taskinfo,String taskinfoid,HttpServletRequest request){
        HttpSession session = request.getSession();
        //得到前台传入的taskinfoid
        taskinfo.setTaskinfoId(Integer.valueOf(taskinfoid));
        //调用selectTeskinfo方法
        List<Taskinfo> taskinfoList = taskinfoService.selectTaskinfo(taskinfo, 0);
        //若List不为空，则取出List中第一个元素，存入session中
        if (taskinfoList != null) {
            Taskinfo taskinfo1 = taskinfoList.get(0);
            request.getSession().setAttribute("taskinfo1", taskinfo1);
            return "TaskInfo/TaskInfoinformation";
        } else {//若为空，则返回AllFail页面
            return "AllFail";
        }
    }

    /**
     * 更新任务清单信息
     * @param taskinfo
     * @return
     */
    //TODO 貌似不用Request.getParmeter 获取不到值
    @RequestMapping(value = "updateTaskInfo",method = RequestMethod.POST)
    public String updateTaskInfo(Taskinfo taskinfo){
        // TODO 前端传ID记得隐藏
        //调用
        taskinfo = taskinfoService.updateTaskinfo(taskinfo);

        if (taskinfo!=null)
        {
            return "AllSuccess";
        }
        return null;
    }

    /**
     * 遍历任务清单列表
     * @param request
     * @return
     */
    //TODO 到时候返回一个Map 封装成JSON
    @RequestMapping(value = "taskInfoList")
    public String TaskInfoList (HttpServletRequest request){
        //调用querylist方法将所有任务清单取出
        List<Taskinfo> taskinfoList = taskinfoService.QueryList();
        if (taskinfoList==null||taskinfoList.size()==0) {
            _LOG.error("读取到的任务清单列表为空");
            return null;
        }
        // 以Map格式返回JSOn数据
        return "TaskInfo/TaskinfoList";
    }

    /**
     * 删除任务清单
     * @param taskinfoid
     * @return
     */
    @RequestMapping(value = "deleteTaskInfo")
    public String deleteTaskInfo(String taskinfoid){
        //调用deleteteskinfo方法根据页面传回的id删除任务清单
        int i = taskinfoService.deleteTaskinfo(Integer.parseInt(taskinfoid));
        if(i==1){
            return "redirect:taskInfoList";
        }else{
            return "AllFail";
        }
    }
}
