package com.cn.sdau.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 共通url定义类
 * 
 * @author tongc
 * 
 */
@Controller
public class CommController extends BaseController {
	
	/**
	 * 404
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = "/404.htm")
	public String notFound( ) {
		return "/404";
	}
}
