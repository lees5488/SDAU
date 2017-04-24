package com.cn.sdau.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.cn.sdau.pojo.User;

public interface IUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

  //  PageQueryResult<User> selectAllCount();
    
    public int selectAllCount(User user);
    
    List<User> selectBy(User user,RowBounds rowBounds);
    
    User selectByPrimaryKey(Integer id);
    

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}