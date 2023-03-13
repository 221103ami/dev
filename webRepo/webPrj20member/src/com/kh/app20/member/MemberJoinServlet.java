package com.kh.app20.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/join")
public class MemberJoinServlet extends HttpServlet {
	
	//회원가입 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//문자열 내보내기 == JSP한테 요청 위임하기
		req.getRequestDispatcher("/WEB-INF/views/member/joinForm.jsp").forward(req, resp);
	}
	
	//회원가입 (디비에 insert)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		String memberNick = req.getParameter("memberNick");
		
		//커넥션 준비 (드라이버 , conn)
		Connection conn = null;
		int result = 0;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "MINI";
			String pwd = "1234";
			conn = DriverManager.getConnection(url , id, pwd);
			
			//SQL
			String sql = "INSERT INTO MEMBER(ID, PWD, NICK) VALUES(?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPwd);
			pstmt.setString(3, memberNick);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//결과 (tx , 자원정리)
		result = 0;	//테스트를 위해 추가함. 이따가 지울거.
		if(result == 1) {
			//성공 (commit , 성공 안내메세지)
//			req.getRequestDispatcher("/").forward(req, resp);
			resp.sendRedirect("/app20/index.html");
		}else {
			//실패 (rollback , 실패 안내메세지)
			req.setAttribute("msg", "회원가입 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}

}





























