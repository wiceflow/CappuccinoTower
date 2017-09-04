package com.dao;

import com.pojo.Userandteam;
import com.pojo.UserandteamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserandteamMapper {
    long countByExample(UserandteamExample example);

    int deleteByExample(UserandteamExample example);

    int deleteByPrimaryKey(Integer utId);

    int insert(Userandteam record);

    int insertSelective(Userandteam record);

    List<Userandteam> selectByExample(UserandteamExample example);

    Userandteam selectByPrimaryKey(Integer utId);

    int updateByExampleSelective(@Param("record") Userandteam record, @Param("example") UserandteamExample example);

    int updateByExample(@Param("record") Userandteam record, @Param("example") UserandteamExample example);

    int updateByPrimaryKeySelective(Userandteam record);

    int updateByPrimaryKey(Userandteam record);
}