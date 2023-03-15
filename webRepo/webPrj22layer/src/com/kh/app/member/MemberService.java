package com.kh.app.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kh.app.util.JDBCTemplate;

public class MemberService {
	
	//회원가입 
	public int join(MemberVo vo) {
		
		//유효성 검사 ,,,, 비지니스 로직 .....
		
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//SQL
		MemberDao dao = new MemberDao();
		int result = dao.join(conn , vo);
		
		//result (tx , close)
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}//join
	
	
	
	//로그인
	public MemberVo login(MemberVo vo) {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//SQL
		MemberDao dao = new MemberDao();
		MemberVo loginMember = dao.login(conn, vo);
		
		//tx , close
		JDBCTemplate.close(conn);
		
		return loginMember;
	}//method

}//class


























