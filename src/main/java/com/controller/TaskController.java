package com.controller;

import com.dto.Taskdto;
import com.pojo.Task;
import com.pojo.User;
import com.service.DynamicService;
import com.service.TaskService;
import com.service.UserService;
import com.util.AjaxResult;
import com.util.DynamicTool;
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
    //注入动态依赖
    @Autowired
    DynamicService dynamicService;

    //注入任务依赖
    @Autowired
    TaskService taskService;

    //注入用户依赖
    @Autowired
    UserService userService;

    /**
     * 新增任务
     *
     * @param task
     * @param request
     * @return
     */
    @RequestMapping(value = "AddTask")
    // TODO 优化参数  重设返回值
    public AjaxResult addTask(Task task, HttpServletRequest request) {

        // 返回此次新增任务的ID
        int i = taskService.addTask(task);
        if (i == 0) {
            _LOG.error("向数据库插入新的一个任务出错 --> Controller层");
        } else {
            task.setTaskId(i);
            //动态-->将操作信息存入动态表，因为用到session所以在controller中控制，不再去service中控制，减少代码使用
            //动态操作
            DynamicTool d = new DynamicTool(i, "task", "新建了一个任务", request, dynamicService);
            d.newDynamic();
        }
        //返回1，表示任务添加成功
        return new AjaxResult(1, "添加任务成功");
    }

    /**
     * 更新任务
     *
     * @param task
     * @param request
     * @return
     */
    @RequestMapping(value = "UpdateTask", method = RequestMethod.POST)
    public AjaxResult updateTask(Task task, HttpServletRequest request) {
        HttpSession session = request.getSession();
        //获取系统当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date TaskCreatetime = null;
        try {
            TaskCreatetime = sdf.parse(sdf.format(new Date()));

        } catch (ParseException e) {

            e.printStackTrace();
        }
        task.setTaskCreatetime(TaskCreatetime);
        if (task != null) {
            task.setTaskId(task.getTaskId());
            int i = task.getTaskId();
            int m = taskService.updateTask(task);
            if (m == 1) {
                //动态操作
                DynamicTool d = new DynamicTool(i, "task", "更新了一个任务", request, dynamicService);
                d.newDynamic();
                System.out.println("更新成功");
                return new AjaxResult(1, "更新任务成功");
            } else {
                System.out.println("更新失败");
                return new AjaxResult(0, "更新任务失败");
            }
        }
        return null;
    }

    /**
     * 创建任务后修改前查看的信息
     *
     * @param task
     * @param taskid
     * @param request
     * @return
     */
    @RequestMapping(value = "Taskinformation", method = RequestMethod.GET)
    public AjaxResult TaskInformation(Task task, String taskid, HttpServletRequest request) {
        HttpSession session = request.getSession();
        task.setTaskId(Integer.valueOf(taskid));
        List<Task> taskList1 = taskService.selectTask(task, 0);
        if (taskList1 != null) {
            Task task2 = taskList1.get(0);
            request.setAttribute("task2", task2);
            //返回1，表示查询任务信息成功
            return new AjaxResult(1, "查询成功");
        } else {
            //返回0，表示查询任务信息失败
            return new AjaxResult(0, "查询失败");
        }
    }

    /**
     * 向前台遍历所有的任务
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "TaskList")
    public AjaxResult TaskList(HttpServletRequest request) {
        List<Task> taskList = taskService.QueryList();
        System.out.println(taskList);
        request.getSession().setAttribute("tasklist", taskList);
        //返回1，表示遍历任务成功
        return new AjaxResult(1, "遍历任务成功");
    }

    /**
     * 遍历任务List后，点击查看该任务的信息
     *
     * @param task
     * @param taskid
     * @param request
     * @return
     */
    @RequestMapping(value = "TaskListInfor", method = RequestMethod.GET)
    public AjaxResult TaskListInfor(Task task, String taskid, HttpServletRequest request) {
        List<Task> taskList = taskService.selectTask(task, Integer.parseInt(taskid));
        if (taskList != null) {
            Task task1 = taskList.get(0);
            request.setAttribute("task1", task1);
            //返回1，表示任务信息显示成功
            return new AjaxResult(1, "任务信息显示成功");
        } else {
            //返回0，表示任务信息显示失败
            return new AjaxResult(0, "任务信息显示失败");
        }
    }

    /**
     * 删除任务
     *
     * @param taskid
     * @return
     */
    @RequestMapping(value = "TaskDelete", method = RequestMethod.GET)
    public AjaxResult TaskDelete(String taskid, HttpServletRequest request) {
        int i = taskService.deleteTask(Integer.parseInt(taskid));
        int m = Integer.parseInt(taskid);
        if (i == 1) {
            //动态操作
            DynamicTool d = new DynamicTool(m, "task", "删除了一个任务", request, dynamicService);
            d.newDynamic();
            //返回1，表示删除任务成功
            return new AjaxResult(1, "删除任务成功");
        } else {
            //返回0，表示删除任务失败
            return new AjaxResult(0, "删除任务失败");
        }
    }

    @RequestMapping(value = "selectTask")
    @ResponseBody
    public AjaxResult selectTask(@RequestParam("taskId") int taskId) {
        Task task = new Task();
        task.setTaskId(taskId);
        List<Taskdto> taskdtoList = taskService.DtoQueryList(task);
        if (taskdtoList != null || taskdtoList.size() != 0) {
            return new AjaxResult(1, "查询任务详情成功", taskdtoList.get(0));
        } else {
            return new AjaxResult(0, "查询任务详情失败");
        }
    }
}