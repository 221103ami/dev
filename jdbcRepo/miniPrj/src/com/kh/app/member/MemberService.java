package com.kh.app.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.jdbc.JDBCTemplate;
import com.kh.app.main.Main;

public class MemberService {
	
	private final MemberPrinter mp = new MemberPrinter();
	
	//회원가입 (==DB 에 insert)
	public void join() throws Exception {
		
		//디비 연결 == 커넥션 객체얻기
		Connection conn = JDBCTemplate.getConnection();
		
		//입력받기
		System.out.print("아이디 : ");
		String memberId = Main.SC.nextLine();
		System.out.print("패스워드 : ");
		String memberPwd = Main.SC.nextLine();
		System.out.print("닉네임: ");
		String memberNick = Main.SC.nextLine();
		
		//SQL 실행
		String sql = "INSERT INTO MEMBER(NO,ID,PWD,NICK) VALUES(SEQ_MEMBER_NO.NEXTVAL,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberId);
		pstmt.setString(2, memberPwd);
		pstmt.setString(3, memberNick);
		int result = pstmt.executeUpdate();
		
		//실행결과에 따라 처리
		if(result == 1) {
			System.out.println("회원가입 성공!");
			conn.commit();
		}else {
			System.out.println("회원가입 실패!");
		}
		
		//정리
		conn.close();
		
	}
	
	//로그인
	public void login() throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//입력받기
		System.out.print("아이디 :");
		String id = Main.SC.nextLine();
		System.out.print("비밀번호 :");
		String pwd = Main.SC.nextLine();
		
		//sql
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		ResultSet rs = pstmt.executeQuery();
		
		//result
		if( rs.next() ) {
			//결과 꺼내기
			String no = rs.getString("NO");
			String memberId = rs.getString("ID");
			String memberPwd = rs.getString("PWD");
			String memberNick  = rs.getString("NICK");
			
			System.out.println("---로그인 성공! (유저 정보)---");
			//결과 출력
			MemberData data = new MemberData();
			data.setNo(no);
			data.setId(memberId);
			data.setPwd(memberPwd);
			data.setNick(memberNick);
			
			mp.printMember(data);
			
			//로그인 정보 기억하기
			Main.loginMember = data;
			
		}else {
			System.out.println("로그인 실패...");
		}
		
		//close
		conn.close();
		
	}
	
	//수정
	public void edit() throws Exception {
		
		if(Main.loginMember == null) {
			System.out.println("로그인을 먼저 해주세요");
			return;
		}
		
		//현재 유저 정보 출력 (마이페이지)
		mp.printMember(Main.loginMember);
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//입력받기
		System.out.print("변경할 비밀번호 : ");
		String pwd = Main.SC.nextLine();
		
		//sql
		String sql = "UPDATE MEMBER SET PWD = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, pwd);
		pstmt.setString(2, Main.loginMember.getNo());
		int result = pstmt.executeUpdate();
		
		//result
		if(result == 1) {
			System.out.println("수정 성공!");
			conn.commit();
		}else {
			System.out.println("수정 실패...");
		}
		
		//close
		conn.close();
		
	}
	
	//삭제
	public void quit() throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//회원번호 입력받기 (나중에 수정해야됨,,,, 현재 로그인한 회원번호 이용해서 탈퇴)
		System.out.print("탈퇴할 회원 번호 : ");
		String num_ = Main.SC.nextLine();
		int num = Integer.parseInt(num_);
		
		//sql
		String sql = "DELETE MEMBER WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, num);
		int result = pstmt.executeUpdate();
		
		//result
		if(result == 1) {
			System.out.println("탈퇴 성공");
			conn.commit();
		}else {
			System.out.println("탈퇴 실패");
		}
		
		//close
		conn.close();
	}
	
	//회원 목록조회
	public void selectList() throws Exception {
		
		//DB
		Connection conn = JDBCTemplate.getConnection();
		
		//sql
		String sql = "SELECT * FROM MEMBER";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//result
		while(rs.next()) {
			String no = rs.getString("NO");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			String enrollDate = rs.getString("ENROLL_DATE");
			String quitYn = rs.getString("QUIT_YN");
			
			//출력
			MemberData data = new MemberData();
			data.setNo(no);
			data.setId(id);
			data.setPwd(pwd);
			data.setNick(nick);
			data.setEnrollDate(enrollDate);
			data.setQuitYn(quitYn);
			
			mp.printMember(data);
		}
		
		//close
		conn.close();
	}
	
	
	

}//class



























