/*
 *  @(#)SimpleServiceResult.java	1.0 2014/04/01
 *
 * Copyright (c) 2014, 上海坦思计算机系统有限公司 版权所有.
 * TES PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.cn.sdau.basic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SimpleServiceResult implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final char MSG_TYPE_ERROR 	= 'E';
	public static final char MSG_TYPE_INFO 		= 'I';
	public static final char MSG_TYPE_WARNING	= 'W';
	
	/**
	 * 没有消息的正常结果
	 */
	public static final SimpleServiceResult OK = new SimpleServiceResult(true);
	
	/**
	 * 结果
	 */
	private boolean isOk = true;

		/**
	 * 消息
	 */
	protected List<Message> msgs;
	
	/**
	 * 消息类型
	 */
	private char msgType = MSG_TYPE_INFO;
	
	/**
	 * 备注
	 */
	private String comment;


	public class Message implements Serializable {
		private static final long serialVersionUID = 875220265072895432L;

		private String msgId;
		
		private int index = Integer.MAX_VALUE;
		
		private String[] params;
		
		public Message(String msgId, String[] params) {
			super();
			this.msgId = msgId;
			this.params = params;
		}	
		
		public Message(String msgId,int index, String[] params) {
			super();
			this.msgId = msgId;
			this.index = index;
			this.params = params;
		}
		
		public String getMsgId() {
			return msgId;
		}
		public void setMsgId(String msgId) {
			this.msgId = msgId;
		}
		public String[] getParams() {
			return params;
		}
		public void setParams(String[] params) {
			this.params = params;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}
		
	}

	public SimpleServiceResult(boolean isOk) {
		this.isOk = isOk;
	}

	/**
	 * 有消息的结果
	 * @param msgId 暂定如果已E开头为失败消息
	 * @param params 消息的参数
	 */
	public SimpleServiceResult(String msgId, String... params) {
		this.addMsg(msgId, params);
	}

	
	/**
	 * 追加消息
	 * @param msgId
	 * @param objects
	 */
	public SimpleServiceResult addMsg(String msgId, String... params) {
		Message newMsg = new Message(msgId, params);
		if(msgs == null){
			msgs = new ArrayList<SimpleServiceResult.Message>();
		}
		char flag = msgId.charAt(0);
		if(flag == 'E'){
			this.setMsgType(MSG_TYPE_ERROR);
			this.isOk = false;
		}else if(flag == 'W'){
			if(this.getMsgType() != MSG_TYPE_ERROR){
				this.setMsgType(MSG_TYPE_WARNING);
			}
			this.isOk = false;
		}
		msgs.add(newMsg);
		return this;
	}	
	
	/**
	 * 导入追加消息 
	 * @param msgId
	 * @param objects
	 */
	public SimpleServiceResult addUploadMsg(String msgId,String... params) {
		Message newMsg = new Message(msgId,Integer.parseInt(params[0]), params);
		if(msgs == null){
			msgs = new ArrayList<SimpleServiceResult.Message>();
		}
		char flag = msgId.charAt(0);
		if(flag == 'E'){
			this.setMsgType(MSG_TYPE_ERROR);
			this.isOk = false;
		}else if(flag == 'W'){
			if(this.getMsgType() != MSG_TYPE_ERROR){
				this.setMsgType(MSG_TYPE_WARNING);
			}
			this.isOk = false;
		}
		msgs.add(newMsg);
		return this;
	}	
	
	public char getMsgType() {
		return msgType;
	}

	public void setMsgType(char msgType) {
		this.msgType = msgType;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}
	
	public List<Message> getMsgs() {
		return msgs;
	}

	public void setMsgs(List<Message> msgs) {
		this.msgs = msgs;
	}
	
	public void addMsgs(List<Message> msgs){
		if(this.msgs == null){
			this.msgs = new ArrayList<SimpleServiceResult.Message>();
		}
		this.msgs.addAll(msgs);
	}
	
}
