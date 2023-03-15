package com.kh.app.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.util.JDBCTemplate;

@WebServlet("/member/edit")
public class MemberEditServlet extends HttpServlet {

	//회원 수정 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//로그인여부 검사 == 세션에 loginMember 라는 어트리뷰트가 있는지?
		MemberVo loginMember = (MemberVo)req.getSession().getAttribute("loginMember");
		if(loginMember != null) {
			req.getRequestDispatcher("/WEB-INF/views/member/editForm.jsp").forward(req, resp);
		}else {
			req.getSession().setAttribute("alertMsg", "로그인 후 이용하세요!");
			resp.sendRedirect("/app22");
		}
		
	}
	
	//회원 수정
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		String memberNick = req.getParameter("memberNick");
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			//SQL
			String sql = "UPDATE MEMBER SET NICK = ? WHERE ID = ? AND PWD = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberNick);
			pstmt.setString(2, memberId);
			pstmt.setString(3, memberPwd);
			result = pstmt.executeUpdate();
			
			//tx,close
			if(result == 1) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
		}catch(Exception e) {
			JDBCTemplate.rollback(conn);
			System.out.println("[ERROR] 회원정보 수정 예외 발생...");
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
		}
		
		//view
		if(result == 1) {
			resp.sendRedirect("/app22");
		}else {
			req.setAttribute("errorMsg", "정보 수정 실패 ...");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
		
	}//method
	
}//class

























