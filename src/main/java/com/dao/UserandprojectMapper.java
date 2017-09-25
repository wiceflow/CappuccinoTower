package com.dao;

import com.pojo.Userandproject;
import com.pojo.UserandprojectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserandprojectMapper {
    long countByExample(UserandprojectExample example);

    int deleteByExample(UserandprojectExample example);

    int deleteByPrimaryKey(Integer upId);

    int insert(Userandproject record);

    int insertSelective(Userandproject record);

    List<Userandproject> selectByExample(UserandprojectExample example);

    Userandproject selectByPrimaryKey(Integer upId);

    int updateByExampleSelective(@Param("record") Userandproject record, @Param("example") UserandprojectExample example);

    int updateByExample(@Param("record") Userandproject record, @Param("example") UserandprojectExample example);

    int updateByPrimaryKeySelective(Userandproject record);

    int updateByPrimaryKey(Userandproject record);
}