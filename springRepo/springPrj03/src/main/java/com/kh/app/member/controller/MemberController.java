package com.kh.app.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService ms;
	
	//회원가입 화면
	@GetMapping("member/join")
	public String join() {
		return "join";
	}
	
	//회원가입
	@PostMapping("member/join")
	public String m02(MemberVo vo) {
		
		//확인
		System.out.println(vo);
		
		//서비스
		//int result = ms.join(vo);
		int result = 1;
		
		//화면
		if(result == 1) {
			return "home";
		}else {
			return "error";
		}
	}
	
}










