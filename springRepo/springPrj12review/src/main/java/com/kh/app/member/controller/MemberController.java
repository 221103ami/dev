package com.kh.app.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.app.member.vo.MemberVo;

@Controller
public class MemberController {
	
	@RequestMapping("hello")
	@ResponseBody
	public String m01(MemberVo vo) {
		System.out.println(vo);
		return "hi~~~";
	}

}
















