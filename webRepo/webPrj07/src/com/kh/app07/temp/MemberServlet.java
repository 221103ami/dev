package com.kh.app07.temp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//클라이언트가 보낸 데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		String memberNick = req.getParameter("memberNick");
		
		//비지니스 로직
		System.out.println(memberId);
		System.out.println(memberPwd);
		System.out.println(memberNick);
		
		//결과
		//System.out.println("회원가입 완료");
		PrintWriter pw = resp.getWriter();
		pw.write("<html>");
		pw.write("<head>");
		pw.write("<style>");
		pw.write("</style>");
		pw.write("</head>");
		pw.write("<body>");
		pw.write("<h1>join success !</h1>");
		pw.write("</body>");
		pw.write("</html>");
		pw.write("<script>");
		pw.write("alert('js~~~~!!!!!')");
		pw.write("</script>");
		
	}
	
}




















