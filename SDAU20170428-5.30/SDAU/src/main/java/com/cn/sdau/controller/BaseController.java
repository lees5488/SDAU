package com.cn.sdau.controller;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import com.cn.sdau.basic.JsonResult;
import com.cn.sdau.basic.ServiceResult;
import com.cn.sdau.basic.SimpleServiceResult;
import com.cn.sdau.pojo.LoginUserVo;

import util.SpringUtils;

public class BaseController {

	protected static final Logger logger = LoggerFactory.getLogger(BaseController.class);

	private static final String MSG_NEW_LINE = "<br>";

	/**
	 * 输出json
	 * 
	 * @param response
	 * @param json
	 */
	public void write(HttpServletResponse response, String json) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/json");
			response.getWriter().write(json);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 返回结果消息
	 * 
	 * @param response
	 * @param bool
	 */
	public void write(HttpServletResponse response, boolean bool) {
		try {
			String json = "{\"success\":\"" + bool + "\"}";
			response.getWriter().write(json);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/*		*//**
				 * 转换SeviceResult对象为JsonResult
				 * 
				 * @param serviceResult
				 * @return
				 */
	/*
	 * protected JsonResult convertSeviceResultToJsonResult(SimpleServiceResult
	 * serviceResult){ JsonResult json = new JsonResult();
	 * json.setOk(serviceResult.isOk());
	 * json.setComment(serviceResult.getComment());
	 * json.setMsgType(serviceResult.getMsgType());
	 * 
	 * List<ServiceResult<?>.Message> msgs = serviceResult.getMsgs(); if(msgs !=
	 * null){ StringBuffer sb = new StringBuffer(); for(ServiceResult<?>.Message
	 * msg : msgs){ String msgContent = this.getMessage(msg.getMsgId());
	 * if(msgContent != null){ sb.append(MessageFormat.format(msgContent,
	 * (Object[])msg.getParams()) + MSG_NEW_LINE); }else{
	 * sb.append(msg.getMsgId()); } } json.setMessage(sb.toString()); }
	 * 
	 * if(serviceResult instanceof ServiceResult){
	 * json.setData(((ServiceResult<?>)serviceResult).getData()); }
	 * 
	 * return json; }
	 * 
	 *//**
		 * 获取message
		 * 
		 * @param key
		 * @return
		 *//*
		 * @SuppressWarnings("unchecked") protected String getMessage(String
		 * key){ WebApplicationContext webApplicationContext =
		 * (WebApplicationContext) SpringUtils.getApplicationContext();
		 * ServletContext servletContext =
		 * webApplicationContext.getServletContext(); Map<String, String>
		 * message=(Map<String, String>) servletContext.getAttribute("message");
		 * return message.get(key); }
		 */

	/**
	 * 转换ajax请求参数类型，并返回
	 * 
	 * @param ajaxObj
	 * @param type
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected <T> T getAjaxReqParam(Object ajaxObj, TypeReference type) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		Object data;
		if (ajaxObj instanceof MultiValueMap) {
			data = ((MultiValueMap<String, String>) ajaxObj).toSingleValueMap();
		} else {
			data = ajaxObj;
		}

		T res = mapper.convertValue(data, type);
		return res;
	}
	
	/**
	 * 获取登录用户对象
	 * @param request
	 * @return
	 */
	protected int getLoginUserId(HttpServletRequest request){
		Integer loginUserId=null;
		LoginUserVo loginUser = getLoginUser(request);
		if(loginUser != null){
			loginUserId =loginUser.getId();
		}
		return loginUserId;
	}
	
	/**
	 * 获取登录用户对象
	 * @param request
	 * @return
	 */
	protected LoginUserVo getLoginUser(HttpServletRequest request){
		
		LoginUserVo loginUser=null;
		if(request.getSession().getAttribute("LOGIN_USER_KEY") != null) {
			Object obj = request.getSession().getAttribute("LOGIN_USER_KEY");
			if(obj != null){
				loginUser =(LoginUserVo) obj;
			}
		}
		return loginUser;
	}
	
	/**
	 * 转换SeviceResult对象为JsonResult
	 * 
	 * @param serviceResult
	 * @return
	 */
	protected JsonResult convertSeviceResultToJsonResult(SimpleServiceResult serviceResult){
		JsonResult json = new JsonResult();
		json.setOk(serviceResult.isOk());
		json.setComment(serviceResult.getComment());
		json.setMsgType(serviceResult.getMsgType());
		
		List<ServiceResult<?>.Message> msgs = serviceResult.getMsgs();
		if(msgs != null){
			StringBuffer sb = new StringBuffer();
			for(ServiceResult<?>.Message msg : msgs){
				String msgContent = this.getMessage(msg.getMsgId());
				if(msgContent != null){
					sb.append(MessageFormat.format(msgContent, (Object[])msg.getParams()) + MSG_NEW_LINE);
				}else{
					sb.append(msg.getMsgId());
				}
			}
			json.setMessage(sb.toString());
		}
		
		if(serviceResult instanceof ServiceResult){
			json.setData(((ServiceResult<?>)serviceResult).getData());
		}
		
		return json;
	}
	
	/**
	 * 获取message
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected String getMessage(String key){
		WebApplicationContext webApplicationContext = (WebApplicationContext) SpringUtils.getApplicationContext(); 
        ServletContext servletContext = webApplicationContext.getServletContext();
        Map<String, String> message=(Map<String, String>) servletContext.getAttribute("message");
        return message.get(key);
	}	

}
