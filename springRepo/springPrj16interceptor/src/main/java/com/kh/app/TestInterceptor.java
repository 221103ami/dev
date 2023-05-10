package com.kh.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//public class TestInterceptor extends HandlerInterceptorAdapter {
public class TestInterceptor implements HandlerInterceptor {

	// 언제 ? 컨트롤러 가기 전
	// 핸들러 : 컨트롤러의 메소드
	// 리턴값 : true 면 통과 , false 면 차단
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle 호출됨 ...");
		System.out.println(handler);
		return true;
	}

	//언제 ? 컨트롤러 갔다와서
	//파라미터에 모델앤뷰 추가됨
	//리턴값은 없음
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle 호출됨 ~~~ (컨트롤러 다녀옴)");
	}

	//언제? 화면 만들기 전
	//예외 객체 확인 가능 (예외 없으면 null 나옴)
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion 호출됨 ...");
		System.out.println(ex);
	}

	
	
}









