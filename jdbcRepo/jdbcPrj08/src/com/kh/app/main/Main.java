package com.kh.app.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws Exception {
		
		System.out.println("zzz");
		
		//DB 연결 (드라이버 준비 , 커넥션 얻기)
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "MINI";
		String pwd = "1234";
		Connection conn = DriverManager.getConnection(url, id, pwd);
		
		//SQL
		String sql = "INSERT INTO MEMBER(NO, ID, PWD, NICK) VALUES(SEQ_MEMBER_NO.NEXTVAL,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "user1500");
		pstmt.setString(2, "1234");
		pstmt.setString(3, "nick1500");
		int result = pstmt.executeUpdate();
		
		//결과 확인
		if(result == 1) {
			System.out.println("회원가입 성공!");
		}else {
			System.out.println("회원가입 실패...");
		}
		
		//정리
		conn.close();
		
	}

}
