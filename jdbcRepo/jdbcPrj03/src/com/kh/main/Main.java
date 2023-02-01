package com.kh.main;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

	public static void main(String[] args) throws Exception {
		
		System.out.println("====JDBC=====");
		
		//JDBC
		Connection conn = null;
		
		String id = "kh";	//대문자로 변경해야됨... 근데 잘 되는지 궁금하니까 테스트,,,
		String pwd = "kh";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		//DB 커넥션 객체 생성
		
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection(url , id , pwd);
		
		

	}//main

}//class


























