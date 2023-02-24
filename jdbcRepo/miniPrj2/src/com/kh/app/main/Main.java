package com.kh.app.main;

import java.util.Scanner;

import com.kh.app.member.MemberService;

public class Main {
	
	public static final Scanner SC = new Scanner(System.in); 

	public static void main(String[] args) throws Exception {
		
		System.out.println("=============");
		
		MemberService ms = new MemberService();
		
		//메뉴
		MemberMenu memberMenu = new MemberMenu();
		memberMenu.showMenu();
		
		//입력받기
		String input = SC.nextLine();
		
		//서비스 실행
		switch(input) {
		case "1" : ms.join(); break;
		case "2" : ms.login(); break;
		case "3" : ms.update(); break;
		case "4" : ms.delete(); break;
		}

	}//main

}//class
















