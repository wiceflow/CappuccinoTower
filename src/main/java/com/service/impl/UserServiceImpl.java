package com.service.impl;

import com.dao.UserMapper;
import com.pojo.Team;
import com.pojo.User;
import com.pojo.UserExample;
import com.service.TeamService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BF on 2017/8/29.
 * 对应用户表的Service实现类
 * [UserMapper] [UserService]
 */
@Service
public class UserServiceImpl implements UserService {

    //注入UserMapper依赖 [对数据库进行操作的Dao层]
    @Autowired
    UserMapper userMapper;

    @Autowired
    TeamService teamService;

    public int addUser(User user, Team team) {
        List<User> userList = null;
        String uName = user.getuName();
        //创建Example对象，使用createCtiteria方法以uName查询数据库
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUNameEqualTo(uName);
        //userList接受查询结果
        userList = userMapper.selectByExample(userExample);
        //若结果为空或者长度为0
        if (userList == null || userList.size() == 0) {
            //添加用户
            userMapper.insert(user);
            //是否存在小组默认为否
            team.setIsgroup(0);
            //将团队名加入
            teamService.addTeam(team);
            return 1;
        } else {
            return 0;
        }

    }

    public int addUser(User user) {
        List<User> userList = null;
        String uName = user.getuName();
        //创建Example对象，使用createCtiteria方法以uName查询数据库
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUEmailEqualTo(uName);
        //userList接受查询结果
        userList = userMapper.selectByExample(userExample);
        if (userList == null || userList.size() == 0) {
            //添加用户
            userMapper.insert(user);
            return 1;
        }
        return 0;
    }

    public int deleteUser(int uId) {
        userMapper.deleteByPrimaryKey(uId);
        return 0;
    }

    public int updateUser(User user) {
        userMapper.updateByPrimaryKey(user);
        return 1;
    }

    /**
     * 查找与选择 [User]
     *
     * @param user 用户实体类
     * @param i    根据什么来查找（0代表ID，1代表用户名，2代表邮箱）
     * @return 若查询为空则判断返回空，查询不为空则返回
     */
    public List<User> selectUser(User user, int i) {
        List<User> userList = new ArrayList<User>();
        User user1 = null;
        //用ID主键进行查询
        if (i == 0) {
            user1 = userMapper.selectByPrimaryKey(user.getuId());
            userList.add(user1);
        }
        //用用户名查询
        else if (i == 1) {
            String uName = user.getuName();
            UserExample userExample = new UserExample();
            userExample.createCriteria().andUNameEqualTo(uName);
            userList = userMapper.selectByExample(userExample);
        }
        //用用户邮箱查询
        else if (i == 2) {
            String uEmail = user.getuEmail();
            UserExample userExample = new UserExample();
            userExample.createCriteria().andUEmailEqualTo(uEmail);
            userList = userMapper.selectByExample(userExample);
        }
        //若查询为空则返回null
        if (userList == null || userList.size() == 0) {
            return null;
        }
        //否则返回这个list
        else {
            return userList;
        }
    }

    /**
     * 对uName进行模糊查询
     *
     * @param uName
     * @return
     */
    public List<User> listByUname(String uName) {
        List<User> listByUname = null;
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        //拼接SQL语句
        if (StringUtils.hasText(uName)) {
            uName = "%" + uName + "%";
        }
        if (StringUtils.hasText(uName)) {
            criteria.andUNameLike(uName);
        }
        //select u_id, u_email, u_password, u_picture, u_name from user WHERE u_name like '%小%';
        //将按照uName查找到的List 返回
        listByUname = userMapper.selectByExample(userExample);
        return listByUname;
    }

    /**
     * 遍历整个User表   稍后删掉
     * @return
     */
    public List<User> QueryList(){
        List<User> list=null;
        UserExample userExample=new UserExample();
        userExample.setDistinct(true);
        list=userMapper.selectByExample(userExample);
        return list;
    }
}
