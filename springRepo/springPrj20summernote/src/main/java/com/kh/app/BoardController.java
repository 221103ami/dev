package com.kh.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
	
	private BoardService bs;
	
	@Autowired
	public BoardController(BoardService bs) {
		this.bs = bs;
	}

	//게시글 작성하기 (화면)
	@GetMapping("write")
	public String write() {
		return "write";
	}
	
	//게시글 작성하기
	@PostMapping("write")
	public String write(BoardVo vo) {
		
		//디비에 인서트
		int result = bs.write(vo);
		
		//결과에 따라 화면 처리
		if(result == 1) {
			return "성공페이지";
		}else {
			return "errorPage";
		}
	}
	
}




















