package com.kh.app.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.app.jdbc.JDBCTemplate;
import com.kh.app.main.Main;

public class MemberService {
	
	//회원가입 (==DB 에 insert)
	public void join() throws Exception {
		
		//디비 연결 == 커넥션 객체얻기
		Connection conn = JDBCTemplate.getConnection();
		
		//입력받기
		System.out.print("아이디 : ");
		String memberId = Main.SC.nextLine();
		System.out.print("패스워드 : ");
		String memberPwd = Main.SC.nextLine();
		System.out.print("닉네임: ");
		String memberNick = Main.SC.nextLine();
		
		//SQL 실행
		String sql = "INSERT INTO MEMBER(NO,ID,PWD,NICK) VALUES(SEQ_MEMBER_NO.NEXTVAL,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberId);
		pstmt.setString(2, memberPwd);
		pstmt.setString(3, memberNick);
		int result = pstmt.executeUpdate();
		
		//실행결과에 따라 처리
		if(result == 1) {
			System.out.println("회원가입 성공!");
		}else {
			System.out.println("회원가입 실패!");
		}
		
	}
	
	//로그인
	public void login() {
		
	}
	
	//수정
	public void edit() {
		
	}
	
	//삭제
	public void quit() {
		
	}
	
	//회원 목록조회
	public void selectList() {
		
	}
	
	
	

}//class



























