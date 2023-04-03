package com.kh.app.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/test")
public class TestController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("test 경로로 요청을 받았음 ~~~");
		
		PrintWriter out = resp.getWriter();
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h1>");
		out.write("HEELO ZZZ");
		out.write("</h1>");
		out.write("</body>");
		out.write("</html>");
		
	}

}

























