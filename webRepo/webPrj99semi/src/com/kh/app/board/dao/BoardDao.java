package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.board.vo.AttachmentVo;
import com.kh.app.board.vo.BoardVo;
import static com.kh.app.util.JDBCTemplate.*;

import com.kh.app.util.JDBCTemplate;
import com.kh.app.util.page.PageVo;

public class BoardDao {

	//게시글 목록 조회 (페이징 처리가 된)
	public List<BoardVo> selectList(Connection conn , PageVo pageVo) throws Exception {

		//SQL (close)
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM , TEMP.* FROM ( SELECT B.NO , B.TITLE , B.CONTENT , B.WRITER , B.ENROLL_DATE , B.HIT , M.NICK FROM BOARD B JOIN MEMBER M ON B.WRITER = M.NO WHERE B.DELETE_YN = 'N' ORDER BY NO DESC ) TEMP ) WHERE RNUM BETWEEN ? AND ?";
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
			String hit = rs.getString("HIT");
			
			BoardVo vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriter(writer);
			vo.setEnrollDate(enrollDate);
			vo.setHit(hit);
			
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
		
		close(pstmt);
		
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
		
		close(rs);
		close(pstmt);
		
		return cnt;
	}

	//게시글 상세조회
	public BoardVo selectOne(Connection conn, String no) throws Exception {
		
		//SQL
		String sql = "SELECT B.NO , B.TITLE , B.CONTENT , B.WRITER , B.ENROLL_DATE , B.HIT , A.CHANGE_NAME FROM BOARD B JOIN ATTACHMENT A ON (B.NO = A.REF_BOARD_NO) WHERE B.NO = ? AND B.DELETE_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		//rs -> obj
		BoardVo boardVo = null;
		if( rs.next() ) {
			String boardNo = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writer = rs.getString("WRITER");
			String enrollDate = rs.getString("ENROLL_DATE");
			String hit = rs.getString("HIT");
			String changeName = rs.getString("CHANGE_NAME");
			
			boardVo = new BoardVo();
			boardVo.setNo(boardNo);
			boardVo.setTitle(title);
			boardVo.setContent(content);
			boardVo.setWriter(writer);
			boardVo.setEnrollDate(enrollDate);
			boardVo.setHit(hit);
			boardVo.setChangeName(changeName);
		}
		
		//close 
		close(rs);
		close(pstmt);
		
		return boardVo;
	}
	
	
	/**
	 * 조회수 증가 
	 * 
	 * @param 커넥션
	 * @param 게시글번호
	 * @return 조회수 증가 성공여부
	 * @throws Exception 
	 */
	public int increaseHit(Connection conn , String no) throws Exception {
		
		//SQL
		String sql = "UPDATE BOARD SET HIT = HIT+1 WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		//close
		close(pstmt);
	
		return result;
	}

	//첨부파일 인서트
	public int insertAttachment(Connection conn, AttachmentVo atVo) throws Exception {
		
		//SQL
		String sql = "INSERT INTO ATTACHMENT (NO, ORIGIN_NAME, CHANGE_NAME, REF_BOARD_NO) VALUES(SEQ_ATTACHMENT_NO.NEXTVAL , ? , ? , SEQ_BOARD_NO.CURRVAL)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, atVo.getOriginName());
		pstmt.setString(2, atVo.getChangeName());
		int result = pstmt.executeUpdate();
		
		//close
		close(pstmt);
		
		return result;
	}


}//class
























