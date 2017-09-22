package com.dao;

import com.pojo.Alldiscus;
import com.pojo.AlldiscusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlldiscusMapper {
    long countByExample(AlldiscusExample example);

    int deleteByExample(AlldiscusExample example);

    int deleteByPrimaryKey(Integer discusallId);

    int insert(Alldiscus record);

    int insertSelective(Alldiscus record);

    List<Alldiscus> selectByExample(AlldiscusExample example);

    int updateByExampleSelective(@Param("record") Alldiscus record, @Param("example") AlldiscusExample example);

    int updateByExample(@Param("record") Alldiscus record, @Param("example") AlldiscusExample example);
}