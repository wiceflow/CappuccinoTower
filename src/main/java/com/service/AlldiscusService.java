package com.service;

import com.pojo.Alldiscus;

/**
 * Created by WU on 2017/8/29.
 * 对应 讨论总表 的接口
 * [AlldiscusMapper]
 */
public interface AlldiscusService {

    /**
     * 添加一个新的讨论总表
     * @param alldiscus  总讨论表
     * @return   返回0代表失败，返回1代表成功
     */
    int addAlldiscus(Alldiscus alldiscus);

    /**
     * 删除一个讨论总表
     * @param  discusallId  根据总表Id进行删除
     * @return   返回0代表失败，返回1代表成功
     */
    int deleteAlldiscus(int discusallId);


    /**
     * 修改一个讨论总表
     * @param alldiscus 根据总表Id进行修改
     * @return 返回0代表失败，返回1代表成功
     */
    int updateAlldiscus(Alldiscus alldiscus);

    /**
     * 查询总表
     * @param alldiscus 讨论总表实体类
     * @param discusallId 根据Id 进行查找
     * @return
     */
    Alldiscus selectAlldiscus(Alldiscus alldiscus,int discusallId);
}
