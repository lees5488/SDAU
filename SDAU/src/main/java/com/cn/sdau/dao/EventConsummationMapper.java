package com.cn.sdau.dao;

import com.cn.sdau.pojo.EventConsummation;
import com.cn.sdau.pojo.EventConsummationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventConsummationMapper {
    int countByExample(EventConsummationExample example);

    int deleteByExample(EventConsummationExample example);

    int deleteByPrimaryKey(String consummationNo);

    int insert(EventConsummation record);

    int insertSelective(EventConsummation record);

    List<EventConsummation> selectByExample(EventConsummationExample example);

    EventConsummation selectByPrimaryKey(String consummationNo);

    int updateByExampleSelective(@Param("record") EventConsummation record, @Param("example") EventConsummationExample example);

    int updateByExample(@Param("record") EventConsummation record, @Param("example") EventConsummationExample example);

    int updateByPrimaryKeySelective(EventConsummation record);

    int updateByPrimaryKey(EventConsummation record);
}