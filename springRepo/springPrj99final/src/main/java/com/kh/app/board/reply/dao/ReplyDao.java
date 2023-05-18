package com.kh.app.board.reply.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.board.reply.vo.ReplyVo;

@Repository
public class ReplyDao {

	public int write(SqlSessionTemplate sst, ReplyVo vo) {
		return sst.insert("reply.write" , vo);
	}

	public List<ReplyVo> getReplyList(SqlSessionTemplate sst, String bno) {
		return sst.selectList("reply.getReplyList" , bno);
	}

	public int delete(SqlSessionTemplate sst, ReplyVo rvo) {
		return sst.update("reply.delete" , rvo);
	}

	public int edit(SqlSessionTemplate sst, ReplyVo vo) {
		return sst.update("reply.edit" , vo);
	}

}









