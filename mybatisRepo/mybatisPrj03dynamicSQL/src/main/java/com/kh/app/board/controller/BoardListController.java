package com.kh.app.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {

	//게시글 화면
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			//데이터
			
			//서비스
			BoardService service = new BoardService();
			List<BoardVo> list = service.selectBoardList();
			
			//화면
			req.setAttribute("bvoList", list);
			req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
			
		}catch(Exception e) {
			System.out.println("[ERROR] list errrr....");
			e.printStackTrace();
			
			req.getRequestDispatcher("errirpageeeee~~").forward(req, resp);
		}
		
	}
	
}//class


















