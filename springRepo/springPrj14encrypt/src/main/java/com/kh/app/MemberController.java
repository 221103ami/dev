package com.kh.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
	
	private final MemberService ms;
	
	@Autowired
	public MemberController(MemberService ms) {
		this.ms = ms;
	}

	//회원가입 (화면)
	@GetMapping("join")
	public String join() {
		return "join";
	}
	
	//회원가입
	@PostMapping("join")
	@ResponseBody
	public String join(@RequestParam Map<String, String> paramMap) {
		
		int result = ms.join(paramMap);
		
		if(result == 1) {
			return "ok";
		}else {
			return "fail...";
		}
		
	}
	
	
	//로그인 (화면)
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	//로그인
	@PostMapping("login")
	@ResponseBody
	public String login(@RequestParam Map<String, String> paramMap) {
		Map<String, String> memberMap = ms.login(paramMap);
		return memberMap.get("ID") + " 님 로그인 성공 !";
	}
	
	

}






















