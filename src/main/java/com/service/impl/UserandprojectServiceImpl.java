package com.service.impl;

import com.dao.UserMapper;
import com.dao.UserandprojectMapper;
import com.pojo.Project;
import com.pojo.User;
import com.pojo.Userandproject;
import com.pojo.UserandprojectExample;
import com.service.UserandprojectService;
import com.util.ObtainSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

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
    // 注入userMapper依赖 [对数据库userMapper表进行操作的Dao层]
    @Autowired
    private UserMapper userMapper;

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
    /**
     * 查询当前项目所有参与者
     */
    public List<User> QueryAl(int pId) {
        // 用户数组
        List<User> users = new ArrayList<User>();
        int uId = 0;

        // 查userandproject表中的联袂关系
        UserandprojectExample uuu = new UserandprojectExample();
        uuu.createCriteria().andPIdEqualTo(pId);
        List<Userandproject> userp = userandprojectMapper.selectByExample(uuu);
        // 如果不为空
        if (userp!=null&&userp.size()!=0){
            // 循环取出user
            for (Userandproject u1:userp){
                uId = u1.getuId();
                User u2 = userMapper.selectByPrimaryKey(uId);
                if (u2!=null){
                    users.add(u2);
                }
            }
        }
        if (users!=null){
            return users;
        }
        return null;
    }
}
