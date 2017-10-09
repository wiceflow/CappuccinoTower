package com.dao;

import com.pojo.Groupofteam;
import com.pojo.GroupofteamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupofteamMapper {
    long countByExample(GroupofteamExample example);

    int deleteByExample(GroupofteamExample example);

    int deleteByPrimaryKey(Integer gId);

    int insert(Groupofteam record);

    int insertSelective(Groupofteam record);

    List<Groupofteam> selectByExample(GroupofteamExample example);

    Groupofteam selectByPrimaryKey(Integer gId);

    int updateByExampleSelective(@Param("record") Groupofteam record, @Param("example") GroupofteamExample example);

    int updateByExample(@Param("record") Groupofteam record, @Param("example") GroupofteamExample example);

    int updateByPrimaryKeySelective(Groupofteam record);

    int updateByPrimaryKey(Groupofteam record);
}