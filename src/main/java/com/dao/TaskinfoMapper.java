package com.dao;

import com.pojo.Taskinfo;
import com.pojo.TaskinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskinfoMapper {
    long countByExample(TaskinfoExample example);

    int deleteByExample(TaskinfoExample example);

    int deleteByPrimaryKey(Integer taskinfoId);

    int insert(Taskinfo record);

    int insertSelective(Taskinfo record);

    List<Taskinfo> selectByExampleWithBLOBs(TaskinfoExample example);

    List<Taskinfo> selectByExample(TaskinfoExample example);

    Taskinfo selectByPrimaryKey(Integer taskinfoId);

    int updateByExampleSelective(@Param("record") Taskinfo record, @Param("example") TaskinfoExample example);

    int updateByExampleWithBLOBs(@Param("record") Taskinfo record, @Param("example") TaskinfoExample example);

    int updateByExample(@Param("record") Taskinfo record, @Param("example") TaskinfoExample example);

    int updateByPrimaryKeySelective(Taskinfo record);

    int updateByPrimaryKeyWithBLOBs(Taskinfo record);

    int updateByPrimaryKey(Taskinfo record);
}