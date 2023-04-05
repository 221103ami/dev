package com.kh.app.message.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.message.service.MessageService;

@WebServlet("/message/del")
public class MessageDelController extends HttpServlet {
	
	//삭제 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/message/delForm.jsp").forward(req, resp);
	}
	
	//삭제
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			//데이터
			String msg = req.getParameter("msg");
			
			//서비스
			MessageService service = new MessageService();
			int result = service.del(msg);
			
			//화면
			if(result == 1) {
				resp.sendRedirect("/app02/home");
			}else {
				throw new Exception();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}//class


















