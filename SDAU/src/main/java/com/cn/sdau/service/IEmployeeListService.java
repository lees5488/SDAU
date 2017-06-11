package com.cn.sdau.service;

import com.cn.sdau.basic.PageQueryResult;
import com.cn.sdau.pojo.EmployeeInfo;

/**
 * 员工
 * 
 * @author lzxy1
 *
 */
public interface IEmployeeListService {
	
	//查询员工信息
	public PageQueryResult<EmployeeInfo> queryByEmployeeInfo(EmployeeInfo employeeInfo);

}
