package com.cn.sdau.dao;

import com.cn.sdau.pojo.User;

/**
 * 用户列表操作
 * 
 * @author lzxy1
 *
 */
public interface UserMapperWriter {
    /**
     * 根据Condition删除
     * 
     * @param id
     * @return
     */
	int deleteByCondition(User user);

    int insert(User record);

    /**
     * 新增用户
     * 
     * @param record
     * @return
     */
    int insertSelective(User record);
    
    /**
     * 根据条件修改
     * 
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    
    int updateByPrimaryKey(User record);
}