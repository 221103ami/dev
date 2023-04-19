package com.kh.app.notice.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.notice.vo.NoticeVo;

@Repository
public class NoticeDao {

	public List<NoticeVo> getNoticeList(SqlSessionTemplate sst) {
		return sst.selectList("notice.getNoticeList");
	}

}
