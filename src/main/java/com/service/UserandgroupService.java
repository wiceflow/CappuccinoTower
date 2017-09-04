package com.service;

import com.pojo.Userandgroup;

import java.util.List;

/**
 * Created by chen on 2017/8/29.
 */
public interface UserandgroupService {

    /**
     * 增加一个用户和分组
     * @param userandgroup 用户和分组实体类
     * @return 返回0代表失败，1代表成功
     */
    int addUserandgroup(Userandgroup userandgroup);

    /**
     * 删除一个用户和分组
     * @param ugId 根据ID来删除
     * @return 返回0代表失败，1代表成功
     */
    int deleteUserandgroup(int ugId);

    /**
     * 更新一个用户和分组
     * @param userandgroup 用户和分组实体类
     * @return 返回0
     */
    int updateUserandgroup(Userandgroup userandgroup);

    /**
     * 查询一个用户和分组
     * @param ugId 根据ID来查询
     * @return 返回0代表失败，1代表成功
     */
    List<Userandgroup> selectUserandgroup(int ugId);
}
