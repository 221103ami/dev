package com.kh.app.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.app.member.vo.MemberVo;

@Controller
public class MemberController {
	
	//회원가입 화면
//	@RequestMapping(value = "member/join" , method = RequestMethod.GET)
	@GetMapping("member/join")
	public String join() {
		return "member/join";
	}
	
	//회원가입
	@PostMapping("member/join")
	public String join(MemberVo vo) {
		
		System.out.println("전달받은 데이터 : " + vo);
		
		return "회원가입성공페이지";
	}
	

}//class





















