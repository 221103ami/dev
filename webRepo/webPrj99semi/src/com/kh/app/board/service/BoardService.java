package com.kh.app.board.service;

import java.sql.Connection;
import java.util.List;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.util.JDBCTemplate;
import com.kh.app.util.page.PageVo;

public class BoardService {

	//게시글 조회 (페이징 처리가 된)
	public List<BoardVo> selectList(PageVo pageVo) throws Exception {
		
		//비즈니스 로직
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//SQL (DAO)
		BoardDao dao = new BoardDao();
		List<BoardVo> boardList = dao.selectList(conn , pageVo);
		
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
	
	//게시글 전체 갯수 조회 (삭제되지않은)
	public int selectCount() throws Exception {
		
		//비지니스 로직
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//SQL (DAO)
		BoardDao dao = new BoardDao();
		int result = dao.selectCount(conn);
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

}//class
























