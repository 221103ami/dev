package com.kh.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@KhAno
public class TestController {
	
	@RequestMapping("*")
	public void m01() throws Exception {
		throw new NotFoundException();
	}
	
	@GetMapping(value = {"test/{num}" , "test"})
	public String test(@PathVariable(required = false) int num) throws Exception {
		
		if(num == 4) {
			throw new NullPointerException();
		}
		
		if(num <= 0) {
			throw new Exception("회원가입 에러 발생 ...");
		}
		return "test";
	}
	
	

}


















