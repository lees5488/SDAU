package com.cn.sdau.dao;

import com.cn.sdau.pojo.EventVerify;
import com.cn.sdau.pojo.EventVerifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventVerifyMapper {
    int countByExample(EventVerifyExample example);

    int deleteByExample(EventVerifyExample example);

    int deleteByPrimaryKey(String verifyNo);

    int insert(EventVerify record);

    int insertSelective(EventVerify record);

    List<EventVerify> selectByExample(EventVerifyExample example);

    EventVerify selectByPrimaryKey(String verifyNo);

    int updateByExampleSelective(@Param("record") EventVerify record, @Param("example") EventVerifyExample example);

    int updateByExample(@Param("record") EventVerify record, @Param("example") EventVerifyExample example);

    int updateByPrimaryKeySelective(EventVerify record);

    int updateByPrimaryKey(EventVerify record);
}