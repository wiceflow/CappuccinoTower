package com.service.impl;

import com.dao.UserandprojectMapper;
import com.pojo.Userandproject;
import com.service.UserandprojectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by BF on 2017/9/6.
 * [UserandprojectService] 实现类
 */
@Service
public class UserandprojectServiceImpl implements UserandprojectService{

    // slf4j日志配置
    private static final Logger _LOG = LoggerFactory.getLogger(UserandprojectServiceImpl.class);

    // 注入UserandprojectMapper依赖 [对数据库Userandproject表进行操作的Dao层]
    @Autowired
    private UserandprojectMapper userandprojectMapper;

    /**
     * 新增一个用户与项目关系
     * @param userandproject 用户与项目实体类
     */
    public void addUserandproject(Userandproject userandproject) {
        try {
            userandprojectMapper.insert(userandproject);
        }catch (Exception e){
            _LOG.error("向用户与项目表中插入数据出错！");
        }

    }

    /**
     * 删除一个关系
     * @param upId 根据ID来删除
     */
    public void deleteUserandproject(int upId) {

    }
}
