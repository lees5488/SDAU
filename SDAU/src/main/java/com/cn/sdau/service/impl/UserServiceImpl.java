package com.cn.sdau.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.cn.sdau.basic.PageQueryResult;
import com.cn.sdau.dao.IUserDao;
import com.cn.sdau.pojo.User;
import com.cn.sdau.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	/**
	 * select by 
	 * @author admin
	 */
	@Resource
	private IUserDao userDao;
	public PageQueryResult<User> selectBy(User user) {
		PageQueryResult<User> result= new PageQueryResult<User>();
		int total = userDao.selectAllCount(user);
		RowBounds rowBounds = new RowBounds((user.getPage() - 1) * user.getRows(), user.getRows());
		List<User> list = userDao.selectBy(user, rowBounds);
		result.setTotal(total);
		result.setRows(list);
		return result;
	}
	
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userDao.selectByPrimaryKey(userId);
	}


}
