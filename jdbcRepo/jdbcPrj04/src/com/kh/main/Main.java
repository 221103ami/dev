package com.kh.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("~~~");
		
		//연결 준비 (드라이버 등록, 접속정보 준비)
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "KH";
		String pwd = "KH";
		
		Class.forName(driver);
		
		//디비 연결(url,id,pwd) == 커넥션 객체 얻기
		Connection conn = DriverManager.getConnection(url, id, pwd);
		
		//유저입력받기
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : ");
		String memberId = sc.nextLine();
		System.out.print("패스워드 : ");
		String memberPwd = sc.nextLine();
		System.out.print("닉네임 : ");
		String memberNick = sc.nextLine();
		
		//쿼리문 준비
//		String sql = "INSERT INTO MEMBER(ID,PWD,NICK) VALUES('" + memberId + "','" + memberPwd + "','" + memberNick + "')";
		String sql = "INSERT INTO MEMBER(ID,PWD,NICK) VALUES(?,?,?)";
		
		//쿼리문 실행 (stmt 이용해서)
//		Statement stmt = conn.createStatement();
//		stmt.execute(sql);
		
		//쿼리문 실행 (pstmt 이용해서)
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberId);
		pstmt.setString(2, memberPwd);
		pstmt.setString(3, memberNick);
		pstmt.execute();
		
		//커넥션 반납
		conn.close();
	}//main

}












