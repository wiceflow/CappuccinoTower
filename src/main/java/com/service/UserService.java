package com.service;

import com.dto.TeamforJsp;
import com.pojo.Team;
import com.pojo.User;

import java.util.List;

/**
 * Created by BF on 2017/8/29.
 * 对应 用户表 的接口
 * [UserMapper]
 */
public interface UserService {

    /**
     * 增加一个新的用户
     * @param user 用户实体类
     * @return  返回0代表失败，返回1代表成功
     */
    int addUser(User user, Team team);

    /**
     * 删除一个用户
     * @param uId 根据ID来删除
     * @return  返回0代表失败，返回1代表成功
     */
    int deleteUser(int uId);

    /**
     * 更新一个用户
     * @param user 用户实体类
     * @return  返回0代表失败，返回1代表成功
     */
    int updateUser(User user);

    /**
     * 查找一个用户
     * @param user 用户实体类
     * @param i 根据什么来查找（0代表ID，1代表用户名，2代表邮箱）
     * @return  返回0代表失败，返回1代表成功
     */
    List<User> selectUser(User user, int i);

    /**
     * 模糊查询名字
     * @param uName
     * @return
     */
    List<User> listByUname(String uName);

    /**
     * 遍历整个User表
     * @return
     */
    List<User> QueryList(int tId);

    /**
     * 根据tId返回一个DTO类型
     * @param tId
     * @return
     */
    List<TeamforJsp> QueryByTid(int tId);
}
