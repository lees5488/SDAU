package com.cn.sdau.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cn.sdau.basic.PageQueryResult;
import com.cn.sdau.pojo.User;
import com.cn.sdau.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;
	
	//@RequestMapping("/showUser")
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request,Model model){
		int userId = 1;
		if(null != request.getParameter("id")){
			userId = Integer.parseInt(request.getParameter("id"));
		}
		List<User> user = this.userService.selectAll();
		model.addAttribute("user", user);
		//mav.addObject("user", user);
		ModelAndView mav =  new ModelAndView();
		//mav.setViewName("user/showUser");
		return "user/showUser";
		//return mav;
	}
	@RequestMapping("/queryshowUser")
	public String toIndex2(HttpServletRequest request,Model model){
		int userId = 1;
		if(null != request.getParameter("id")){
			userId = Integer.parseInt(request.getParameter("id"));
		}
		PageQueryResult<User> user = this.userService.selectAllCount();
		model.addAttribute("user", user);
		ModelAndView mav =  new ModelAndView();
		return "user/showUser";
	}
	
	@RequestMapping("/addUser")
	public String addUser(HttpServletRequest request,Model model){
		int userId = 1;
		if(null != request.getParameter("id")){
			userId = Integer.parseInt(request.getParameter("id"));
		}
		List<User> userlist = this.userService.selectAll();
		model.addAttribute("user", userlist);
		model.addAttribute("total",20);
		return "user/addUser";
	}
	
	@RequestMapping("/newFile")
	public String addUser2(HttpServletRequest request,Model model){
		int userId = 1;
		if(null != request.getParameter("id")){
			userId = Integer.parseInt(request.getParameter("id"));
		}
		List<User> user = this.userService.selectAll();
		model.addAttribute("user", user);
		model.addAttribute("total",20);
		return "user/newFile";
	}
	
	@RequestMapping("/weather")
	public String weather(HttpServletRequest request,Model model){
		int userId = 1;
		if(null != request.getParameter("id")){
			userId = Integer.parseInt(request.getParameter("id"));
		}
		List<User> user = this.userService.selectAll();
		model.addAttribute("user", user);
		model.addAttribute("total",20);
		return "user/weather";
	}
	
	@RequestMapping("/showUserDetail")
	public String showUserDetail(HttpServletRequest request,Model model){
		int userId = 1;
		if(null != request.getParameter("id")){
			userId = Integer.parseInt(request.getParameter("id"));
		}
		List<User> user = this.userService.selectAll();
		model.addAttribute("user", user);
		model.addAttribute("total",20);
		return "user/showUserDetail";
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
