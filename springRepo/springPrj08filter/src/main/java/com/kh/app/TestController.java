package com.kh.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("test")
	public void test(String msg) {
		System.out.println("전달받은 메세지 : " + msg);
	}

}













