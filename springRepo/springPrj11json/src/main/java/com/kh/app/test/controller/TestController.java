package com.kh.app.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class TestController {
	
	@RequestMapping("test")
	@ResponseBody
	public String test() {
		
		MemberVo vo = new MemberVo();
		vo.setId("user01");
		vo.setPwd("1234");
		vo.setNick("nick01");
		
		Gson gson = new Gson();
		String str = gson.toJson(vo);
		
		return str;
	}
}















