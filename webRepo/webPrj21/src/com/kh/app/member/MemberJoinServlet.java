package com.kh.app.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.util.JDBCTemplate;

@WebServlet("/member/join")
public class MemberJoinServlet extends HttpServlet {
	
	//회원가입 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/joinForm.jsp").forward(req, resp);
	}
	
	//회원가입 (insert)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		String memberNick = req.getParameter("memberNick");
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		int result = 0;
		try {
			
			// SQL
			String sql = "INSERT INTO MEMBER(ID,PWD,NICK) VALUES(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPwd);
			pstmt.setString(3, memberNick);
			result = pstmt.executeUpdate(); 
			
			// result (tx , close)
			if(result == 1) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
		}catch(Exception e) {
			JDBCTemplate.rollback(conn);
			System.out.println("[ERROR] 회원가입 중 에러발생...");
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		// view
		if(result == 1) {
			//성공 -> 메인페이지
			HttpSession session = req.getSession();
			session.setAttribute("alertMsg", "회원가입 성공!");
			resp.sendRedirect("/app21/");
		}else {
			//실패 -> 에러페이지
			req.setAttribute("msg", "회원가입 실패...");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}

}






























