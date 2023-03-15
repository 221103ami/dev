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
import javax.servlet.http.HttpSession;

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
		
		//데이터 뭉치기
		MemberVo paramVo = new MemberVo();
		paramVo.setId(memberId);
		paramVo.setPwd(memberPwd);
		
		//로그인 서비스 처리
		MemberService service = new MemberService();
		MemberVo loginMember = service.login(paramVo);
		
		//view
		if(loginMember != null) {
			HttpSession s = req.getSession();
			s.setAttribute("loginMember", loginMember);
			resp.sendRedirect("/app22");
		}else {
			req.setAttribute("errorMsg", "로그인 실패 ...");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}

}//class


























