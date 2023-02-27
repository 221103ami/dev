package com.kh.app.main;

import java.util.Scanner;

import com.kh.app.member.MemberController;

public class Main {
	
	public static final Scanner SC = new Scanner(System.in);

	public static void main(String[] args) {
		
		MemberController mc = new MemberController();
		
		System.out.println("======");
		
		//메뉴
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 비번변경");
		System.out.println("4. 회원탈퇴");
		
		//입력
		String input = SC.nextLine();
		
		//서비스 실행
		switch(input) {
		case "1" : mc.join(); break;
		case "2" :  break;
		case "3" :  break;
		case "4" :  break;
		}
		

	}

}






















