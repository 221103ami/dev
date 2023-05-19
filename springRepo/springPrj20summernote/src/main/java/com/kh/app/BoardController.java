package com.kh.app;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	
	//ajax 로 들어오는 파일 업로드 요청 처리
	@PostMapping("upload")
	@ResponseBody
	public String upload(List<MultipartFile> file , HttpServletRequest req) throws Exception {
		System.out.println(file.get(0));
		
		MultipartFile f = file.get(0);
		
		String path = req.getServletContext().getRealPath("/img/");
		File target = new File(path + "abc.png");
		
		f.transferTo(target);
		
		return "ok";
	}
}




















