package com.kh.app.notice.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.member.vo.MemberVo;
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
	
	//공지사항 작성하기 화면 (관리자만)
	@GetMapping("write")
	public String write(HttpSession session , Model model) {
		MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
		if(loginMember == null) {
			model.addAttribute("errorMsg" , "잘못된 접근입니다.");
			return "common/error-page";
		}
		String id = loginMember.getId();
		boolean isAdmin = "ADMIN".equals(id);
		
		if(!isAdmin) {
			model.addAttribute("errorMsg" , "잘못된 접근입니다.");
			return "common/error-page";
		}
		
		return "notice/write";
	}
	
	//공지사항 작성하기 (관리자만)
	@PostMapping("write")
	public String write(NoticeVo vo , HttpSession session) {
		
		int result = ns.write(vo);
		
		if(result == 1) {
			session.setAttribute("alertMsg", "공지사항 작성 완료!!!");
		}else {
			session.setAttribute("alertMsg", "공지사항 작성 실패...");
		}
		
		return "redirect:/notice/list";
	}
	
	//공지사항 상세조회
	@GetMapping("detail")
	public String detail(String num , Model model) {
		
		NoticeVo vo = ns.getNotice(num);
		
		if(vo == null) {
			model.addAttribute("errorMsg", "조회 실패...");
			return "common/error-page";
		}
		
		model.addAttribute("vo" , vo);
		return "notice/detail";
	}
	
	//공지사항 수정하기 (관리자만)
	@PostMapping("edit")
	public String edit(NoticeVo vo , Model model , HttpSession session) {
		int result = ns.edit(vo);
		
		if(result != 1) {
			model.addAttribute("errorMsg", "수정실패 ...");
			return "common/error-page";
		}
		
		session.setAttribute("alertMsg", "수정 성공!!!");
		return "redirect:/notice/detail?num=" + vo.getNo();
	}
	
	//공지사항 삭제하기 (관리자만)
	
}








