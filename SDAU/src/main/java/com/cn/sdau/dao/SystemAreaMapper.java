package com.cn.sdau.dao;

import com.cn.sdau.pojo.SystemArea;
import com.cn.sdau.pojo.SystemAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemAreaMapper {
    int countByExample(SystemAreaExample example);

    int deleteByExample(SystemAreaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemArea record);

    int insertSelective(SystemArea record);

    List<SystemArea> selectByExample(SystemAreaExample example);

    SystemArea selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemArea record, @Param("example") SystemAreaExample example);

    int updateByExample(@Param("record") SystemArea record, @Param("example") SystemAreaExample example);

    int updateByPrimaryKeySelective(SystemArea record);

    int updateByPrimaryKey(SystemArea record);
}