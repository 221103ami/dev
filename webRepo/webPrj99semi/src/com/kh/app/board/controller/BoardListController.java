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
	
	//게시글 목록 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//데이터 꺼내기
		
		//데이터 뭉치기
		
		List<BoardVo> boardList = null;
		try {
			//서비스 호출
			BoardService bs = new BoardService();
			boardList = bs.selectList();
		}catch(Exception e) {
			System.out.println("[ERROR] 게시글 조회 중 예외 발생 ...");
			e.printStackTrace();
		}
		
		//화면
		System.out.println(boardList);
		
		req.setAttribute("boardList", boardList);
		req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}











