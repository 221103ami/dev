package com.kh.app.member.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.JDBCTemplate;

public class MemberService {

	//회원가입
	public int join(MemberVo vo) throws Exception {

		//1. conn
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		//2. SQL
		MemberDao dao = new MemberDao();
		int result = dao.join(ss , vo);
		
		//3. tx || rs
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//4. close
		JDBCTemplate.close(conn);
		
		return result;
	}//method

	//로그인
	public MemberVo login(MemberVo vo) throws Exception {
		
		//1. conn
		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao dao = new MemberDao();
		MemberVo loginMember = dao.login(conn , vo);
		
		//4. close
		JDBCTemplate.close(conn);
		
		return loginMember;
	}

	//정보 수정
	public MemberVo edit(MemberVo vo) throws Exception {
		
		//1. conn
		Connection conn = JDBCTemplate.getConnection();
		
		MemberVo updatedMember = null;
		try {
			
			MemberDao dao = new MemberDao();
			int result = dao.edit(conn , vo);
			
			//3. tx || rs
			if(result == 1) {
				updatedMember = dao.selectOneByNo(conn, vo.getNo());
				if(updatedMember == null) {
					JDBCTemplate.rollback(conn);
					throw new Exception();
				}
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
		}finally {
			//4. close
			JDBCTemplate.close(conn);
		}
		
		return updatedMember;
	}//method
	

}//class













