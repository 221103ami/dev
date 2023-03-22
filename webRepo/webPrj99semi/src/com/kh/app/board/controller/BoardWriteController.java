package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet {
	
	//게시글 작성 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(req, resp);
	}
	
	//게시글 작성
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//인코딩
		//req.setCharacterEncoding("UTF-8");
		
		//데이터 꺼내기
		String writer = req.getParameter("writer");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		//데이터 뭉치기
		BoardVo vo = new BoardVo();
		vo.setWriter(writer);
		vo.setTitle(title);
		vo.setContent(content);
		
		int result = 0;
		try {
			//서비스 호출
			BoardService bs = new BoardService();
			result = bs.write(vo);
		}catch(Exception e) {
			System.out.println("[ERROR] 게시글 작성 중 예외발생 ...");
			e.printStackTrace();
		}
		
		//화면
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "게시글 작성 성공!");
			resp.sendRedirect("/");
		}else {
			req.getSession().setAttribute("alertMsg", "게시글 작성 실패 ...");
			resp.sendRedirect("/");
		}
		
	}

}//class





























