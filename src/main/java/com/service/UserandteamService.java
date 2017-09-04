package com.service;

import com.pojo.Userandteam;

import java.util.List;

/**
 * Created by chen on 2017/8/29.
 */
public interface UserandteamService {

    /**
     * 增加一个用户和团队
     * @param userandteam 用户和团队实体类
     * @return 返回0代表失败，1代表成功
     */
    int addUserandteam(Userandteam userandteam);

    /**
     * 删除一个用户和团队
     * @param utId 根据ID删除
     * @return 返回0代表失败，1代表成功
     */
    int deleteUserandteam(int utId);

    /**
     * 更新一个用户和团队
     * @param userandteam 用户和团队实体类
     * @return 返回0代表失败，1代表成功
     */
    int updateUserandteam(Userandteam userandteam);

    /**
     * 查询一个用户和团队
     * @param userandteam 用户和团队实体类
     * @param i 根据什么来查询（0代表ID，1代表名称）
     * @return 返回0代表失败，1代表成功
     */
    List<Userandteam> selectUserandteam(Userandteam userandteam,int i);
}
