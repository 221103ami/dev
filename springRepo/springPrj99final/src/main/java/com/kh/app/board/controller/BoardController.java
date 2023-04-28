package com.kh.app.board.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.common.file.FileUploader;
import com.kh.app.common.file.FileVo;
import com.kh.app.common.page.PageVo;
import com.kh.app.member.vo.MemberVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	public String getBoardList(@RequestParam(defaultValue = "1") int page ,@RequestParam Map<String , String> searchMap, Model model) {
		
		//데이터
		int listCount = bs.getCnt(searchMap);
		int currentPage = page;
		int pageLimit = 5;
		int boardLimit = 10;
		PageVo pv = new PageVo(listCount, currentPage, pageLimit, boardLimit);
		
		//서비스
		List<BoardVo> bvoList = bs.getBoardList(pv, searchMap);
		List<Map<String, String>> cvoList = bs.getCategoryList();
		
		//화면
		model.addAttribute("cvoList" , cvoList);
		model.addAttribute("searchMap" , searchMap);
		model.addAttribute("pv" , pv);
		model.addAttribute("bvoList" , bvoList);
		return "board/list";
	}
	
	// 작성하기 (화면)
	@GetMapping("write")
	public String write() {
		return "board/write";
	}
	
	// 작성하기
	@PostMapping("write")
	public String write(BoardVo vo , List<MultipartFile> f , HttpSession session , HttpServletRequest req) throws Exception {
		
		//로그인 여부 체크
		MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
		if( loginMember == null ) {
			throw new Exception("로그인 후 이용 가능합니다.");
		}
		
		//데이터 준비 (파일)
		String path = req.getServletContext().getRealPath("/resources/upload/board/");
		List<String> changeNameList = FileUploader.upload(f, path);
		List<String> originNameList = FileUploader.getOriginNameList(f);
		
		//데이터 준비 (이름 리스트)
		List<FileVo> fvoList = new ArrayList<FileVo>();
		int size = changeNameList.size();
		for (int i = 0; i < size; i++) {
			FileVo fvo = new FileVo();
			fvo.setOriginName(originNameList.get(i));
			fvo.setChangeName(changeNameList.get(i));
			fvoList.add(fvo);
		}
		
		
		//데이터 준비 (카테고리)
		if("없음".equals(vo.getCategoryNo())) {
			vo.setCategoryNo(null);
		}
		vo.setWriterNo(loginMember.getNo());
		
		int result = bs.write(vo , fvoList);
		if( changeNameList != null && result < 1 ) {	//근데,, 사진 첨부 안하면?? 실패임??? 일단 킾 ,,,
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
		model.addAttribute("path" , "resources/upload/board");
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






