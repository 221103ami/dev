package com.kh.app.message.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.message.service.MessageService;

@WebServlet("/message/write")
public class MessageWriteController extends HttpServlet {

	//작성 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/message/writeForm.jsp").forward(req, resp);
	}
	
	//작성
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			//데이터
			String msg = req.getParameter("msg");
			
			//서비스
			MessageService service = new MessageService();
			int result = service.write(msg);
			
			//화면
			if(result == 1) {
				resp.sendRedirect("/app02/home");
			}else {
				throw new Exception();
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR] 에러 ㅋㅋ");
			e.printStackTrace();

			req.setAttribute("emsg", "ㅠㅠㅠ");
			req.getRequestDispatcher("errr~~~.jsp").forward(req, resp);
		}
		
	}//method
	
	
}









