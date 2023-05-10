package com.kh.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice(basePackages = {"com.kh.app"})
@ControllerAdvice(annotations = KhAno.class)
public class ErrorProcessor {
	
	@ExceptionHandler(NotFoundException.class)
	public String notFoundHandler() {
		System.out.println("그런거 없음");
		return "errorPage404";
	}
	
	@ExceptionHandler(Exception.class)
	public String handle01(Exception e) {
		System.out.println("예외 발생 ~~~ !");
		e.printStackTrace();
		return "errorPage";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String handle02() {
		System.out.println("NPE 발생 ~");
		return "errorPageNPE";
	}

}//class
























