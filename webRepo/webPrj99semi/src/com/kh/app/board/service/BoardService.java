package com.kh.app.board.service;

import java.sql.Connection;
import java.util.List;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.util.JDBCTemplate;

public class BoardService {

	//게시글 조회
	public List<BoardVo> selectList() throws Exception {
		
		//비즈니스 로직
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//SQL (DAO)
		BoardDao dao = new BoardDao();
		List<BoardVo> boardList = dao.selectList(conn);
		
		//close
		JDBCTemplate.close(conn);
		
		return boardList;
	}

	//게시글 작성
	public int write(BoardVo vo) throws Exception {
		
		//비지니스 로직
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//SQL (DAO)
		BoardDao dao = new BoardDao();
		int result = dao.write(conn , vo);
		
		//tx , close
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

}//class
























