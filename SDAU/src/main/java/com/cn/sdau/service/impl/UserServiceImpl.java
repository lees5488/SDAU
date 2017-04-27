package com.cn.sdau.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.sdau.basic.PageQueryResult;
import com.cn.sdau.basic.SimpleServiceResult;
import com.cn.sdau.dao.IUserDao;
import com.cn.sdau.dao.UserMapperWriter;
import com.cn.sdau.pojo.User;
import com.cn.sdau.service.IUserService;

/**
 * 用户处理
 * 
 * @author lzxy1
 *
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao userDao;
	@Resource
	private UserMapperWriter userMapperWriter;

	/**
	 * 按条件查询用户
	 * 
	 */
	public PageQueryResult<User> selectBy(User user) {
		PageQueryResult<User> result = new PageQueryResult<User>();
		int total = userDao.selectByCount(user);
		user.setOffset((user.getPage() - 1) * user.getRows());
		user.setLimit(user.getRows());
		List<User> list = userDao.selectBy(user);
		result.setTotal(total);
		result.setRows(list);
		return result;
	}

	/**
	 * 根据用户编号查询用户
	 * 
	 */
	public User getUserById(int userId) {
		return this.userDao.selectByPrimaryKey(userId);
	}
	
	/**
	 * 根据用户名查询用户
	 * 
	 * @param userName
	 * @return
	 */
	public User selectByUserName(String userName){
		return this.userDao.selectByUserName(userName);
	}

	public List<User> selectAll() {
		User user = new User();
		return userDao.selectAll(user);
	}

	public int selectAllCount() {
		return userDao.selectAllCount();
	}

	/**
	 * 按条件删除用户
	 * 
	 */
	public SimpleServiceResult deleteByCondition(List<User> userList) {
		for (User user : userList) {
			int returnValue = userMapperWriter.deleteByCondition(user);
			if (1 != returnValue) {
				return new SimpleServiceResult("异常", "数据");
			}
		}
		return SimpleServiceResult.OK;
	}

	/**
	 * 按条件新增用户
	 * 
	 */
	@Override
	public SimpleServiceResult insertUser(User param) {
		int returnValue = userMapperWriter.insertSelective(param);
		if (1 != returnValue) {
			return new SimpleServiceResult("异常", "数据");
		}
		return SimpleServiceResult.OK;
	}

}
