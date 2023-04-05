package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/quit")
public class MemberQuitController extends HttpServlet {

	//회원탈퇴
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			//데이터
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			String no = loginMember.getNo();
			
			//서비스
			MemberService ms = new MemberService();
			int result = ms.quit(no);
			
			//화면
			if(result == 1) {
				resp.sendRedirect("/app01/home");
			}else {
				throw new Exception();
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR] 탈퇴 중 예외 발생 ...");
			e.printStackTrace();
			
			req.setAttribute("errirMsg", "errrrr~~");
			req.getRequestDispatcher("errorpageeeee~~~").forward(req, resp);
		}
		
	}//method
	
}//class























