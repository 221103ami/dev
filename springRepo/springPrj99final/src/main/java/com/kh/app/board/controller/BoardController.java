package com.kh.app.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.common.page.PageVo;
import com.kh.app.member.vo.MemberVo;

@Controller
@RequestMapping("board")
public class BoardController {
	
	private final BoardService bs;
	
	@Autowired
	public BoardController(BoardService bs) {
		this.bs = bs;
	}

	// 목록조회
	@GetMapping("list")
	public String getBoardList(@RequestParam(defaultValue = "1") int page , Model model) {
		
		//데이터
		int listCount = bs.getCnt();
		int currentPage = page;
		int pageLimit = 5;
		int boardLimit = 10;
		PageVo pv = new PageVo(listCount, currentPage, pageLimit, boardLimit);
		
		//서비스
		List<BoardVo> bvoList = bs.getBoardList(pv);
		
		//화면
		model.addAttribute("bvoList" , bvoList);
		return "board/list";
	}
	
	// 작성하기
	@PostMapping("write")
	public String write(BoardVo vo) throws Exception {
		int result = bs.write(vo);
		if(result != 1) {
			throw new Exception("게시글 작성 실패 ...");
		}
		return "redirect:/board/list";
	}
	
	// 상세조회 (조회수)
	@GetMapping("detail")
	public String detail(String no , Model model) throws Exception {
		BoardVo vo = bs.getBoard(no);
		if(vo == null) {
			throw new Exception("게시글 상세 조회 실패 ...");
		}
		model.addAttribute("bvo" , vo);
		return "board/detail";
	}
	
	// 수정하기 (작성자 본인만)
	@PostMapping("edit")
	public String edit(BoardVo vo , RedirectAttributes ra) throws Exception {
		int result = bs.updateBoard(vo);
		
		if(result != 1) {
			throw new Exception("수정 실패 ...");
		}
		
		ra.addFlashAttribute("alertMsg" , "수정하기 성공!");
		ra.addAttribute("no" , vo.getNo());
		return "redirect:/board/detail";
	}
	
	// 삭제하기 (작성자 본인만)
	@GetMapping("delete")
	public String delete(BoardVo vo , HttpSession session) throws Exception {
		
		MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
		String writerNo = loginMember.getNo();
		vo.setWriterNo(writerNo);
		
		int result = bs.delete(vo);
		
		if(result != 1) {
			throw new Exception("삭제 실패...");
		}
		
		session.setAttribute("alertMsg", "삭제 성공!");
		return "redirect:/board/list";
	}
	

}






