package com.cn.sdau.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.sdau.basic.PageQueryResult;
import com.cn.sdau.dao.DepartmentInfoMapper;
import com.cn.sdau.pojo.DepartmentInfo;
import com.cn.sdau.service.IDepartmentService;

@Service("DepartmentService")
public class DepartmentServiceImpl implements IDepartmentService {
	@Resource
	private DepartmentInfoMapper departmentInfoMapper;

	@Override
	public PageQueryResult<DepartmentInfo> queryDepartment(DepartmentInfo departmentInfo) {
		PageQueryResult<DepartmentInfo> result = new PageQueryResult<>();
		result.setTotal(departmentInfoMapper.selectByInfoCount(departmentInfo));
		departmentInfo.setOffset((departmentInfo.getPage()-1)*departmentInfo.getRows());
		departmentInfo.setLimit(departmentInfo.getRows());
		result.setRows(departmentInfoMapper.selectByInfo(departmentInfo));
		return result;
	}

}
