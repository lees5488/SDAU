package com.cn.sdau.dao;

import com.cn.sdau.pojo.EventFeedback;
import com.cn.sdau.pojo.EventFeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventFeedbackMapper {
    int countByExample(EventFeedbackExample example);

    int deleteByExample(EventFeedbackExample example);

    int deleteByPrimaryKey(String feedbackNo);

    int insert(EventFeedback record);

    int insertSelective(EventFeedback record);

    List<EventFeedback> selectByExample(EventFeedbackExample example);

    EventFeedback selectByPrimaryKey(String feedbackNo);

    int updateByExampleSelective(@Param("record") EventFeedback record, @Param("example") EventFeedbackExample example);

    int updateByExample(@Param("record") EventFeedback record, @Param("example") EventFeedbackExample example);

    int updateByPrimaryKeySelective(EventFeedback record);

    int updateByPrimaryKey(EventFeedback record);
}