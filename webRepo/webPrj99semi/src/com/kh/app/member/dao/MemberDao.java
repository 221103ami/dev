package com.kh.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.JDBCTemplate;

public class MemberDao {

	//회원가입
	public int join(Connection conn, MemberVo vo) throws Exception {
		
		//SQL (close)
		
		String sql = "INSERT INTO MEMBER(NO , ID , PWD , NICK , HOBBY) VALUES(SEQ_MEMBER_NO.NEXTVAL , ? , ? , ? , ? )";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		pstmt.setString(3, vo.getNick());
		pstmt.setString(4, vo.getHobby());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	
	//로그인
	public MemberVo login(Connection conn, MemberVo vo) throws Exception {
		
		//SQL (close)
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND QUIT_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		ResultSet rs = pstmt.executeQuery();
		
		//rs -> obj
		MemberVo loginMember = null;
		if(rs.next()) {
			String no = rs.getString("NO");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			String hobby = rs.getString("HOBBY");
			String enrollDate = rs.getString("ENROLL_DATE");
			
			loginMember = new MemberVo();
			loginMember.setNo(no);
			loginMember.setId(id);
			loginMember.setPwd(pwd);
			loginMember.setNick(nick);
			loginMember.setHobby(hobby);
			loginMember.setEnrollDate(enrollDate);
		}
		
		return loginMember;
		
	}
	
	

}





