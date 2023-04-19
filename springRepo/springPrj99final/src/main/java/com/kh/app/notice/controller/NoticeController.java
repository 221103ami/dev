package com.kh.app.notice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.notice.service.NoticeService;
import com.kh.app.notice.vo.NoticeVo;

@Controller
@RequestMapping("notice")
public class NoticeController {
	
	private final NoticeService ns;
	
	@Autowired
	public NoticeController(NoticeService ns) {
		this.ns = ns;
	}

	//공지사항 목록 조회
	@GetMapping("list")
	public String list(Model model) {
		//서비스
		List<NoticeVo> nvoList = ns.getNoticeList();
		
		//화면
		model.addAttribute("nvoList", nvoList);
		return "notice/list";
	}
	
	//공지사항 상세조회
	
	//공지사항 작성하기 (관리자만)
	
	//공지사항 수정하기 (관리자만)

	//공지사항 삭제하기 (관리자만)
	
}
