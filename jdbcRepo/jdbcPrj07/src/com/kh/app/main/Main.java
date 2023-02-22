package com.kh.app.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//회원가입 (DB insert)
		
		//DB 연결(드라이버 준비 , 커넥션얻기)
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "MINI";
		String pwd = "1234";
		Connection conn = DriverManager.getConnection(url,id,pwd);
		
		//SQL
		String sql = "INSERT INTO MEMBER(NO, ID, PWD, NICK) VALUES(SEQ_MEMBER_NO.NEXTVAL,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "user1440");
		pstmt.setString(2, "1234");
		pstmt.setString(3, "nick1440");
		pstmt.execute();
		
		//정리
		conn.close();
		
		System.out.println("정상적으로 종료됨...");
		

	}

}

























