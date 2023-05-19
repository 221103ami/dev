package com.kh.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		int result = bs.write(vo);
		if(result == 1) {
			return "successPage";
		}else {
			return "errorPage";
		}
	}
	
	//게시글 조회하기 (화면)
	@GetMapping("detail")
	public String detail(Model model) {
		
		BoardVo vo = bs.getBoard();
		model.addAttribute("vo" , vo);
		
		return "detail";
	}
	
}




















