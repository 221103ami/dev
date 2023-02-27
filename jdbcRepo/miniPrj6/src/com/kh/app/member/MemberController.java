package com.kh.app.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.kh.app.main.Main;
import com.kh.app.template.JDBCTemplate;

//데이터 받기
//데이터 뭉치기
//서비스 호출
public class MemberController {
	
	//회원가입
	public void join() throws Exception {
		
		//데이터 받기
		System.out.print("아이디 : ");
		String memberId = Main.SC.nextLine();
		System.out.print("패스워드 : ");
		String memberPwd = Main.SC.nextLine();
		System.out.print("닉네임 : ");
		String memberNick = Main.SC.nextLine();
		
		//데이터 뭉치기
		MemberVo vo = new MemberVo();
		vo.setId(memberId);
		vo.setPwd(memberPwd);
		vo.setNick(memberNick);
		
		//서비스 호출
		MemberService ms = new MemberService();
		ms.join(vo);
		
	}
	
	//로그인
	
	//비번변경
	
	//탈퇴

}
