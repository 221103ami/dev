package com.kh.app19.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		req.getRequestDispatcher("/WEB-INF/views/member/joinForm.jsp").forward(req, resp);
	}
	
	//회원가입
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		
		//비지니스 로직 (중복검사, 유효성검사, insert)
		
		//커넥션 준비 (드라이버 , conn 객체 url,id,pwd)
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "MINI";
		String pwd = "1234";
		
		int result = 0;
		try {
			Connection conn = DriverManager.getConnection(url, id, pwd);
			
			//SQL
			String sql = "INSERT INTO MEMBER(NO, ID, PWD) VALUES(SEQ_MEMBER_NO.NEXTVAL, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPwd);

			//결과
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("비지니스 로직 실행 중 예외 발생~~~");
			e.printStackTrace();
		}
		
		//결과에 따라 처리 (문자열 내보내기)
		if(result == 1) {
			req.setAttribute("memberId", memberId);
			req.getRequestDispatcher("/WEB-INF/views/member/joinSuccess.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("실패페이지JSP").forward(req, resp);
		}
		
	}//method
	
}




















