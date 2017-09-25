package com.service.impl;

import com.dao.TaskMapper;
import com.dao.TaskinfoMapper;
import com.pojo.Task;
import com.pojo.TaskExample;
import com.pojo.Taskinfo;
import com.pojo.TaskinfoExample;
import com.service.TaskinfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 2017/9/5.
 * 任务清单Service层
 */
@Service
public class TaskinfoServiceImpl implements TaskinfoService {
    // slf4j日志配置
    private static final Logger _LOG = LoggerFactory.getLogger(TaskinfoServiceImpl.class);

    @Autowired
    TaskinfoMapper taskinfoMapper;

    @Autowired
    TaskMapper taskMapper;

    /**
     * 新增一条任务清单数据
     * @param taskinfo 任务信息实体类
     * @param pId 项目ID
     * @return
     */
    public Taskinfo addTaskinfo(Taskinfo taskinfo, int pId) {
        // 将项目ID插入项目清单中
        taskinfo.setpId(pId);
        try {
            taskinfoMapper.insert(taskinfo);
        } catch (Exception e) {
            _LOG.error("向数据库插入新的任务清单出错！");
            e.printStackTrace();
            return null;
        }
        // 返回任务清单
        return taskinfo;
    }

    /**
     * 删除一条任务清单数据
     * @param taskinfoId 根据ID来删除
     * @return
     */
    public int deleteTaskinfo(int taskinfoId) {
        // 将要删除的taskinfoid传入进来
        TaskExample taskExample = new TaskExample();
        taskExample.createCriteria().andTaskinfoIdEqualTo(taskinfoId);
        List<Task> taskList = taskMapper.selectByExample(taskExample);
        // 逐个删除任务
        for (int i = 0; i < taskList.size(); i++) {
            taskMapper.deleteByPrimaryKey(taskList.get(i).getTaskId());
        }
        int i = taskinfoMapper.deleteByPrimaryKey(taskinfoId);
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 更新任务清单
     *
     * @param taskinfo 任务信息实体类
     * @return
     */
    public Taskinfo updateTaskinfo(Taskinfo taskinfo) {
        try{
            taskinfoMapper.updateByPrimaryKeyWithBLOBs(taskinfo);
        }catch (Exception e){
            _LOG.error("更新任务清单出错");
            e.printStackTrace();
            return null;
        }
        return taskinfo;
    }

    /**
     * 查询任务清单信息--> 修改前进行查询
     *
     * @param taskinfo 任务信息实体类
     * @param i        根据什么来查询（0代表ID，1代表名称）
     * @return
     */
    public List<Taskinfo> selectTaskinfo(Taskinfo taskinfo, int i) {

        List<Taskinfo> taskinfoList = new ArrayList<Taskinfo>();
        // i=0时 根据任务清单ID进行查询
        if (i == 0) {
            Taskinfo taskinfo1 = taskinfoMapper.selectByPrimaryKey(taskinfo.getTaskinfoId());
            taskinfoList.add(taskinfo1);
            if (taskinfoList != null && taskinfoList.get(0).getTaskinfoName() != null) {
                return taskinfoList;
            }
        }
        return null;
    }

    /**
     * 遍历任务清单
     *
     * @return
     */
    public List<Taskinfo> QueryList() {

        TaskinfoExample taskinfoExample = new TaskinfoExample();
        taskinfoExample.setDistinct(false);
        List<Taskinfo> list = taskinfoMapper.selectByExample(taskinfoExample);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list;
    }
}
