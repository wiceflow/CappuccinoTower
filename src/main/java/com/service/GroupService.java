package com.service;

import com.pojo.Group;

import java.util.List;

/**
 * Created by WU on 2017/8/29.
 * 对应 Group 接口
 * [GroupMapper]
 */
public interface GroupService {

    /**
     * 新增一个分组
     * @param group 分组实体类
     * @return 返回0表示失败，返回1表示成功
     */
    int addGroup(Group group);

    /**
     * 删除一个分组
     * @param gId 根据id进行删除
     * @return 返回0表示失败，返回1表示成功
     */
    int deleteGroup(int gId);

    /**
     * 修改一个分组
     * @param group 分组实体类
     * @return 返回0表示失败，返回1表示成功
     */
    int updateGroup(Group group);

    /**
     * 查询分组
     * @param group 分组实体类
     * @param gId 根据ID进行查询
     * @return
     */
    List<Group> selectGroup(Group group,int gId);
}
