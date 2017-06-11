package com.cn.sdau.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.sdau.basic.PageQueryResult;
import com.cn.sdau.dao.EmployeeInfoMapper;
import com.cn.sdau.pojo.EmployeeInfo;
import com.cn.sdau.service.IEmployeeListService;

@Service("EmployeeList")
public class EmployeeListServiceImpl implements IEmployeeListService {
	@Resource
	private EmployeeInfoMapper employeeInfoMapper;

	@Override
	public PageQueryResult<EmployeeInfo> queryByEmployeeInfo(EmployeeInfo employeeInfo) {
		PageQueryResult<EmployeeInfo> result = new PageQueryResult<>();
		employeeInfo.setOffset((employeeInfo.getPage() - 1) * employeeInfo.getRows());
		employeeInfo.setLimit(employeeInfo.getRows());
		result.setTotal(employeeInfoMapper.selectByEmpInfoCount(employeeInfo));
		result.setRows(employeeInfoMapper.selectByEmpInfo(employeeInfo));
		return result;
	}

}
