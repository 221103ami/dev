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
import com.kh.app.util.page.PageVo;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	
	private BoardService bs = new BoardService();
	
	//게시글 목록 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			//데이터 꺼내기 (페이징 처리를 위한 데이터 준비)
			int currentPage = Integer.parseInt( req.getParameter("page") );
			int listCount = bs.selectCount();
			int pageLimit = 5;
			int boardLimit = 5;
			
			//데이터 뭉치기
			PageVo pageVo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
			//서비스 호출
			List<BoardVo> boardList = bs.selectList(pageVo);
			
			//화면
			System.out.println(boardList);
			
			req.setAttribute("boardList", boardList);
			req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
			
		}catch(Exception e) {
			System.out.println("[ERROR] 게시글 조회중 예외 발생 ...");
			e.printStackTrace();
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}











