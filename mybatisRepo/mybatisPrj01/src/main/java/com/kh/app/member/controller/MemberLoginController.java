package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet {

	//로그인 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/loginForm.jsp").forward(req, resp);
	}
	
	//로그인
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			//데이터 꺼내기
			String memberId = req.getParameter("memberId");
			String memberPwd = req.getParameter("memberPwd");
			
			//데이터 뭉치기
			MemberVo vo = new MemberVo();
			vo.setId(memberId);
			vo.setPwd(memberPwd);

			//서비스 호출
			MemberService ms = new MemberService();
			MemberVo loginMember = ms.login(vo);
			
			//화면
			if(loginMember != null) {
				req.getSession().setAttribute("loginMember", loginMember);
				resp.sendRedirect("/app01/home");
			}else {
				throw new Exception();
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR] 로그인 중 예외 발생 ...");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "errrorrrrr ....");
			req.getRequestDispatcher("error~~~page~~~").forward(req, resp);
		}
		
	}
	
	
}//class

