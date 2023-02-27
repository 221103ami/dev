package com.kh.app.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.kh.app.template.JDBCTemplate;

public class MemberService {
	
	public void join(MemberVo vo) throws Exception {
		// 유효성 검사 ~~~ 등등 .... ~~~~~

		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//SQL
		MemberDao dao = new MemberDao();
		int result = dao.join(conn, vo);
		
		//결과 (+tx)
		if(result == 1) {
			//성공 ~~~
			System.out.println("성공!");
			conn.commit();
		}else {
			//실패 ~~~
			System.out.println("실패..");
			conn.rollback();
		}
		
		//정리
		conn.close();
	}

}
