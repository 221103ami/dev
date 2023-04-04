package com.kh.app.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class JDBCTemplate {
	
	// SqlSession 얻기
	public static SqlSession getSqlSession() {
		
		SqlSession ss = null;
		try {
			String resource = "/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			ss = sqlSessionFactory.openSession(false);
		}catch(Exception e) {
			System.out.println("[ERROR] 마이바티스 연결 중 예외 발생 ...");
			e.printStackTrace();
		}
		
		return ss;
	}
   
	
	
	
   // conn 
   public static Connection getConnection() {
      
      Connection conn = null;
      try {
         // 드라이버 , url,id,pwd , autoCommit
         Class.forName("oracle.jdbc.OracleDriver");
         
         String url = "jdbc:oracle:thin:@localhost:1521:xe";
         String id = "SEMI";
         String pwd = "1234";
         conn = DriverManager.getConnection(url , id, pwd);
         conn.setAutoCommit(false);
         
      }catch(Exception e) {
         System.out.println("[ERROR] 커넥션 가져오는 중 에러 발생...");
         e.printStackTrace();
      }finally {
         
      }
      return conn;
   }
   
   //commit
   public static void commit(Connection conn) {
      try {
         if(conn != null && !conn.isClosed()) {
            conn.commit();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   //rollback
   public static void rollback(Connection conn) {
      try {
         if(conn != null && !conn.isClosed()) {
            conn.rollback();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   //close (conn)
   public static void close(Connection conn) {
      try {
         if(conn != null && !conn.isClosed()) {
            conn.close();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   //close (stmt)
   public static void close(Statement stmt) {
      try {
         if(stmt != null && !stmt.isClosed()) {
            stmt.close();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   //close (rs)
   public static void close(ResultSet rs) {
      try {
         if(rs != null && !rs.isClosed()) {
            rs.close();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
}//class


















