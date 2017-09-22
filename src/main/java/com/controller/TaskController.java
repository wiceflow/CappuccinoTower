package com.controller;

import com.pojo.Task;
import com.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by chen on 2017/9/4.
 * 任务控制层
 */
@Controller
@RequestMapping(value = "Task")
public class TaskController {
    // slf4j日志配置
    private static final Logger _LOG = LoggerFactory.getLogger(TaskController.class);
    //注入依赖
    @Autowired
    private TaskService taskService;
    /**
     * 新增任务
     * @param task
     * @param request
     * @return
     */
    @RequestMapping(value = "AddTask",method = RequestMethod.POST)
    // aa用来判断是从清单里添加还是直接添加的任务  aa=1是从清单里创建任务   aa=0是直接创建任务
    // TODO 优化参数  重设返回值
    public void addTask(Task task, HttpServletRequest request,String taskinfoid,int aa){
        if(aa==1)
        {
            task.setTaskinfoId(Integer.valueOf(taskinfoid));
        }
        // 返回此次新增任务的ID
        int i = taskService.addTask(task);
        if (i==0){
            _LOG.error("向数据库插入新的一个任务出错 --> Controller层");
        }

        task.setTaskId(i);

    }

    /**
     * 更新任务
     * @param task
     * @param request
     * @return
     */
    @RequestMapping(value = "UpdateTask",method = RequestMethod.POST)
    public String updateTask(Task task, HttpServletRequest request){
        HttpSession session = request.getSession();
        //获取系统当前时间
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date TaskCreatetime=null;
        try {
            TaskCreatetime= sdf.parse(sdf.format(new Date()));

        } catch (ParseException e) {

            e.printStackTrace();
        }
        task.setTaskCreatetime(TaskCreatetime);
        if(task!=null){
            task.setTaskId(task.getTaskId());
                int m=taskService.updateTask(task);
            if(m==1){
                System.out.println("更新成功");
            }else{
                System.out.println("更新失败");
            }
            session.setAttribute("task",task);
            return "task/updateTask";
        }
        return null;
    }

    /**
     * 创建任务后修改前查看的信息
     * @param task
     * @param taskid
     * @param request
     * @return
     */
    @RequestMapping(value = "Taskinformation",method = RequestMethod.GET)
    public String TaskInformation(Task task,String taskid, HttpServletRequest request){
        HttpSession session = request.getSession();
        task.setTaskId(Integer.valueOf(taskid));
        List<Task> taskList1 = taskService.selectTask(task,0);
            if(taskList1!=null){
                Task task2 = taskList1.get(0);
                request.setAttribute("task2",task2);
                return "task/TaskInformation";
            }else {
                return "AllFail";
            }
        }

    /**
     * 向前台遍历所有的任务
     * @param request
     * @return
     */
    @RequestMapping(value = "TaskList")
    public String TaskList(HttpServletRequest request){
        List<Task> taskList=taskService.QueryList();
        System.out.println(taskList);
        request.getSession().setAttribute("tasklist",taskList);

        return "task/TaskList";
    }

    /**
     * 遍历任务List后，点击查看该任务的信息
     * @param task
     * @param taskid
     * @param request
     * @return
     */
    @RequestMapping(value = "TaskListInfor",method = RequestMethod.GET)
    public String TaskListInfor(Task task,String taskid,HttpServletRequest request){
        List<Task> taskList = taskService.selectTask(task, Integer.parseInt(taskid));
        if(taskList!=null){
            Task task1 = taskList.get(0);
            request.setAttribute("task1",task1);
            return "Task/UpdateTask";
        }else{
            return "AllFail";
        }
    }

    /**
     * 删除任务
     * @param taskid
     * @return
     */
    @RequestMapping(value = "TaskDelete",method = RequestMethod.GET)
    public String TaskDelete(String taskid){
        int i = taskService.deleteTask(Integer.parseInt(taskid));
        if(i==1){
            System.out.println("删除成功——————————————————————————");
            return "AllSuccess";
        }else{
            System.out.println("删除失败——————————————————————————");
            return "AllFail";
        }
    }
}
