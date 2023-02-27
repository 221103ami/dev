package com.kh.app.main;

import java.util.Scanner;

import com.kh.app.member.MemberController;

public class Main {
	
	public static final Scanner SC = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("MVC ~~~");
		
		//메뉴
		System.out.println("1. 회원가입");
		
		//입력
		String input = SC.nextLine();
		
		//회원가입 실행
		MemberController mc = new MemberController();
		
		try {
			mc.join();
		} catch (Exception e) {
			System.out.println("회원가입 하다가 오류 발생함 ~~~~~ !!!!!");
			e.printStackTrace();
		}
		
	}

}
