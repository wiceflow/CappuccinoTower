package com.dao;

import com.pojo.Tatalfile;
import com.pojo.TatalfileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TatalfileMapper {
    long countByExample(TatalfileExample example);

    int deleteByExample(TatalfileExample example);

    int deleteByPrimaryKey(Integer totalfileId);

    int insert(Tatalfile record);

    int insertSelective(Tatalfile record);

    List<Tatalfile> selectByExample(TatalfileExample example);

    Tatalfile selectByPrimaryKey(Integer totalfileId);

    int updateByExampleSelective(@Param("record") Tatalfile record, @Param("example") TatalfileExample example);

    int updateByExample(@Param("record") Tatalfile record, @Param("example") TatalfileExample example);

    int updateByPrimaryKeySelective(Tatalfile record);

    int updateByPrimaryKey(Tatalfile record);
}