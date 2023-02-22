package com.kh.app.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws Exception {
		
		System.out.println("회원가입진행~~~");
		
		//커넥션 얻기 (드라이버 준비, 커넥션객체얻기)
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "MINI";
		String pwd = "1234";
		Connection conn = DriverManager.getConnection(url , id, pwd);
		
		//SQL 실행
		String sql = "INSERT INTO MEMBER(NO, ID, PWD, NICK) VALUES(SEQ_MEMBER_NO.NEXTVAL,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "user999");
		pstmt.setString(2, "1234");
		pstmt.setString(3, "닉네임ㅋㅋ");
		pstmt.execute();
		
		conn.close();
		System.out.println("종료");
	}//main

}






















