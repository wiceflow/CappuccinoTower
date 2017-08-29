package com.service;

import com.pojo.Taskinfo;

import java.util.List;

/**
 * Created by chen on 2017/8/29.
 */
public interface TaskinfoService {

    /**
     * 添加任务信息
     * @param taskinfo 任务信息实体类
     * @return 返回0代表失败，1代表成功
     */
    int addTaskinfo(Taskinfo taskinfo);

    /**
     * 删除一个任务信息
     * @param taskinfoId 根据ID来删除
     * @return 返回0代表失败，1代表成功
     */
    int deleteTaskinfo(int taskinfoId);

    /**
     * 更新任务信息
     * @param taskinfo 任务信息实体类
     * @return 返回0代表失败，1代表成功
     */
    int updateTaskinfo(Taskinfo taskinfo);

    /**
     * 查询任务信息
     * @param taskinfo 任务信息实体类
     * @param i 根据什么来查询（0代表ID，1代表名称）
     * @return
     */
    List<Taskinfo> selectTaskinfo(Taskinfo taskinfo,int i);
}
