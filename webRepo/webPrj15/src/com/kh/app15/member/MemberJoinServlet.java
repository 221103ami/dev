package com.kh.app15.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/join")
public class MemberJoinServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		
		//비지니스 로직
		System.out.println(memberId);
		System.out.println(memberPwd);
		
		//결과
		int result = 1;
		
		//문자열 내보내기 (==화면 선택)
		if(result == 1) {
			req.setAttribute("x", memberId);
			req.getRequestDispatcher("/joinSuccess.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("실패시 보여줄 JSP 경로").forward(req, resp);
		}
		
	}

}






















