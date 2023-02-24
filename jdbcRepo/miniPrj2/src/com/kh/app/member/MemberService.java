package com.kh.app.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.main.Main;
import com.kh.app.util.JDBCTemplate;

public class MemberService {
	
	//회원가입
	public void join() throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//입력받기 
		System.out.print("아이디 : ");
		String id = Main.SC.nextLine();
		System.out.print("비번 : ");
		String pwd = Main.SC.nextLine();
		System.out.print("닉네임 : ");
		String nick = Main.SC.nextLine();
		
		//SQL
		String sql = "INSERT INTO MEMBER(NO,ID,PWD,NICK) VALUES(SEQ_MEMBER_NO.NEXTVAL,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		pstmt.setString(3, nick);
		int result = pstmt.executeUpdate();
		
		//result , tx
		if(result == 1) {
			System.out.println("성공!");
			conn.commit();
		}else {
			System.out.println("실패..");
		}
		
		//close
		conn.close();
		
	}
	
	//로그인
	public void login() throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//입력받기
		System.out.print("아이디 : ");
		String inputId = Main.SC.nextLine();
		System.out.print("패스워드 : ");
		String inputPwd = Main.SC.nextLine();
		
		//SQL
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, inputId);
		pstmt.setString(2, inputPwd);
		ResultSet rs = pstmt.executeQuery();
		
		//result //rs -> var -> obj
		if(rs.next()) {
			String no = rs.getString("NO");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			String enrollDate = rs.getString("ENROLL_DATE");
			String quitYn = rs.getString("QUIT_YN");
			
			MemberVo vo = new MemberVo();
			vo.setNo(no);
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setNick(nick);
			vo.setEnrollDate(enrollDate);
			vo.setQuitYn(quitYn);
			
			System.out.println("-----로그인 성공-----");
			System.out.println(vo);
		}else {
			System.out.println("로그인 실패..");
		}
		
		//close
		conn.close();
	}//method
	
	//비번변경
	public void update() throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//입력받기
		System.out.print("회원번호 : ");
		String no = Main.SC.nextLine();
		System.out.print("비밀번호 : ");
		String pwd = Main.SC.nextLine();
		
		//SQL
		String sql = "UPDATE MEMBER SET PWD = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, pwd);
		pstmt.setString(2, no);
		int result = pstmt.executeUpdate();
		
		//result (tx)
		if(result == 1) {
			System.out.println("성공");
			conn.commit();
		}else {
			System.out.println("실패");
		}
		
		//close
		conn.close();
		
	}
	
	//탈퇴
	public void delete() throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//입력받기
		System.out.print("삭제할 회원 번호 : ");
		String num = Main.SC.nextLine();
		
		//SQL
		String sql = "DELETE MEMBER WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, num);
		int result = pstmt.executeUpdate();
		
		//result (tx)
		if(result == 1) {
			System.out.println("성공!");
			conn.commit();
		}else {
			System.out.println("실패");
		}
		
		//close
		conn.close();
		
	}

}//class



















