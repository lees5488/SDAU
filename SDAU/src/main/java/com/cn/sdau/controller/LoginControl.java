package com.cn.sdau.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.sdau.basic.ServiceResult;
import com.cn.sdau.pojo.LoginUserVo;

/**
 * 登录Controller
 * 
 * @author lzxy1
 *
 */
@Controller
@RequestMapping("/login")
public class LoginControl extends BaseController {

	/**
	 * login 画面
	 * 
	 * @param mav
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav, HttpServletRequest request) {
		mav.setViewName("login/index");
		return mav;
	}

	/**
	 * 登录验证
	 * 
	 * @param loginUserVo
	 *            登录信息
	 * @param request
	 * @param response
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public ModelAndView login(LoginUserVo loginUserVo, HttpServletRequest request, HttpServletResponse response,
			ModelAndView mav) {
		// SystemSession session = getSystemSession(request);
		// 验证码检查
		loginUserVo.setLastLoginDateTime(new Date());
		//获取IP
		loginUserVo.setLastLoginIp(getIpAddr(request));
		logger.info("---登录请求信息:" + JSON.toJSONString(loginUserVo));
		ServiceResult<LoginUserVo> result = new ServiceResult<LoginUserVo>();
		// loginService.updateAndGetUserVerification(loginUserVo);
		loginUserVo.setId(1);
		loginUserVo.setUserName("超级管理员");
		logger.info("---登录验证结果:" + JSON.toJSONString(result.getData()));
		if (result.isOk()) {// 登录成功
			//loginUserVo = result.getData();
			//加入页面
			mav.addObject("loginUser", loginUserVo);
			//设置session
			request.getSession().setAttribute("LOGIN_USER_KEY", loginUserVo);
			// session.setAttribute("LOGIN_USER_KEY", loginUserVo);
			mav.setViewName("redirect:/user/addUser");
			return mav;
		} else {
			mav.addObject("errorMessage", "账号或密码错误");
		}
		mav.addObject("loginUserVo", loginUserVo);
		mav.setViewName("redirect:/login/index");// 登录失败，返回登录画面
		return mav;
	}

	/**
	 * 
	 * @param request
	 * @param mav
	 * @return
	 */
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, ModelAndView mav) {
		// 清除session
		request.getSession().invalidate();
		//定向到登录页面
		mav.setViewName("redirect:/login/index");
		return mav;
	}

	/**
	 * 根据request取得IP
	 * @param request
	 * @return
	 */
	protected String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        
        String[] ips = ip.split(",");
        
        if(ips.length>0){
        	ip=ips[0];
        }
        
        return ip;
    }
}
