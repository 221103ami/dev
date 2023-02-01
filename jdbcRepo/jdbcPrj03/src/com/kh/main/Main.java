package com.kh.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws Exception {
		
		System.out.println("====JDBC=====");
		
		//JDBC
		Connection conn = null;
		
		String id = "KH";
		String pwd = "KH";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		//DB 커넥션 객체 생성
		
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection(url , id , pwd);
		
		String sql = "INSERT INTO MEMBER(ID, PWD, NICK) VALUES('SWY', '1234', '1DRAGON')";
		
		Statement stmt = conn.createStatement();
		int result = stmt.executeUpdate(sql);
		System.out.println("result : " + result);
		
		conn.close();

	}//main

}//class


























