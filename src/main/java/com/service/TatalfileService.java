package com.service;

import com.dto.TotalfileforJsp;
import com.pojo.Totalfile;

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
    int addTatalfile(Totalfile tatalfile);

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
    int updateTatalfile(Totalfile tatalfile);

    /**
     * 查询一个文件总表
     * @param tatalfile 文件总表实体类
     * @param i 根据什么来查询（0代表ID，1代表名称）
     * @return 返回0代表失败，1代表成功
     */
    List<Totalfile> selectTatalfile(Totalfile tatalfile,int i);

    /**
     * 根据项目id遍历根目录下面的文件和文件夹
     * @param pId
     * @return
     */
    List<TotalfileforJsp> QueryByPid(int pId);
}
