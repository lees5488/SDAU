package com.cn.sdau.dao;

import com.cn.sdau.pojo.PageInfo;
import com.cn.sdau.pojo.PageInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PageInfoMapper {
    int countByExample(PageInfoExample example);

    int deleteByExample(PageInfoExample example);

    int deleteByPrimaryKey(String pageNo);

    int insert(PageInfo record);

    int insertSelective(PageInfo record);

    List<PageInfo> selectByExample(PageInfoExample example);

    PageInfo selectByPrimaryKey(String pageNo);

    int updateByExampleSelective(@Param("record") PageInfo record, @Param("example") PageInfoExample example);

    int updateByExample(@Param("record") PageInfo record, @Param("example") PageInfoExample example);

    int updateByPrimaryKeySelective(PageInfo record);

    int updateByPrimaryKey(PageInfo record);
}