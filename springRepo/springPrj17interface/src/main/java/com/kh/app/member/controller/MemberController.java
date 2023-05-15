package com.kh.app.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@Controller
@RequestMapping("member")
public class MemberController {
	
	private final MemberService ms;

	@Autowired
	public MemberController(MemberService ms) {
		this.ms = ms;
	}
	
	@PostMapping("join")
	public String join(MemberVo vo) {
		
		int result = ms.join(vo);
		
		return "~~~결과페이지 ~~~";
	}
	

}














