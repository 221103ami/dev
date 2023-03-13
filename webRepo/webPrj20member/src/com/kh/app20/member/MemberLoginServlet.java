package com.kh.app20.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app20.common.JDBCTemplate;

@WebServlet("/member/login")
public class MemberLoginServlet extends HttpServlet {
	
	//로그인 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
	}
	
	//로그인 (select)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		
		// 커넥션 준비
		Connection conn = JDBCTemplate.getConnection();
		
		// SQL
		ResultSet rs = null;
		MemberVo vo = null;
		try {
			String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPwd);
			rs = pstmt.executeQuery();
			
			// 결과 (tx , 자원정리)
			if(rs.next()) {
				String id = rs.getString("ID");
				String pwd =rs.getString("PWD");
				String nick = rs.getString("NICK");
				
				vo = new MemberVo();
				vo.setMemberId(id);
				vo.setMemberPwd(pwd);
				vo.setMemberNick(nick);
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR] 로그인 진행중 에러 발생 ...");
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		// 문자열 내보내기
		if(vo != null) {
			// 로그인 성공
			System.out.println("로그인 성공");
		}else {
			// 로그인 실패
			System.out.println("로그인 실패");
		}
		
	}

}
























