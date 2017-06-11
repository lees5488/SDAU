package com.cn.sdau.dao;

import com.cn.sdau.pojo.ModuleInfo;
import com.cn.sdau.pojo.ModuleInfoExample;
import com.cn.sdau.pojo.ModuleInfoKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModuleInfoMapper {
    int countByExample(ModuleInfoExample example);

    int deleteByExample(ModuleInfoExample example);

    int deleteByPrimaryKey(ModuleInfoKey key);

    int insert(ModuleInfo record);

    int insertSelective(ModuleInfo record);

    List<ModuleInfo> selectByExample(ModuleInfoExample example);

    ModuleInfo selectByPrimaryKey(ModuleInfoKey key);

    int updateByExampleSelective(@Param("record") ModuleInfo record, @Param("example") ModuleInfoExample example);

    int updateByExample(@Param("record") ModuleInfo record, @Param("example") ModuleInfoExample example);

    int updateByPrimaryKeySelective(ModuleInfo record);

    int updateByPrimaryKey(ModuleInfo record);
}