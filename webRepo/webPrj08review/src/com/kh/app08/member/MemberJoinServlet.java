package com.kh.app08.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberJoin")
public class MemberJoinServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		String memberNick = req.getParameter("memberNick");
		
		//비지니스 로직
		System.out.println(memberId);
		System.out.println(memberPwd);
		System.out.println(memberNick);
		
		//결과
		PrintWriter out = resp.getWriter();
		out.write("<html>");
		out.write("<h1>join success !</h1>");
		out.write("</html>");
		
	}//method
	
}//class


















