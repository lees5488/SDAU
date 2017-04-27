package com.cn.sdau.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.sdau.basic.SimpleServiceResult;
import com.cn.sdau.dao.AnnouncementMapper;
import com.cn.sdau.pojo.Announcement;
import com.cn.sdau.pojo.AnnouncementExample;
import com.cn.sdau.pojo.AnnouncementExample.Criteria;
import com.cn.sdau.service.IAnnouncementService;

import util.DateTimeUtils;

@Service("AnnouncementService")
public class AnnouncementServiceImpl implements IAnnouncementService {

	@Resource
	private AnnouncementMapper announcementMapper;

	@Override
	public Announcement getAnno() {
		// AnnouncementExample example = new AnnouncementExample();
		// example.createCriteria().andIdEqualTo(1);
		return announcementMapper.selectByPrimaryKey(1);
	}

	@Override
	public SimpleServiceResult updateAnno(Announcement anno) {
		//anno.setUpdateDate(new Date());
		SimpleServiceResult simpleServiceResult = new SimpleServiceResult(false);
		AnnouncementExample example = new AnnouncementExample();
		Criteria criteria = example.createCriteria();
		Announcement announcement = announcementMapper.selectByPrimaryKey(1);
		if(null == announcement || announcement.getUpdateDate().equals(DateTimeUtils.parseStr(anno.getUpdateDateStr())) == false){
			throw new RuntimeException("数据不是最新");
		}
		criteria.andIdEqualTo(1);
		criteria.andUpdateDateEqualTo(announcement.getUpdateDate()); 
		//example.createCriteria().andIdEqualTo(1); 
		//example.createCriteria().andUpdateDateEqualTo(anno.getUpdateDate());
		if (1 == announcementMapper.updateByExampleSelective(anno, example)) {
			simpleServiceResult.setOk(true);
		}
		return simpleServiceResult;
	}

}
