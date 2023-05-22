package com.kh.app.common.advice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice(annotations = Controller.class)
public class ErrorProcessor {

	@ExceptionHandler(Exception.class)
	public String errorAdvice(Exception e , Model model) {
		log.error(e.toString());
		model.addAttribute("errorMsg" , e.getMessage());
		return "common/error-page";
	}
	
	
	
}





















