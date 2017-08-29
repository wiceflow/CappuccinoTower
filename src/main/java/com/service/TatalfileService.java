package com.service;

import com.pojo.Tatalfile;

import java.util.List;

/**
 * Created by chen on 2017/8/29.
 */
public interface TatalfileService {

    /**
     * 增加一个文件总表
     * @param tatalfile 文件总表实体类
     * @return 返回0代表失败，1代表成功
     */
    int addTatalfile(Tatalfile tatalfile);

    /**
     * 删除一个文件总表
     * @param totalfileId 根据ID来删除
     * @return 返回0代表失败，1代表成功
     */
    int deleteTatalfile(int totalfileId);

    /**
     * 更新一个文件总表
     * @param tatalfile 文件总表实体类
     * @return 返回0代表失败，1代表成功
     */
    int updateTatalfile(Tatalfile tatalfile);

    /**
     * 查询一个文件总表
     * @param tatalfile 文件总表实体类
     * @param i 根据什么来查询（0代表ID，1代表名称）
     * @return 返回0代表失败，1代表成功
     */
    List<Tatalfile> selectTatalfile(Tatalfile tatalfile,int i);
}
