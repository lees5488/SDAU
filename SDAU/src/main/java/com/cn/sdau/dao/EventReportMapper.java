package com.cn.sdau.dao;

import com.cn.sdau.pojo.EventReport;
import com.cn.sdau.pojo.EventReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventReportMapper {
    int countByExample(EventReportExample example);

    int deleteByExample(EventReportExample example);

    int deleteByPrimaryKey(String eventNo);

    int insert(EventReport record);

    int insertSelective(EventReport record);

    List<EventReport> selectByExample(EventReportExample example);

    EventReport selectByPrimaryKey(String eventNo);

    int updateByExampleSelective(@Param("record") EventReport record, @Param("example") EventReportExample example);

    int updateByExample(@Param("record") EventReport record, @Param("example") EventReportExample example);

    int updateByPrimaryKeySelective(EventReport record);

    int updateByPrimaryKey(EventReport record);
}