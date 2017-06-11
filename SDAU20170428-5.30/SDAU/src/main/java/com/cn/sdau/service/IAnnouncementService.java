package com.cn.sdau.service;

import com.cn.sdau.basic.SimpleServiceResult;
import com.cn.sdau.pojo.Announcement;

/**
 * 公告
 * 
 * @author lzxy1
 *
 */
public interface IAnnouncementService {
	
	/**
	 * 查询公告内容
	 * 
	 * @return
	 */
	public com.cn.sdau.pojo.Announcement getAnno ();
	
	/**
	 * 更新公告内容
	 * 
	 * @param anno
	 * @return
	 */
	public SimpleServiceResult updateAnno(Announcement anno);

}
