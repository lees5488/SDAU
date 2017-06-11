package com.cn.sdau.basic;

import java.util.List;

import com.cn.sdau.vo.BaseVo;

public class PageQueryResult<T> extends BaseVo {
	
	
/**
	 * 
	 */
	private static final long serialVersionUID = -2478061014515348803L;

private boolean isException = false;
	
	/**
	 * 总数
	 */
	private int total;
	
	/**
	 * 数据
	 */
	private List<T> rows;
	
	/**
	 * 底部合计相关数据
	 */
	private List<T> footer;

	public boolean isException() {
		return isException;
	}

	public void setException(boolean isException) {
		this.isException = isException;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public List<T> getFooter() {
		return footer;
	}

	public void setFooter(List<T> footer) {
		this.footer = footer;
	}
	
	

}
