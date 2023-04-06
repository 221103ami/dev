package com.kh.app.board.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.vo.BoardVo;

public class BoardDao {

	//write
	public int write(SqlSession ss, BoardVo boardVo) {
		return ss.insert("board.write" , boardVo);
	}

}
