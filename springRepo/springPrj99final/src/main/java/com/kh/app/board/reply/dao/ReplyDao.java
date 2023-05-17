package com.kh.app.board.reply.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.board.reply.controller.ReplyVo;

@Repository
public class ReplyDao {

	public int write(SqlSessionTemplate sst, ReplyVo vo) {
		return sst.insert("reply.write" , vo);
	}

}
