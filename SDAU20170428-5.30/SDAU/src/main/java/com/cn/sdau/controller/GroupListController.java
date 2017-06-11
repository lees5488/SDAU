package com.cn.sdau.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cn.sdau.basic.JsonResult;
import com.cn.sdau.basic.PageQueryResult;
import com.cn.sdau.pojo.User;
import com.cn.sdau.service.IUserService;
/**
 * 权限组一览Controller
 * @author 
 *
 */
@Controller
@RequestMapping("system")
public class GroupListController  {
	
	@Resource
	private IUserService userService;
	
	@RequestMapping("userlist")
	public ModelAndView index(ModelAndView mav,HttpServletRequest request){
		mav.setViewName("system/userList");
		return mav;
	}
	
	
	
	/**
	 * 分页查询
	 * 
	 * @param param 条件vo
	 * @return 查询结果
	 */
	@RequestMapping("query")
	@ResponseBody
	public PageQueryResult<User> query(User params,HttpServletRequest request){
		PageQueryResult<User> grouplist = new PageQueryResult<User>();
		return grouplist;
	}
	
	
	/**
	 * 删除权限组
	 * 
	 * @param param 删除条件List<vo> 包含id updateDate
	 * @param request 
	 * @return 操作结果
	 */
	@RequestMapping("delete")
	@ResponseBody
	public JsonResult delete(@RequestBody Object param, HttpServletRequest request) {
		// 复杂的List对象需要使用共同的转换方法
		
		JsonResult json = new JsonResult();
		return json;
	}
	
	/**
	 * 恢复权限组
	 * 
	 * @param param 恢复条件List<vo> 包含id updateDate
	 * @param request 
	 * @return 操作结果
	 */
	@RequestMapping("recover")
	@ResponseBody
	public JsonResult recover(@RequestBody Object param, HttpServletRequest request) {	
		JsonResult json = new JsonResult();
		return json;
	}
	
}
