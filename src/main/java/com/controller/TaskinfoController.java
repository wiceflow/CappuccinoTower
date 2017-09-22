package com.controller;

import com.pojo.Project;
import com.pojo.Taskinfo;
import com.service.DynamicService;
import com.service.TaskinfoService;
import com.util.AjaxResult;
import com.util.DynamicTool;
import com.util.ObtainSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @Autowired
    private DynamicService dynamicService;

    /**
     * 新增任务清单
     * @param taskinfo
     * @param request
     * @return
     */
    @RequestMapping(value = "addTaskInfo")
    @ResponseBody
    public AjaxResult addTaskInfo(@RequestParam("pId")int pId, Taskinfo taskinfo, HttpServletRequest request){
        //从session中取出user 的 id
        taskinfo.setTaskinfoUser(new ObtainSession(request).getUser().getuId());
        //调用addTaskinfo方法   --> 返回了任务清单的ID
        taskinfo = taskinfoService.addTaskinfo(taskinfo,pId);
        int i = taskinfo.getTaskinfoId();
        if(taskinfo==null){
            _LOG.error("向数据库插入数据失败");
            return new AjaxResult(0,"新增任务清单失败");
        }
        //动态操作
        DynamicTool d = new DynamicTool(i,"taskinfo","新建了一个任务清单",request,dynamicService);
        d.newDynamic();
        return new AjaxResult(1,"新增任务清单成功",taskinfo);
    }

    /**
     * 任务清单创建后的信息显示    无用，整合完后看是否删除
     * @param taskinfo
     * @param taskinfoid
     * @param request
     * @return
     */
    @RequestMapping(value = "TaskInfoinformation",method = RequestMethod.GET)
    public AjaxResult TaskInfoinformation(Taskinfo taskinfo,String taskinfoid,HttpServletRequest request){
        HttpSession session = request.getSession();
        //得到前台传入的taskinfoid
        taskinfo.setTaskinfoId(Integer.valueOf(taskinfoid));
        //调用selectTeskinfo方法
        List<Taskinfo> taskinfoList = taskinfoService.selectTaskinfo(taskinfo, 0);
        //若List不为空，则取出List中第一个元素，存入session中
        if (taskinfoList != null) {
            Taskinfo taskinfo1 = taskinfoList.get(0);
            request.getSession().setAttribute("taskinfo1", taskinfo1);
            //返回1，表示返回任务清单信息成功
            return new AjaxResult(1,"返回任务清单信息成功");
        } else {//若为空，则返回AllFail页面
            //返回0，表示返回任务清单信息失败
            return new AjaxResult(0,"返回任务清单信息失败");
        }
    }

    /**
     * 更新任务清单信息
     * @param taskinfo
     * @return
     */
    //TODO 貌似不用Request.getParmeter 获取不到值
    @RequestMapping(value = "updateTaskInfo",method = RequestMethod.POST)
    public AjaxResult updateTaskInfo(Taskinfo taskinfo,HttpServletRequest request){
        // TODO 前端传ID记得隐藏
        //调用
        taskinfo = taskinfoService.updateTaskinfo(taskinfo);
        int i = taskinfo.getTaskinfoId();
        if (taskinfo!=null)
        {
            //动态操作
            DynamicTool d = new DynamicTool(i,"taskinfo","更新了一个任务",request,dynamicService);
            d.newDynamic();
            //返回1，表示更新任务清单信息成功
            return new AjaxResult(1,"更新任务清单信息成功");
        }
        //返回0，表示更新任务清单信息失败
        return new AjaxResult(0,"更新任务清单信息失败");
    }

    /**
     * 遍历任务清单列表
     * @param request
     * @return
     */
    //TODO 到时候返回一个Map 封装成JSON
    @RequestMapping(value = "taskInfoList")
    @ResponseBody
    public AjaxResult TaskInfoList (HttpServletRequest request,@RequestParam("pId")int pId){
        //根据项目id  调用querylist方法将所有任务清单取出
        List<Taskinfo> taskinfoList = taskinfoService.QueryList(pId);
        if (taskinfoList==null||taskinfoList.size()==0) {
            _LOG.error("读取到的任务清单列表为空");
            //返回0，表示返回任务清单列表失败
            return new AjaxResult(0,"返回任务清单列表失败");
        }
        // 以Map格式返回JSOn数据
        //返回0，表示返回任务清单列表成功
        return new AjaxResult(1,"返回任务清单列表成功",taskinfoList);
    }

    /**
     * 删除任务清单
     * @param taskinfoid
     * @return
     */
    @RequestMapping(value = "deleteTaskInfo")
    public AjaxResult deleteTaskInfo(String taskinfoid,HttpServletRequest request){
        //调用deleteteskinfo方法根据页面传回的id删除任务清单
        int i = taskinfoService.deleteTaskinfo(Integer.parseInt(taskinfoid));
        int m = Integer.parseInt(taskinfoid);
        if(i==1){
            //动态操作
            DynamicTool d = new DynamicTool(m,"taskinfo","删除了一个任务",request,dynamicService);
            d.newDynamic();
            //返回1，表示删除任务清单成功
            return new AjaxResult(1,"删除任务清单成功");
        }else{
            //返回0，表示删除任务清单失败
            return new AjaxResult(0,"删除任务清单失败");
        }
    }
}
