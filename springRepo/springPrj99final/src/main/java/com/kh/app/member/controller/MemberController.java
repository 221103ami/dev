package com.kh.app.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("member")
@Slf4j
public class MemberController {
	
	private final MemberService ms;
	
	@Autowired
	public MemberController(MemberService x) {
		this.ms = x;
	}

	//회원가입 화면
	@GetMapping("join")
	public void join() {
		log.trace("join called... ~~~");
	}
	
	//회원가입 
	@PostMapping("join")
	public String join(MemberVo vo , HttpServletRequest req , HttpSession session , Model model) throws Exception {
		
		//서비스
		int result = ms.join(vo);
		
		if(result != 1) {
			//에러메세지 담아서
			model.addAttribute("errorMsg" , "회원가입 실패...");
			return "common/error-page";
		}
		
		session.setAttribute("alertMsg", "회원가입 성공!");
		return "redirect:/home";
	}
	
	//아이디 중복확인
	@RequestMapping("id-check")
	@ResponseBody
	public String idCheck(String id) {
		
		int result = ms.checkId(id);
		
		if(result > 0) {
			return "isDup";
		}else {
			return "notDup";
		}
		
	}
	
	//로그인
	//SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND STATUS = 'O'
	@PostMapping("login")
	public String login(MemberVo vo , HttpSession session) {
		
		//서비스
		MemberVo loginMember = ms.login(vo);
		
		if(loginMember == null) {
			session.setAttribute("alertMsg", "로그인 실패 ... ");
		}
		
		//화면
		session.setAttribute("loginMember", loginMember);
		return "redirect:/home";
		
	}
	
	//로그아웃
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}
	
	//정보수정 화면
	@GetMapping("edit")
	public String edit(HttpSession session , Model model) {
		if(session.getAttribute("loginMember") == null) {
			model.addAttribute("errorMsg" , "로그인 먼저 해주세요");
			return "common/error-page";
		}
		return "member/edit";
	}
	
	//정보수정
	@PostMapping("edit")
	public String edit(MemberVo vo , Model model , HttpSession session) throws Exception {
		//서비스
		MemberVo updatedMember = ms.edit(vo);
		
		//화면
		if(updatedMember == null) {
			model.addAttribute("errorMsg" , "정보 수정 실패 ...");
			return "common/error-page";
		}
		
		session.setAttribute("loginMember", updatedMember);
		session.setAttribute("alertMsg", "정보 수정 성공 !!!");
		return "redirect:/home";
		
	}
	
	//회원탈퇴
	@RequestMapping("quit")
	public String quit(HttpSession session) {
		
		//데이터
		MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
		String no = loginMember.getNo();
		
		//서비스
		int result = ms.quit(no);
		
		//화면
		if(result == 1) {
			session.invalidate();
		}else {
			session.setAttribute("alertMsg", "회원탈퇴 실패...");
		}
		return "redirect:/home";
		
	}
	

}

























