package com.kh.app.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@WebServlet("/board/search")
public class BoardSearchController extends HttpServlet {
	
	//검색
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//인코딩
			req.setCharacterEncoding("UTF-8");
			
			//데꺼
			String titleValue = req.getParameter("titleValue");
			String contentValue = req.getParameter("contentValue");
			String writerValue = req.getParameter("writerValue");
			
			//데뭉
			Map<String, String> map = new HashMap<>();
			map.put("titleValue", titleValue);
			map.put("contentValue", contentValue);
			map.put("writerValue", writerValue);
			
			System.out.println(map);
			
			//서비스
			BoardService service = new BoardService();
			List<BoardVo> list = service.searchList(map);
			
			System.out.println(list);
			
			//화면
			req.setAttribute("bvoList", list);
			req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
			
		}catch(Exception e) {
			System.out.println("[ERROR] search errrr.....");
			e.printStackTrace();
			
			req.getRequestDispatcher("errrpageeeee").forward(req, resp);
		}
		
	}

}//class

















