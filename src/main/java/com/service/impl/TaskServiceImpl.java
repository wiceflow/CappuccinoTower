package com.service.impl;

import com.dao.TaskMapper;
import com.dao.TeamMapper;
import com.pojo.Task;
import com.pojo.TaskExample;
import com.service.TaskService;
import com.util.TimeGetTrans;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 2017/9/4.
 */
@Service
public class TaskServiceImpl implements TaskService {

    // slf4j日志配置
    private static final Logger _LOG = LoggerFactory.getLogger(TaskServiceImpl.class);
    @Autowired
    TaskMapper taskMapper;

    /**
     * 新增任务
     * @param task 任务实体类
     * @return
     */
    public int addTask(Task task) {
        //对taskinfo进行判断, taskinfoid为0 即使没有清单的任务
        if(task.getTaskinfoId()==null){
            task.setTaskinfoId(0);
        }

        TimeGetTrans timeGetTrans=new TimeGetTrans();
        task.setTaskCreatetime(timeGetTrans.getTime());
        try{
            taskMapper.insert(task);
        }catch (Exception e){
            _LOG.error("新增任务出错 --> Service层");
            return 0;
        }
        return task.getTaskId();
    }

    public int deleteTask(int taskId) {
        int i=taskMapper.deleteByPrimaryKey(taskId);
        if(i>0){
            return 1;
        }else {
            return 0;
        }
    }

    public int updateTask(Task task) {
        taskMapper.updateByPrimaryKey(task);
        return 1;
    }

    public List<Task> selectTask(Task task, int id) {
        List<Task> taskList=new ArrayList<Task>();
        Task task1=null;
        //根据任务ID进行查询
        if(id==0) {
            task1 = taskMapper.selectByPrimaryKey(task.getTaskId());
            taskList.add(task1);
            //若查询结果为空则返回null
            if (taskList == null || taskList.get(0).getTaskName() == null) {
                return null;
            }//否则返回这个list
            else {
                return taskList;
            }
        }
        return taskList;
    }

    public List<Task> QueryList() {
        TaskExample taskExample = new TaskExample();
        taskExample.setDistinct(true);
        List<Task> list = taskMapper.selectByExample(taskExample);
        return list;
    }
}
