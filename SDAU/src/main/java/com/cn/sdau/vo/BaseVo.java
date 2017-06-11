package com.cn.sdau.vo;

import java.io.Serializable;

public class BaseVo implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2675385709486722798L;

	private String sqlDateFormat = "%Y-%m-%d";

	private String sqlDateTimeFormat = "%Y-%m-%d %H:%i:%S";
	
	private int offset;
	
	private int limit;
	
	
	public String getSqlDateFormat() {
		return sqlDateFormat;
	}

	public void setSqlDateFormat(String sqlDateFormat) {
		this.sqlDateFormat = sqlDateFormat;
	}

	public String getSqlDateTimeFormat() {
		return sqlDateTimeFormat;
	}

	public void setSqlDateTimeFormat(String sqlDateTimeFormat) {
		this.sqlDateTimeFormat = sqlDateTimeFormat;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}


}
