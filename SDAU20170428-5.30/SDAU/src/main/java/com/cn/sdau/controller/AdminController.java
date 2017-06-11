package com.cn.sdau.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.sdau.basic.PageQueryResult;
import com.cn.sdau.pojo.User;
import com.cn.sdau.service.IUserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource
	private IUserService userService;
	
	//@RequestMapping("/showUser")
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request,Model model){
		int userId = 1;
		if(null != request.getParameter("id")){
			userId = Integer.parseInt(request.getParameter("id"));
		}
		List<User> user = this.userService.selectAll( );
		model.addAttribute("user", user);
		//mav.addObject("user", user);
		//ModelAndView mav =  new ModelAndView();
		//mav.setViewName("user/showUser");
		return "admin/showUser";
		//return mav;
	}

	/**
	 * 首页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/addUser")
	public String addUser(HttpServletRequest request,Model model){
		List<User> user = this.userService.selectAll( );
		model.addAttribute("user", user);
		return "admin/addUser";
	}
	
	@RequestMapping("/query")
	@ResponseBody
	public PageQueryResult<User> query(User user ,HttpServletRequest request){
		//Integer warehouseId = this.getLoginUser(request).getWarehouseId();
		//dvo.setWarehouseId(warehouseId);
		//PageQueryResult<DispatchInfoListVo> result = dispatchListService.queryDispatch(user);
		PageQueryResult<User> result = new PageQueryResult<User>();
		return result;
	}
	

}
