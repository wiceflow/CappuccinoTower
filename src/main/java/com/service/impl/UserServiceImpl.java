package com.service.impl;

import com.dao.UserMapper;
import com.pojo.User;
import com.pojo.UserExample;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



    public int addUser(User user) {
        return 0;
    }

    public int deleteUser(int uId) {
        return 0;
    }

    public int updateUser(User user) {
        return 0;
    }

    public List<User> selectUser(User user, int i) {
        System.out.println("进来数据连接层");
        List<User> userList = null;
        User user1 = null;
        if (i==0)
        {
             user1 = userMapper.selectByPrimaryKey(i);
             userList.add(user1);
        }
        else if (i==1)
        {
            String uName = user.getUName();
            System.out.println(uName+"11");
            UserExample userExample = new UserExample();
            userExample.createCriteria().andUNameEqualTo(uName);
            userList = userMapper.selectByExample(userExample);
        }
        else if (i==2)
        {
            String uEmail = user.getUEmail();
            UserExample userExample = new UserExample();
            userExample.createCriteria().andUEmailEqualTo(uEmail);
            userList = userMapper.selectByExample(userExample);
        }

        if (userList==null||userList.size()==0)
        {
            return null;
        }
        else {
            return userList;
        }
    }
}
