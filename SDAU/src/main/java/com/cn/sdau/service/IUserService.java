package com.cn.sdau.service;

import com.cn.sdau.basic.PageQueryResult;
import com.cn.sdau.pojo.User;

public interface IUserService {
	public User getUserById(int userId);
	
	public PageQueryResult<User> selectBy(User user);
	
}