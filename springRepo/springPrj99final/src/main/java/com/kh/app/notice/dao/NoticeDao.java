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

	public int write(SqlSessionTemplate sst, NoticeVo vo) {
		return sst.insert("notice.write" , vo);
	}

	public NoticeVo getNotice(SqlSessionTemplate sst, String num) {
		return sst.selectOne("notice.getNotice" , num);
	}

	public int edit(SqlSessionTemplate sst, NoticeVo vo) {
		return sst.update("notice.edit" , vo);
	}

}//class
















