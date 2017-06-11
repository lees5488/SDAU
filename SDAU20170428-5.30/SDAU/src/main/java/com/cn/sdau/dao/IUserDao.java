package com.cn.sdau.dao;

import java.util.List;

import com.cn.sdau.pojo.User;

/**
 * 用户列表操作
 * 
 * @author lzxy1
 *
 */
public interface IUserDao {
    /**
     * 根据Condition删除
     * 
     * @param id
     * @return
     */
	int deleteByCondition(User user);

    int insert(User record);

    int insertSelective(User record);

  //  PageQueryResult<User> selectAllCount();
    
    
    /**
     * 按条件分页查询用户
     * 
     * @param user
     * @param rowBounds
     * @return
     */
    List<User> selectBy(User user);
    
    /**
     * 按条件分页查询用户（计数）
     * 
     * @param user
     * @return
     */
    int selectByCount(User user);

    /**
     * 查询所有用户
     * 
     * @return
     */
    List<User> selectAll(User user);
    
    /**
     * 查询所有用户（计数）
     * 
     * @return
     */
    public int selectAllCount();
    
    /**
     * 根据关键字查询
     * 
     * @param id
     * @return
     */
    User selectByPrimaryKey(Integer id);
    
    /**
     * 根据用户名查询
     * 
     * @param userName
     * @return
     */
    User selectByUserName(String userName);
    
    /**
     * 根据条件修改
     * 
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    
    int updateByPrimaryKey(User record);
}