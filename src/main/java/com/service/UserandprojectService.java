package com.service;

import com.pojo.Userandproject;

/**
 * Created by BF on 2017/9/6.
 * 对应 用户与项目表 的接口
 * [UserandprojectMapper]
 */
public interface UserandprojectService {

    /**
     * 新增一个用户与项目关系
     * @param userandproject 用户与项目实体类
     */
    void addUserandproject(Userandproject userandproject);

    /**
     * 删除一个关系
     * @param upId 根据ID来删除
     */
    void deleteUserandproject(int upId);
}
