package com.service;

import com.pojo.Discus;
import com.pojo.Project;

import java.util.List;

/**
 * Created by WU on 2017/8/29.
 * 对应 讨论表 的接口
 * [DiscusMapper]
 */
public interface DiscusService {


    /**
     * 创建一个讨论表
     * @param discus 讨论表实体类
     * @return 返回0表示失败，返回1表示成功
     */
    Discus addDiscus(Discus discus, Project project);


    /**
     * 删除一个讨论表
     * @param discusId  根据Id进行删除
     * @return 返回0表示失败，返回1表示成功
     */
    int deleteDiscus(int discusId);

    /**
     * 修改一个讨论表
     * @param discus  讨论表实体类
     * @return 返回0表示失败，返回1表示成功
     */
    int updateDiscus(Discus discus);

    /**
     * 查找一个Id
     * @param discus  讨论表实体类
     * @param discusId  根据id查找
     * @return
     */
    List<Discus> select(Discus discus, int discusId);

    /**
     *根据项目id 遍历出该id所有的讨论
     * @param pId
     * @return
     */
    public List<Discus> QueryDiscus(int pId);
}
