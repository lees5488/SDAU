package com.cn.sdau.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.sdau.basic.JsonResult;
import com.cn.sdau.basic.PageQueryResult;
import com.cn.sdau.basic.SimpleServiceResult;
import com.cn.sdau.pojo.User;
import com.cn.sdau.service.IUserService;

/**
 * 系统设置
 * 
 * @author lzxy1
 *
 */
@Controller
@RequestMapping("/system")
public class UserListController extends BaseController {
	@Resource
	private IUserService userService;

	/**
	 * 用户列表首页
	 * 
	 * @param request
	 * @param mav
	 * @return
	 */
	@RequestMapping("/userList")
	public ModelAndView toIndex(HttpServletRequest request, ModelAndView mav) {
		mav.setViewName("system/userList");
		return mav;
	}

	/**
	 * 查询用户
	 * 
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping("/userListQuery")
	@ResponseBody
	public PageQueryResult<User> query(HttpServletRequest request, User user) {
		logger.info("---查询用户请求信息:" + JSON.toJSONString(user));
		// List<User> userList = this.userService.selectAll();
		PageQueryResult<User> userResult = this.userService.selectBy(user);
		// int count = userService.selectAllCount();
		// PageQueryResult<User> userResult = new PageQueryResult<User>();
		// userResult.setTotal(count);
		// userResult.setRows(userList);
		logger.info("---查询用户请求结果:" + JSON.toJSONString(userResult));
		return userResult;
	}

	/**
	 * 删除用户
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping("/userListDelete")
	@ResponseBody
	public JsonResult deleteOrder(@RequestBody Object param, HttpServletRequest request) {
		List<User> userList = this.getAjaxReqParam(param, new TypeReference<List<User>>() {
		});
		JsonResult result = new JsonResult();
		try {
			userService.deleteByCondition(userList);
			result.setOk(true);
		} catch (Exception e) {
			result.setMessage(e.getMessage());
			result.setOk(false);
		}
		return result;
	}

	@RequestMapping("insertAcceptInfo")
	@ResponseBody
	public JsonResult insertAcceptInfo(@RequestBody User param, HttpServletRequest request) {
		param.setCreateUser(this.getLoginUserId(request));
		param.setUpdateUser(this.getLoginUserId(request));
		SimpleServiceResult result = userService.insertUser(param);
		return null;
	}

	/**
	 * 用户详情首页
	 * 
	 * @param request
	 * @param mav
	 * @return
	 */
	@RequestMapping("/userDetail")
	public ModelAndView showUserDetail(@RequestParam(value = "userName", required = false) String userName,
			HttpServletRequest request, ModelAndView mav) {
		User user = new User();
		// 修改用户
		if (null != userName) {
			user = userService.selectByUserName(userName);
		}
		mav.addObject("user", user);
		mav.setViewName("system/userDetail");
		return mav;
	}

}
