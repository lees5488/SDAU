package com.cn.sdau.service;

import com.cn.sdau.basic.PageQueryResult;
import com.cn.sdau.pojo.DepartmentInfo;

/**
 * 部门
 * 
 * @author lzxy1
 *
 */
public interface IDepartmentService {
	
	//按条件查询部门信息
	public PageQueryResult<DepartmentInfo> queryDepartment (DepartmentInfo departmentInfo);
	

}
