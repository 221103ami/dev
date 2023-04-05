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
			ss.commit();
		}else {
			ss.rollback();
		}
		
		//4. close
		ss.close();
		
		return result;
	}//method

	//로그인
	public MemberVo login(MemberVo vo) throws Exception {
		
		//1. conn
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		MemberDao dao = new MemberDao();
		MemberVo loginMember = dao.login(ss , vo);
		
		//4. close
		ss.close();
		
		System.out.println("마이바티스로 로그인한 결과 : " + loginMember);
		return loginMember;
	}

	//정보 수정
	public MemberVo edit(MemberVo vo) throws Exception {
		
		//1. conn
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		MemberVo updatedMember = null;
		try {
			
			MemberDao dao = new MemberDao();
			int result = dao.edit(ss , vo);
			
			//3. tx || rs
			if(result == 1) {
				updatedMember = dao.selectOneByNo(ss, vo.getNo());
				if(updatedMember == null) {
					ss.rollback();
					throw new Exception();
				}
				ss.commit();
			}else {
				ss.rollback();
			}
			
		}finally {
			//4. close
			ss.close();
		}
		
		return updatedMember;
	}//method

	//탈퇴하기
	public int quit(String no) {
		//conn
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		//SQL
		MemberDao dao = new MemberDao();
		int result = dao.quit(ss , no);
		
		//tx || rs
		if(result == 1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		
		//close
		ss.close();
		
		return result;
	}
	

}//class













