package com.kh.app.notice.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.common.page.PageVo;
import com.kh.app.notice.vo.NoticeVo;

@Repository
public class NoticeDao {

	public List<NoticeVo> getNoticeList(SqlSessionTemplate sst , PageVo pv) {
		int limit = pv.getBoardLimit(); 
		int offset = (pv.getCurrentPage()-1) * limit;
		RowBounds rb = new RowBounds(offset , limit);
		return sst.selectList("notice.getNoticeList" , null , rb );
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

	public int delete(SqlSessionTemplate sst, String num) {
		return sst.update("notice.delete" , num);
	}

	public int getNoticeListCnt(SqlSessionTemplate sst) {
		return sst.selectOne("notice.getNoticeListCnt");
	}

	public int increaseHit(SqlSessionTemplate sst, String num) {
		return sst.update("notice.increaseHit" , num);
	}

}//class
















