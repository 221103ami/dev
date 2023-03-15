package com.kh.app.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kh.app.util.JDBCTemplate;

public class MemberDao {
	
	//회원가입 (Member 테이블에 insert)
	public int join(Connection conn , MemberVo vo) {
		
		//SQL
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO MEMBER(ID, PWD, NICK) VALUES(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getNick());
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			JDBCTemplate.rollback(conn);
			System.out.println("[ERROR] 회원가입 진행중 예외 발생");
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}//join 
	
	
	
	//로그인
	public MemberVo login(Connection conn , MemberVo vo) {
		//SQL
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo loginMember = null;
		try {
			String sql = "SELECT ID , PWD, NICK FROM MEMBER WHERE ID = ? AND PWD = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbId = rs.getString("ID");
				String dbPwd = rs.getString("PWD");
				String dbNick = rs.getString("NICK");
				
				loginMember = new MemberVo();
				loginMember.setId(dbId);
				loginMember.setPwd(dbPwd);
				loginMember.setNick(dbNick);
			}
		}catch(Exception e) {
			System.out.println("[ERROR] 로그인 중 예외 발생...");
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return loginMember;
	}//method

}//class






















