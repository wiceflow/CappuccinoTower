package com.dao;

import com.pojo.Discus;
import com.pojo.DiscusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DiscusMapper {
    long countByExample(DiscusExample example);

    int deleteByExample(DiscusExample example);

    int deleteByPrimaryKey(Integer discusId);

    int insert(Discus record);

    int insertSelective(Discus record);

    List<Discus> selectByExampleWithBLOBs(DiscusExample example);

    List<Discus> selectByExample(DiscusExample example);

    Discus selectByPrimaryKey(Integer discusId);

    int updateByExampleSelective(@Param("record") Discus record, @Param("example") DiscusExample example);

    int updateByExampleWithBLOBs(@Param("record") Discus record, @Param("example") DiscusExample example);

    int updateByExample(@Param("record") Discus record, @Param("example") DiscusExample example);

    int updateByPrimaryKeySelective(Discus record);

    int updateByPrimaryKeyWithBLOBs(Discus record);

    int updateByPrimaryKey(Discus record);
}