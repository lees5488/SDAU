package com.cn.sdau.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cn.sdau.basic.JsonResult;
import com.cn.sdau.basic.SimpleServiceResult;
import com.cn.sdau.pojo.Announcement;
import com.cn.sdau.service.IAnnouncementService;
import com.cn.sdau.service.IUserService;

/**
 * 主档公告
 * 
 * @author lzxy1
 *
 */
@Controller
@RequestMapping("/announcement")
public class AnnouncementController extends BaseController {
	@Resource
	private IUserService userService;
	@Resource
	private IAnnouncementService announcementService;

	/**
	 * 公告首页
	 * 
	 * @param request
	 * @param mav
	 * @return
	 */
	@RequestMapping("/anno")
	public ModelAndView index(HttpServletRequest request, ModelAndView mav) {
		Announcement anno = announcementService.getAnno();
		mav.addObject("anno", anno);
		mav.setViewName("master/announcement");
		return mav;
	}

	/**
	 * 更新公告
	 * 
	 * @param request
	 * @param anno
	 * @return
	 */
	@RequestMapping("/updateAnnouncement")
	@ResponseBody
	public JsonResult updateAnnouncement(HttpServletRequest request, @RequestBody Object obj) {
		//更新人
		Announcement anno = this.getAjaxReqParam(obj, new TypeReference<Announcement>() {});
		anno.setUpdateUser(this.getLoginUserId(request));
		SimpleServiceResult sResult = announcementService.updateAnno(anno);
		return this.convertSeviceResultToJsonResult(sResult);

	}

}
