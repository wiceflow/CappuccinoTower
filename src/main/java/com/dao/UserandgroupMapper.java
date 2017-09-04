package com.dao;

import com.pojo.Userandgroup;
import com.pojo.UserandgroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserandgroupMapper {
    long countByExample(UserandgroupExample example);

    int deleteByExample(UserandgroupExample example);

    int deleteByPrimaryKey(Integer ugId);

    int insert(Userandgroup record);

    int insertSelective(Userandgroup record);

    List<Userandgroup> selectByExample(UserandgroupExample example);

    Userandgroup selectByPrimaryKey(Integer ugId);

    int updateByExampleSelective(@Param("record") Userandgroup record, @Param("example") UserandgroupExample example);

    int updateByExample(@Param("record") Userandgroup record, @Param("example") UserandgroupExample example);

    int updateByPrimaryKeySelective(Userandgroup record);

    int updateByPrimaryKey(Userandgroup record);
}