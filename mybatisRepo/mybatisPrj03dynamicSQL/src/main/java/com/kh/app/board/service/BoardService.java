package com.kh.app.board.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.common.db.SqlSessionTemplate;

public class BoardService {

	//write
	public int write(BoardVo boardVo) {
		
		//conn
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		
		//SQL
		BoardDao dao = new BoardDao();
		int result = dao.write(ss , boardVo);
		
		//tx || rs
		if(result == 1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		
		//close
		ss.close();
		
		return result;
	}//method

	public List<BoardVo> selectBoardList() {
		
		//conn
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		
		//SQL
		BoardDao dao = new BoardDao();
		List<BoardVo> list = dao.selectBoardList(ss);
		//tx || rs
		
		//close
		ss.close();
		
		return list;
	}

	//검색
	public List<BoardVo> searchList(Map<String, String> map) {

		//conn
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		
		//SQL
		BoardDao dao = new BoardDao();
		List<BoardVo> list = dao.search(ss , map);
		//tx || rs
		
		//close
		ss.close();
		
		return list;
	}

}//class










