package com.service;

import com.dto.General;
import com.pojo.Dynamic;
import com.pojo.Group;
import com.pojo.User;

import java.util.List;

/**
 * Created by WU on 2017/8/29.
 * 对应 动态表 接口
 * [DynamicMapper]
 */
public interface DynamicService {

    /**
     * 创建一个动态表
     * @param dynamic 动态表实体类
     * @param action 定义操作动作
     * @return 返回0表示失败，返回1表示成功
     */
    int addDynamic(Dynamic dynamic);


    /**
     * 删除一个动态表
     * @param dynamicId 根据ID删除表
     * @return 返回0表示失败，返回1表示成功
     */
    int deleteDynamic(int dynamicId);


    /**
     * 修改一个动态表
     * @param dynamic 动态表实体类
     * @return 返回0表示失败，返回1表示成功
     */
    int updateDynamic(Dynamic dynamic);


    /**
     * 查询一个动态表
     * @param dynamic 动态表实体类
     * @param pId 根据项目id查询
     * @return
     */
    List<General> selectDynamic(Dynamic dynamic, int pId);

    List<General> QueryList(Dynamic dynamic);


}
