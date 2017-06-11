package com.cn.sdau.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cn.sdau.basic.PageQueryResult;
import com.cn.sdau.pojo.Announcement;
import com.cn.sdau.pojo.LoginUserVo;
import com.cn.sdau.pojo.User;
import com.cn.sdau.service.IAnnouncementService;
import com.cn.sdau.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;
	@Resource
	private IAnnouncementService announcementService;
	
	//@RequestMapping("/showUser")
	@RequestMapping("/showUser")
	public ModelAndView toIndex(HttpServletRequest request,Model model){
		int userId = 1;
		if(null != request.getParameter("id")){
			userId = Integer.parseInt(request.getParameter("id"));
		}
		User user = new User();
		user.setUserName("");
		user.setId(userId);
		user.setPassword("");
		//PageQueryResult<User> userResult = this.userService.selectBy(user);
		List<User> userList = this.userService.selectAll();
		model.addAttribute("user", userList);
		ModelAndView mav =  new ModelAndView();
		mav.addObject("user", userList);
		mav.setViewName("user/showUser");
		//return "user/showUser";
		return mav;
	}
	@RequestMapping("/showUserQuery")
	@ResponseBody
	public PageQueryResult<User> query(HttpServletRequest request,User user){
		//PageQueryResult<User> userResult = this.userService.selectBy(user);
		List<User> userList = this.userService.selectAll();
		PageQueryResult<User> userResult = new PageQueryResult<User>();
		userResult.setTotal(2);
		userResult.setRows(userList);
		//model.addAttribute("user", userList);
		//mav.addObject("user", user);
		//ModelAndView mav =  new ModelAndView();
		//mav.setViewName("user/showUser");
		return userResult;
		//return mav;
	}
	@RequestMapping("/queryshowUser")
	public String toIndex2(HttpServletRequest request,Model model){
		int userId = 1;
		if(null != request.getParameter("id")){
			userId = Integer.parseInt(request.getParameter("id"));
		}
		List<User> user = this.userService.selectAll();
		model.addAttribute("user", user);
		ModelAndView mav =  new ModelAndView();
		return "user/showUser";
	}
	
	/**
	 * 首页
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/addUser")
	public String addUser(HttpServletRequest request,Model model){
		LoginUserVo loginUserVo = (LoginUserVo) request.getSession().getAttribute("LOGIN_USER_KEY");
		if(null == loginUserVo){
			return "redirect:/login/index";
		}else{
		Announcement anno = announcementService.getAnno();
		model.addAttribute("anno", anno);
		model.addAttribute("loginUser", loginUserVo);
		List<User> userlist = this.userService.selectAll();
		model.addAttribute("user", userlist);
		model.addAttribute("total",20);
		return "user/addUser";
		}
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
	
	/**
	 * 用户详情首页
	 * 
	 * @param request
	 * @param mav
	 * @return
	 */
	@RequestMapping("/userDetail")
	public ModelAndView showUserDetail(@RequestParam(value = "userName", required = false) String userName
			,HttpServletRequest request,ModelAndView mav){
		mav.addObject("userName", userName);
		mav.setViewName("redirect:/system/userDetail;");
		return mav;
	}

}
