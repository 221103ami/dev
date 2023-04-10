package com.kh.app.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@RequestMapping("test")
	public String m01() {
		System.out.println("test called... ~~~ !!!");
		return "join-form";
	}

}
