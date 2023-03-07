package com.kh.app11.main.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("서블릿의 서비스메소드 호출됨 ...");
		
		//클라이언트가 보낸 데이터 확인
		String num = req.getParameter("num");
		System.out.println(num);
		
		//응답
		PrintWriter out = resp.getWriter();
		out.write("<h1 style=\"background-color:red;\">hello ~~~</h1>");
	}

}//class

















