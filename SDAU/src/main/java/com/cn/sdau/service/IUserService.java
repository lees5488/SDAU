package com.cn.sdau.service;

import java.util.List;

import com.cn.sdau.basic.PageQueryResult;
import com.cn.sdau.basic.SimpleServiceResult;
import com.cn.sdau.pojo.User;

/**
 * 用户处理接口
 * 
 * @author lzxy1
 *
 */
public interface IUserService {
	
	public User getUserById(int userId);
	
	public PageQueryResult<User> selectBy(User user);
	
	/**
	 * 查询全部
	 * 
	 * @return
	 */
	public List<User> selectAll();
	
	public int selectAllCount();
	
	/**
	 * 根据条件删除
	 * 
	 * @return
	 */
	public SimpleServiceResult deleteByCondition(List<User> userList);
	
	/**
	 * 根据用户名查询用户
	 * 
	 * @param userName
	 * @return
	 */
	public User selectByUserName(String userName);

	/**
	 * 新增用户
	 * 
	 * @param param
	 * @param loginUserId
	 * @return
	 */
	public SimpleServiceResult insertUser(User param);
}