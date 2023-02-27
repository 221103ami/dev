package com.kh.app.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.kh.app.template.JDBCTemplate;

//비지니스 로직
//커넥션
//SQL 실행 (==dao 호출)
//결과 (tx)
//정리
public class MemberService {
	
	public void join(MemberVo vo) throws Exception {
		//비지니스 로직
		//유효성을 검사하는 복잡하고 긴 코드 ~~~
		
		//커넥션
		Connection conn = JDBCTemplate.getConnection();
		
		//SQL 실행 (==dao 호출)
		MemberDao dao = new MemberDao();
		int result = dao.join(conn, vo);
		
		
		//결과 (tx)
		if(result == 1) {
			//성공
			System.out.println("회원가입 성공!");
			conn.commit();
		}else {
			//실패
			System.out.println("회원가입 실패..");
			conn.rollback();
		}
		
		//정리
		conn.close();
	}

}
