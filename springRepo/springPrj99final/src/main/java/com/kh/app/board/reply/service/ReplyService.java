package com.kh.app.board.reply.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.app.board.reply.controller.ReplyVo;
import com.kh.app.board.reply.dao.ReplyDao;

@Service
public class ReplyService {
	
	private final ReplyDao dao;
	private final SqlSessionTemplate sst;
	
	@Autowired
	public ReplyService(ReplyDao dao, SqlSessionTemplate sst) {
		this.dao = dao;
		this.sst = sst;
	}

	public int write(ReplyVo vo) {
		return dao.write(sst , vo);
	}

}



















