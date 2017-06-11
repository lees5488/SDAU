package com.cn.sdau.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cn.sdau.basic.PageQueryResult;
import com.cn.sdau.pojo.DepartmentInfo;
import com.cn.sdau.pojo.EmployeeInfo;
import com.cn.sdau.service.IDepartmentService;
import com.cn.sdau.service.IEmployeeListService;

/**
 * 主档员工
 * 
 * @author lzxy1
 *
 */
@Controller
@RequestMapping("/employeeList")
public class EmployeeListController extends BaseController {
	@Resource
	private IEmployeeListService employeeListService;

	/**
	 * 员工首页
	 * 
	 * @param request
	 * @param mav
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request, ModelAndView mav) {
		// Announcement anno = announcementService.getAnno();
		// mav.addObject("anno", anno);
		mav.setViewName("master/employeeList");
		return mav;
	}

	/**
	 * 员工查询
	 * 
	 * @param request
	 * @param employeeInfo
	 * @return
	 */
	@RequestMapping("/query")
	@ResponseBody
	public PageQueryResult<EmployeeInfo> query(HttpServletRequest request, EmployeeInfo employeeInfo) {
		//PageQueryResult<DepartmentInfo> result = departmentService.queryDepartment(employeeInfo);
		PageQueryResult<EmployeeInfo> result = employeeListService.queryByEmployeeInfo(employeeInfo);
		return result;
	}
}
