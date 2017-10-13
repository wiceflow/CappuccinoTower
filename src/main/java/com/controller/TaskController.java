package com.controller;

import com.pojo.Task;
import com.service.DynamicService;
import com.service.TaskService;
import com.util.AjaxResult;
import com.util.DynamicTool;
import com.util.ObtainSession;
import com.util.TimeGetTrans;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    private DynamicService dynamicService;
    @Autowired
    private TaskService taskService;
    /**
     * 新增任务
     * @param task
     * @param request
     * @return
     */
    @RequestMapping(value = "AddTask",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult addTask(Task task,@RequestParam("endTime")String time1, HttpServletRequest request) throws ParseException {
        System.out.println(111);
        System.out.println(time1);
        System.out.println(task.toString());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        task.setTaskFinishtime(sdf.parse(time1));
        task.setStatus(1);
        // 表示无 先这样测试
        task.setTaskinfoId(0);
        // 设置任务创建者
        task.setTaskUser(new ObtainSession(request).getUser().getuId());
        // 返回此次新增任务的ID
        int i = taskService.addTask(task);
        if (i==0){
            _LOG.error("向数据库插入新的一个任务出错 --> Controller层");
        }
        else{
            task.setTaskId(i);
            //动态-->将操作信息存入动态表，因为用到session所以在controller中控制，不再去service中控制，减少代码使用
            //动态操作
            DynamicTool d = new DynamicTool(i,"task","新建了一个任务",request,dynamicService);
            d.newDynamic();
        }
        //返回1，表示任务添加成功
        return new AjaxResult(1,"添加任务成功");
    }

    /**
     * 更新任务
     * @param task
     * @param request
     * @return
     */
    @RequestMapping(value = "UpdateTask",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult updateTask(Task task, @RequestParam("endTime")String time1, HttpServletRequest request) throws ParseException {
        //获取系统当前时间
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        task.setTaskFinishtime(sdf.parse(time1));
        task.setTaskCreatetime(sdf2.parse(sdf2.format(new Date())));
        task.setStatus(1);
        // 表示无 先这样测试
        task.setTaskinfoId(0);
        if(task!=null){
            //task.setTaskId(task.getTaskId());
            int m=taskService.updateTask(task);
            System.out.println(task.getTaskId());
            System.out.println("M="+m);
            if(m==1){
                //动态操作
                DynamicTool d = new DynamicTool(task.getTaskId(),"task","更新了一个任务",request,dynamicService);
                d.newDynamic();
                System.out.println("更新成功");
                return new AjaxResult(1,"更新任务成功");
            }else{
                System.out.println("更新失败");
                return new AjaxResult(0,"更新任务失败");
            }
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
    public AjaxResult TaskInformation(Task task,String taskid, HttpServletRequest request){
        task.setTaskId(Integer.valueOf(taskid));
        List<Task> taskList1 = taskService.selectTask(task,0);
            if(taskList1!=null){
                Task task2 = taskList1.get(0);
                //返回1，表示查询任务信息成功
                return new AjaxResult(1,"查询成功");
            }else {
                //返回0，表示查询任务信息失败
                return new AjaxResult(0,"查询失败");
            }
        }

    /**
     * 向前台遍历所有的任务
     * @param request
     * @return
     */
    @RequestMapping(value = "TaskList",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult TaskList(HttpServletRequest request){
        List<Task> taskList=taskService.QueryList();
        System.out.println(taskList);
        //request.getSession().setAttribute("tasklist",taskList);
        //返回1，表示遍历任务成功
        return new AjaxResult(1,"遍历任务成功",taskList);
    }

    /**
     * 遍历任务List后，点击查看该任务的信息
     * @param task
     * @param request
     * @return
     */
    @RequestMapping(value = "TaskListInfor",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult TaskListInfor(Task task,int type,HttpServletRequest request){
        System.out.println(task.getTaskId());
        System.out.println("进入查询单个Task");
        List<Task> taskList = taskService.selectTask(task,type);
        if(taskList!=null&&taskList.get(0).getTaskName()!=null){
            Task task1 = taskList.get(0);
            //返回1，表示任务信息显示成功
            System.out.println(task1);
            return new AjaxResult(1,"任务信息显示成功",task1);
        }else{
            //返回0，表示任务信息显示失败
            return new AjaxResult(0,"任务信息显示失败");
        }
    }

    /**
     * 删除任务
     * @param task
     * @return
     */
    @RequestMapping(value = "TaskDelete",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult TaskDelete(Task task,HttpServletRequest request){
        int i = taskService.deleteTask(task.getTaskId());
        int m = task.getTaskId();
        if(i==1){
            //动态操作
            DynamicTool d = new DynamicTool(m,"task","删除了一个任务",request,dynamicService);
            d.newDynamic();
            //返回1，表示删除任务成功
            return new AjaxResult(1,"删除任务成功");
        }else{
            //返回0，表示删除任务失败
            return new AjaxResult(0,"删除任务失败");
        }
    }
}
