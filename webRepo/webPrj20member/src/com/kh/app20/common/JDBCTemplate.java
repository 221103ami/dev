package com.kh.app20.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {
	
	// 커넥션 얻기
	public static Connection getConnection() {
		
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "MINI";
			String pwd = "1234";
			conn = DriverManager.getConnection(url , id, pwd);
			
		} catch (Exception e) {
			System.out.println("[ERROR] 커넥션 준비중 에러 발생...");
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	//close
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
				
		}
	}

}














