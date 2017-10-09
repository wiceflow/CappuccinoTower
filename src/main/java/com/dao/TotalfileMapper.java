package com.dao;

import com.pojo.Totalfile;
import com.pojo.TotalfileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TotalfileMapper {
    long countByExample(TotalfileExample example);

    int deleteByExample(TotalfileExample example);

    int deleteByPrimaryKey(Integer totalfileId);

    int insert(Totalfile record);

    int insertSelective(Totalfile record);

    List<Totalfile> selectByExample(TotalfileExample example);

    int updateByExampleSelective(@Param("record") Totalfile record, @Param("example") TotalfileExample example);

    int updateByExample(@Param("record") Totalfile record, @Param("example") TotalfileExample example);
}