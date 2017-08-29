package com.service;

import com.pojo.Task;

import java.util.List;

/**
 * Created by chen on 2017/8/29.
 */
public interface TaskService {

    /**
     * 增加一个任务
     * @param task 任务实体类
     * @return 返回0代表失败，1代表成功
     */
    int addTask(Task task);

    /**
     * 删除一个任务
     * @param taskId 根据ID来删除
     * @return 返回0代表失败，1代表成功
     */
    int deleteTask(int taskId);

    /**
     * 更新一个任务
     * @param task 任务实体类
     * @return 返回0代表失败，1代表成功
     */
    int updateTask(Task task);

    /**
     * 查询任务
     * @param task 任务实体类
     * @param i 根据什么来查询（0代表ID，1代表名称)
     * @return
     */
    List<Task> selectTask(Task task,int i);
}
