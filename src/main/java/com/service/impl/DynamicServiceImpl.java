package com.service.impl;

import com.dao.DynamicMapper;
import com.pojo.Dynamic;
import com.service.DynamicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by BF on 2017/9/5.
 *
 */
@Service
public class DynamicServiceImpl implements DynamicService {
    // slf4j日志配置
    private static final Logger _LOG = LoggerFactory.getLogger(DynamicServiceImpl.class);

    // 注入DynamicMapper依赖 [对数据库Dynamic表进行操作的Dao层]
    @Autowired
    DynamicMapper dynamicMapper;
    /**
     * 新增一条动态信息
     * @param dynamic 动态表实体类
     * @return
     */
    public int addDynamic(Dynamic dynamic) {
        try{
            System.out.println(dynamic.toString());
            dynamicMapper.insert(dynamic);
            return 1;
        }catch (Exception e){
            System.out.println("输出异常");
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 删除一条动态信息
     * @param dynamicId 根据ID删除表
     * @return
     */
    public int deleteDynamic(int dynamicId) {
        return 0;
    }

    /**
     * 更新一条动态信息 <应该不会用到>
     * @param dynamic 动态表实体类
     * @return
     */
    public int updateDynamic(Dynamic dynamic) {
        return 0;
    }

    /**
     * 查询动态信息  [对应的项目]
     * @param dynamic 动态表实体类
     * @param pId 根据项目id查询
     * @return
     */
    public List<Dynamic> selectDynamic(Dynamic dynamic, int pId) {
        return null;
    }
}
