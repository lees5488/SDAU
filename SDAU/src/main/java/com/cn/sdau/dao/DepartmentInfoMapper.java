package com.cn.sdau.dao;

import com.cn.sdau.pojo.DepartmentInfo;
import com.cn.sdau.pojo.DepartmentInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartmentInfoMapper {
    int countByExample(DepartmentInfoExample example);

    int deleteByExample(DepartmentInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DepartmentInfo record);

    int insertSelective(DepartmentInfo record);

    List<DepartmentInfo> selectByExample(DepartmentInfoExample example);
    
    //根据查找
    List<DepartmentInfo> selectByInfo(DepartmentInfo record);
    
    int selectByInfoCount(DepartmentInfo record);

    DepartmentInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DepartmentInfo record, @Param("example") DepartmentInfoExample example);

    int updateByExample(@Param("record") DepartmentInfo record, @Param("example") DepartmentInfoExample example);

    int updateByPrimaryKeySelective(DepartmentInfo record);

    int updateByPrimaryKey(DepartmentInfo record);
}