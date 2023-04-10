package com.kh.app.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService ms;
	
	//회원가입 화면
//	@RequestMapping(value = "member/join" , method = RequestMethod.GET)
	@GetMapping("member/join")
	public String join() {
		return "member/join";
	}
	
	//회원가입
	@PostMapping("member/join")
	public String join(MemberVo vo) throws Exception {
		
		//서비스
		int result = ms.join(vo);
		
		//화면
		if(result != 1) {
			return "common/error-page";
		}
		
		return "redirect:/app/home";
	}
	

}//class





















