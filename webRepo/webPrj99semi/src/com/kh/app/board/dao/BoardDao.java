package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.board.vo.BoardVo;

public class BoardDao {

	//게시글 조회
	public List<BoardVo> selectList(Connection conn) throws Exception {

		//SQL (close)
		String sql = "SELECT * FROM BOARD WHERE DELETE_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs -> obj (List<BoardVo>)
		List<BoardVo> boardList = new ArrayList<BoardVo>();
		
		while( rs.next() ) {
			
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writer = rs.getString("WRITER");
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

}//class
























