/*
 *  @(#)LoginUserVo.java	1.0 2014/04/01
 *
 * Copyright (c) 2014, 家品会版权所有.
 * 家品会 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.cn.sdau.pojo;

import java.util.Date;

/**
 * 登录用户信息
 */
public class LoginUserVo extends User {
	private static final long serialVersionUID = 1L;

	//sessionId
	private String sessionId;
	
	private String lastLoginIp;
	
	private Date lastLoginDateTime;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Date getLastLoginDateTime() {
		return lastLoginDateTime;
	}

	public void setLastLoginDateTime(Date lastLoginDateTime) {
		this.lastLoginDateTime = lastLoginDateTime;
	}
	
	
}
