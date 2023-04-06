package com.kh.app.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.vo.BoardVo;

public class BoardDao {

	//write
	public int write(SqlSession ss, BoardVo boardVo) {
		return ss.insert("board.write" , boardVo);
	}

	public List<BoardVo> selectBoardList(SqlSession ss) {
		return ss.selectList("board.selectBoardList");
	}

	public List<BoardVo> search(SqlSession ss, Map<String, String> map) {
		return ss.selectList("board.search" , map);
	}

}//class












