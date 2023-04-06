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

	//게시글 작성 화면 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(req, resp);
	} 
	
	//게시글 작성
	// INSERT INTO BOARD(NO, TITLE, CONTENT , WRITER) VALUES(SEQ_BOARD_NO.NEXTVAL , ? , ? , 1)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			//데꺼
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			//데뭉
			BoardVo boardVo = new BoardVo();
			boardVo.setTitle(title);
			boardVo.setContent(content);
			
			//서비스
			BoardService boardService = new BoardService();
			int result = boardService.write(boardVo);
			
			//화면
			if(result == 1) {
				resp.sendRedirect("/app03/board/list");
			}else {
				throw new Exception();
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR] write error occured..");
			e.printStackTrace();
			
			req.getRequestDispatcher("er~~page~~~").forward(req, resp);
		}
		
	}
	
}//class










