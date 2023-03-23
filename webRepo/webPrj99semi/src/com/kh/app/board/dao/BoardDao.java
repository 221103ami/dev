package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.util.JDBCTemplate;
import com.kh.app.util.page.PageVo;

public class BoardDao {

	//게시글 조회 (페이징 처리가 된)
	public List<BoardVo> selectList(Connection conn , PageVo pageVo) throws Exception {

		//SQL (close)
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM , TEMP.* FROM ( SELECT B.NO , B.TITLE , B.CONTENT , B.WRITER , B.ENROLL_DATE , M.NICK FROM BOARD B JOIN MEMBER M ON B.WRITER = M.NO WHERE B.DELETE_YN = 'N' ORDER BY NO DESC ) TEMP ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int startRow = (pageVo.getCurrentPage()-1) * pageVo.getBoardLimit() + 1;
		int endRow = startRow + pageVo.getBoardLimit() - 1;
		pstmt.setInt(1, startRow);
		pstmt.setInt(2, endRow);
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
	
	//게시글 전체 갯수 조회 (삭제되지않은)
	public int selectCount(Connection conn) throws Exception {
		
		//SQL (close)
		String sql = "SELECT COUNT(*) AS CNT FROM BOARD WHERE DELETE_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs -> obj
		int cnt = 0;
		if( rs.next() ) {
			cnt = rs.getInt("CNT");
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return cnt;
	}
	

}//class
























