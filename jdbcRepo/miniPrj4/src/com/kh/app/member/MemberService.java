package com.kh.app.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.kh.app.template.JDBCTemplate;

//비지니스 로직
public class MemberService {

	//회원가입
	public int join(MemberVo vo) throws Exception {
		
		//비지니스 로직 (유효성 검사)
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//SQL
		MemberDao dao = new MemberDao();
		int result = dao.join(conn, vo);
		
		//result
		if(result == 1) {
			//성공 로직 (+tx)
			conn.commit();
		}else {
			//실패 로직 (+tx)
			conn.rollback();
		}
		
		//close
		conn.close();	//가져온곳에서 close
		
		return result;
	}

}





















