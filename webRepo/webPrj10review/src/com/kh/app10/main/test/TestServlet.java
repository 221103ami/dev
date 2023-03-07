package com.kh.app10.main.test;

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
		System.out.println("서블릿 객체의 메소드 호출됨 ~~~");
		
		PrintWriter out = resp.getWriter();
		out.write("<!DOCTYPE HTML>");
		out.write("<html>");
		out.write("<h1>hellozzz</h1>");
		out.write("</html>");
	}
	
}





















