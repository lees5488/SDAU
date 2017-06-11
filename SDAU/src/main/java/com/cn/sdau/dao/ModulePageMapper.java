package com.cn.sdau.dao;

import com.cn.sdau.pojo.ModulePage;
import com.cn.sdau.pojo.ModulePageExample;
import com.cn.sdau.pojo.ModulePageKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModulePageMapper {
    int countByExample(ModulePageExample example);

    int deleteByExample(ModulePageExample example);

    int deleteByPrimaryKey(ModulePageKey key);

    int insert(ModulePage record);

    int insertSelective(ModulePage record);

    List<ModulePage> selectByExample(ModulePageExample example);

    ModulePage selectByPrimaryKey(ModulePageKey key);

    int updateByExampleSelective(@Param("record") ModulePage record, @Param("example") ModulePageExample example);

    int updateByExample(@Param("record") ModulePage record, @Param("example") ModulePageExample example);

    int updateByPrimaryKeySelective(ModulePage record);

    int updateByPrimaryKey(ModulePage record);
}