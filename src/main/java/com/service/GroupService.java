package com.service;

import com.dto.TeamforJsp;
import com.pojo.Groupofteam;

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
    int addGroup(int[] uId,Groupofteam groupofteam);

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
    int updateGroup(Groupofteam group);

    /**
     * 查询分组
     * @param group 分组实体类
     * @param gId 根据ID进行查询
     * @return
     */
    List<Groupofteam> selectGroup(Groupofteam group,int gId);

    /**
     * 根据gId 返回一个DTO
     * @param gId
     * @return
     */
    public List<TeamforJsp> SelectUserByGid(int gId);
}
