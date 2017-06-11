/*
 *  @(#)ServiceResult.java	1.0 2014/04/01
 *
 * Copyright (c) 2014, 家品会版权所有.
 * 家品会 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.cn.sdau.basic;

import java.io.Serializable;

/**
 * service返回值包装对象
 * @param <T>
 * 
 */
public class ServiceResult<T> extends SimpleServiceResult implements Serializable {
	private static final long serialVersionUID = -6652076509848001811L;

	/**
	 * 数据
	 */
	private T data;
	
	public ServiceResult() {
		super(true);
	}
	
	public ServiceResult(T data) {
		super(true);
		this.data = data;
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
