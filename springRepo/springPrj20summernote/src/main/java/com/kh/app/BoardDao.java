package com.kh.app;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {

	public int write(SqlSessionTemplate sst, BoardVo vo) {
		return sst.insert("board.write" , vo);
	}

	public BoardVo getBoard(SqlSessionTemplate sst) {
		return sst.selectOne("board.getBoard");
	}
	

}
