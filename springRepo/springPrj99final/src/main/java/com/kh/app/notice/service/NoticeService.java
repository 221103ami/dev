package com.kh.app.notice.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.app.notice.dao.NoticeDao;
import com.kh.app.notice.vo.NoticeVo;

@Service
public class NoticeService {
	
	private final NoticeDao dao;
	private final SqlSessionTemplate sst;
	
	@Autowired
	public NoticeService(NoticeDao dao , SqlSessionTemplate sst) {
		this.dao = dao;
		this.sst = sst;
	}

	public List<NoticeVo> getNoticeList() {
		return dao.getNoticeList(sst);
	}

}






















