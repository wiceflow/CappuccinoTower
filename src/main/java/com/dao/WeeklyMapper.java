package com.dao;

import com.pojo.Weekly;
import com.pojo.WeeklyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeeklyMapper {
    long countByExample(WeeklyExample example);

    int deleteByExample(WeeklyExample example);

    int deleteByPrimaryKey(Integer weeklyId);

    int insert(Weekly record);

    int insertSelective(Weekly record);

    List<Weekly> selectByExample(WeeklyExample example);

    Weekly selectByPrimaryKey(Integer weeklyId);

    int updateByExampleSelective(@Param("record") Weekly record, @Param("example") WeeklyExample example);

    int updateByExample(@Param("record") Weekly record, @Param("example") WeeklyExample example);

    int updateByPrimaryKeySelective(Weekly record);

    int updateByPrimaryKey(Weekly record);
}