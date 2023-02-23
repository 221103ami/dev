package com.kh.app.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {
	
	//커넥션 얻기
	public static Connection getConnection() throws Exception {
		/*
		 * 1. 드라이버 준비
		 * 2. 커넥션 얻기 (==getConnection)
		 * */
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "MINI";
		String password = "1234";
		Connection conn = DriverManager.getConnection(url , username, password);
		conn.setAutoCommit(false);
		return conn;
	}

}


















