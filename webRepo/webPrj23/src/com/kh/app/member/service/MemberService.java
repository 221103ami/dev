package com.kh.app.member.service;

import java.sql.Connection;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.JDBCTemplate;

public class MemberService {
	
	//회원가입 
	public int join(MemberVo vo) {
		
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

}//class
























