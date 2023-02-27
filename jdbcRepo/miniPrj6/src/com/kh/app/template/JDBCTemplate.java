package com.kh.app.template;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {
	
	public static Connection getConnection() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "MINI";
		String pwd = "1234";
		Connection conn = DriverManager.getConnection(url, id, pwd);
		conn.setAutoCommit(false);
		return conn;
	}

}
