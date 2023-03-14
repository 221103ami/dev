package com.kh.app.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.util.JDBCTemplate;

@WebServlet("/member/login")
public class MemberLoginServlet extends HttpServlet {

	//로그인 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/loginForm.jsp").forward(req, resp);
	}
	
	//로그인
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		try {
			
			//SQL (rs -> obj)
			String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPwd);
			ResultSet rs = pstmt.executeQuery();
			
			
			//result (tx , close)
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
			
		}catch(Exception e) {
			System.out.println("[ERROR] 로그인 중 예외 발생 ...");
			e.printStackTrace();
		}finally{
			
		}
		
		
		
		//view
		
	}
	
}//class




























