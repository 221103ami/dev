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

@WebServlet("/member/quit")
public class MemberQuitServlet extends HttpServlet {
	
	//회원탈퇴 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/quitForm.jsp").forward(req, resp);
	}
	
	//화면탈퇴
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			//SQL
			String sql = "DELETE FROM MEMBER WHERE ID = ? AND PWD = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPwd);
			result = pstmt.executeUpdate();
			
			//tx , close
			if(result == 1) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
		}catch(Exception e) {
			JDBCTemplate.rollback(conn);
			System.out.println("[ERROR] 회원 탈퇴 예외 발생 ...");
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
		}
		
		//view
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "탈퇴 성공!");
			resp.sendRedirect("/app22");
		}else {
			req.setAttribute("errorMsg", "탈퇴 실패 ...");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}

}//class























