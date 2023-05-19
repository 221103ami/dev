package com.kh.app;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BoardService {
	
	private final SqlSessionTemplate sst;
	private final BoardDao dao;
	
	@Autowired
	public BoardService(SqlSessionTemplate sst, BoardDao dao) {
		this.sst = sst;
		this.dao = dao;
	}

	public int write(BoardVo vo) {
		return dao.write(sst , vo);
	}

	public BoardVo getBoard() {
		return dao.getBoard(sst);
	}

	

}














