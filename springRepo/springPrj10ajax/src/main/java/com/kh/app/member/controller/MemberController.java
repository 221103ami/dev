package com.kh.app.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("member")
public class MemberController {
	
	//회원가입 화면
	@GetMapping("join")
	public void join() {
		
	}
	
	//회원가입
	
	//중복검사	//아이디 받아서, 디비에 있는지 검사하고 중복여부 리턴하는 메소드
	@PostMapping("idCheck")
	@ResponseBody
	public String idCheck(String mid) {
		
		//서비스
		int result = 0;	//service.~~~(mid);	//
				
		//화면
		if(result > 0) {	
			//중복 ㅇㅇ
			return "good";
		}else {
			//중복 ㄴㄴ
			return "bad";
		}
		
	}

}//class



























