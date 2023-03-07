package com.kh.app12.main.test;

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
		System.out.println("서비스 메소드 호출됨 ~~~");
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		System.out.println(id);
		System.out.println(pwd);
		
		PrintWriter out = resp.getWriter();
		out.write("join success !!");
	}

}





















