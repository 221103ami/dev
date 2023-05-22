package com.kh.app.interceptor.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.app.member.vo.MemberVo;

public class AdminChecker implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
		if(loginMember == null) {
			throw new IllegalStateException("로그인 하고오세요");
		}
		String no = loginMember.getNo();
		if(!"1".equals(no)) {
			throw new IllegalStateException("관리자만 가능");
		}
		
		return true;
	}
	
	

}



















