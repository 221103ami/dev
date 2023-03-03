package com.kh.app07.temp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	
//	public HelloServlet() {
//		System.out.println("서블릿 객체 생성됨 ~~");
//	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nick = req.getParameter("nick");
		
		System.out.println(nick + " 헬로 ~~~");
	}
	
}













