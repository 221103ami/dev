package com.kh.app.board.service;

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

}//class
