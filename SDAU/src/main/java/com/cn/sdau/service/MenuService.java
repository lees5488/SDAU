package com.cn.sdau.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cn.sdau.basic.PageHelper;
import com.cn.sdau.basic.SysMenu;

@Service
public interface MenuService {
	/**
	 * 获取总数
	 * @param user
	 * @return
	 */
	public Long getDatagridTotal(SysMenu menu);

	/**
	 * 获取一级列表
	 * @param page
	 * @return
	 */
	public List<SysMenu> datagridMenu(PageHelper page);
	
	/**
	 * 获取所有列表
	 * @param page
	 * @return
	 */
	public List<SysMenu> getAll(PageHelper page);

	public void deleteMenuById(Integer menuId);

	public SysMenu getMenuById(Integer menuId);

	public List<SysMenu> listAllParentMenu();

	public void saveMenu(SysMenu menu);

	public List<SysMenu> listSubMenuByParentid(Integer parentid);
	
	public List<SysMenu> listAllMenu();
	
	public List<SysMenu> listAllSubMenu();
	
}
