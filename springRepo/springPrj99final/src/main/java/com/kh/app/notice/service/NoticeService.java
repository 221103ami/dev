package com.kh.app.notice.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.app.common.page.PageVo;
import com.kh.app.notice.dao.NoticeDao;
import com.kh.app.notice.vo.NoticeVo;

@Service
@Transactional
public class NoticeService {
	
	private final NoticeDao dao;
	private final SqlSessionTemplate sst;
	
	@Autowired
	public NoticeService(NoticeDao dao , SqlSessionTemplate sst) {
		this.dao = dao;
		this.sst = sst;
	}

	public List<NoticeVo> getNoticeList(PageVo pv) {
		return dao.getNoticeList(sst , pv);
	}

	public int write(NoticeVo vo) {
		return dao.write(sst , vo);
	}

	public NoticeVo getNotice(String num) throws Exception {
		int result = dao.increaseHit(sst , num);
		if(result != 1) {
			throw new Exception();
		}
		return dao.getNotice(sst , num);
	}

	public int edit(NoticeVo vo) {
		return dao.edit(sst , vo);
	}

	public int delete(String num) {
		return dao.delete(sst , num);
	}

	public int getNoticeListCnt() {
		return dao.getNoticeListCnt(sst);
	}

}






















