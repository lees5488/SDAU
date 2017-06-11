package com.cn.sdau.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cn.sdau.basic.PageQueryResult;
import com.cn.sdau.pojo.DepartmentInfo;
import com.cn.sdau.service.IDepartmentService;

/**
 * 主档部门
 * 
 * @author lzxy1
 *
 */
@Controller
@RequestMapping("/department")
public class DepartmentController extends BaseController {
	@Resource
	private IDepartmentService departmentService;

	/**
	 * 部门首页
	 * 
	 * @param request
	 * @param mav
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request, ModelAndView mav) {
		// Announcement anno = announcementService.getAnno();
		// mav.addObject("anno", anno);
		mav.setViewName("master/departmentList");
		return mav;
	}

	/**
	 * 部门查询
	 * 
	 * @param request
	 * @param departmentInfo
	 * @return
	 */
	@RequestMapping("/query")
	@ResponseBody
	public PageQueryResult<DepartmentInfo> query(HttpServletRequest request, DepartmentInfo departmentInfo) {
		PageQueryResult<DepartmentInfo> result = departmentService.queryDepartment(departmentInfo);
		return result;
	}
}
