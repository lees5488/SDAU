package com.cn.sdau.dao;

import com.cn.sdau.pojo.SystemRegion;
import com.cn.sdau.pojo.SystemRegionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemRegionMapper {
    int countByExample(SystemRegionExample example);

    int deleteByExample(SystemRegionExample example);

    int deleteByPrimaryKey(Integer regionId);

    int insert(SystemRegion record);

    int insertSelective(SystemRegion record);

    List<SystemRegion> selectByExample(SystemRegionExample example);

    SystemRegion selectByPrimaryKey(Integer regionId);

    int updateByExampleSelective(@Param("record") SystemRegion record, @Param("example") SystemRegionExample example);

    int updateByExample(@Param("record") SystemRegion record, @Param("example") SystemRegionExample example);

    int updateByPrimaryKeySelective(SystemRegion record);

    int updateByPrimaryKey(SystemRegion record);
}