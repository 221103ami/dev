package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.util.JDBCTemplate;

public class BoardDao {

	//게시글 조회
	public List<BoardVo> selectList(Connection conn) throws Exception {

		//SQL (close)
		String sql = "SELECT B.NO , B.TITLE , B.CONTENT , B.WRITER , B.ENROLL_DATE , M.NICK FROM BOARD B JOIN MEMBER M ON B.WRITER = M.NO WHERE B.DELETE_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs -> obj (List<BoardVo>)
		List<BoardVo> boardList = new ArrayList<BoardVo>();
		
		while( rs.next() ) {
			
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writer = rs.getString("NICK");
			String enrollDate = rs.getString("ENROLL_DATE");
			
			BoardVo vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriter(writer);
			vo.setEnrollDate(enrollDate);
			
			boardList.add(vo);
		}
		
		return boardList;
	}

	//게시글 작성
	public int write(Connection conn, BoardVo vo) throws Exception {
		
		//SQL (close)
		String sql = "INSERT INTO BOARD(NO , TITLE , CONTENT , WRITER) VALUES (SEQ_BOARD_NO.NEXTVAL , ? , ? , ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		pstmt.setString(3, vo.getWriter());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

}//class
























