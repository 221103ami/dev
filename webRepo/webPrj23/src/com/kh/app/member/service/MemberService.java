package com.kh.app.member.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.JDBCTemplate;

public class MemberService {
	
	//회원가입 
	public int join(MemberVo vo) throws Exception {
		
		//비지니스 로직 ~~~
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//SQL (DAO)
		MemberDao dao = new MemberDao();
		int result = dao.join(conn , vo);
		
		//tx , close
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	//로그인
	public MemberVo login(MemberVo vo) throws Exception {
		//비지니스 로직
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//SQL (DAO)
		MemberDao dao = new MemberDao();
		MemberVo loginMember = dao.login(conn , vo);
		
		//tx , close
		if(loginMember != null) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return loginMember;
		
	}

	//회원 탈퇴
	public int quit(MemberVo loginMember) {
		
		//비지니스 로직
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//SQL (DAO)
		MemberDao dao = new MemberDao();
		int result = dao.quit(conn , loginMember);
		
		//tx , close
		
		
	}

}//class
























