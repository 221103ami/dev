package com.kh.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.JDBCTemplate;

public class MemberDao {

	//회원가입
	public int join(SqlSession ss, MemberVo vo) throws Exception {
		return ss.insert("member.join", vo);
//		String sql = "INSERT INTO MEMBER(NO, ID, PWD, NICK) VALUES (SEQ_MEMBER_NO.NEXTVAL , ?, ?, ?)";
//		PreparedStatement pstmt = ss.prepareStatement(sql);
//		pstmt.setString(1, vo.getId());
//		pstmt.setString(2, vo.getPwd());
//		pstmt.setString(3, vo.getNick());
//		int result = pstmt.executeUpdate();
//		
//		JDBCTemplate.close(pstmt);
//		
//		return result;
	}

	//로그인
	public MemberVo login(Connection conn, MemberVo vo) throws Exception {

		//2. SQL
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		ResultSet rs = pstmt.executeQuery();
		
		//3. tx || rs
		MemberVo loginMember = null;
		if( rs.next() ) {
			String no = rs.getString("NO");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			
			loginMember = new MemberVo();
			loginMember.setNo(no);
			loginMember.setId(id);
			loginMember.setPwd(pwd);
			loginMember.setNick(nick);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return loginMember;
	}

	//정보 수정
	public int edit(Connection conn, MemberVo vo) throws Exception {

		//2. SQL
		String sql = "UPDATE MEMBER SET PWD = ? , NICK = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getPwd());
		pstmt.setString(2, vo.getNick());
		pstmt.setString(3, vo.getNo());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	//회원조회 . no
	public MemberVo selectOneByNo(Connection conn, String no) throws Exception {

		//SQL
		String sql = "SELECT * FROM MEMBER WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		MemberVo updatedMember = null;
		if(rs.next()) {
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			
			updatedMember = new MemberVo();
			updatedMember.setNo(no);
			updatedMember.setId(id);
			updatedMember.setPwd(pwd);
			updatedMember.setNick(nick);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return updatedMember;
	}

}//class













