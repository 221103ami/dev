package com.kh.app.member.controller;

import com.kh.app.common.annotation.KhController;
import com.kh.app.common.annotation.KhGetMapping;

@KhController
public class MemberController {
	
	@KhGetMapping
	public String login() {
		System.out.println("login called ~~~");
		return "member/login";
	}

}
