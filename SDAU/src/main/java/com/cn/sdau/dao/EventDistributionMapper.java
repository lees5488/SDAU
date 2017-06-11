package com.cn.sdau.dao;

import com.cn.sdau.pojo.EventDistribution;
import com.cn.sdau.pojo.EventDistributionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventDistributionMapper {
    int countByExample(EventDistributionExample example);

    int deleteByExample(EventDistributionExample example);

    int deleteByPrimaryKey(String distributionNo);

    int insert(EventDistribution record);

    int insertSelective(EventDistribution record);

    List<EventDistribution> selectByExample(EventDistributionExample example);

    EventDistribution selectByPrimaryKey(String distributionNo);

    int updateByExampleSelective(@Param("record") EventDistribution record, @Param("example") EventDistributionExample example);

    int updateByExample(@Param("record") EventDistribution record, @Param("example") EventDistributionExample example);

    int updateByPrimaryKeySelective(EventDistribution record);

    int updateByPrimaryKey(EventDistribution record);
}