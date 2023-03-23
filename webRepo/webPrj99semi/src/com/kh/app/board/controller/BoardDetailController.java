package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@WebServlet("/board/detail")
public class BoardDetailController extends HttpServlet {

	//게시글 상세 조회
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//데이터 꺼내기
			String no = req.getParameter("no");
			
			//데이터 뭉치기
			
			//서비스 호출
			BoardService bs = new BoardService();
			BoardVo vo = bs.selectOne(no);

			System.out.println(vo);	//테스트용 . 내일 지울예정.
			
			//화면
			req.setAttribute("boardVo", vo);
			req.getRequestDispatcher("/WEB-INF/views/board/detail.jsp").forward(req, resp);
			
		}catch(Exception e) {
			System.out.println("[ERROR] 게시글 상세조회중 예외 발생 ...");
			e.printStackTrace();
		}
		
	}//method
	
}//class

























