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
		
		//데이터
		if(vo.getHobby() != null) {
			String hobbyStr = String.join(",", vo.getHobby());
			vo.setHobbyStr(hobbyStr);
		}
		
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
	
	//정보수정 화면
	//정보수정
	
	//회원탈퇴
	

}

























