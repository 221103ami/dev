package com.kh.app07.temp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/plus")
public class PlusServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String num1 = req.getParameter("num1");
		String num2 = req.getParameter("num2");
		
		System.out.println(num1);
		System.out.println(num2);
		
		System.out.println("플러스 ~~~");
		
	}
	
}






















