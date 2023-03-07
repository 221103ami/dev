package com.kh.app13.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join")
public class MemberJoinServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		//비지니스 로직
		System.out.println(id);
		System.out.println(pwd);
		
		//결과 응답
		PrintWriter out = resp.getWriter();
		out.write("<h1 style=\"color:red;\">join success !!!</h1>");
		
	}
	
}
























