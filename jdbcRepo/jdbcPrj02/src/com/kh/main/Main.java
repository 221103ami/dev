package com.kh.main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		System.out.println("===== 회원가입 및 로그인 =====");
		
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		
		String input = MemberInput.SC.nextLine();
		
		if("1".equals(input)) {
			//회원가입 ~~~
			MemberData data = new MemberInput().joinInput();
			new MemberService().join(data);
		}else if("2".equals(input)) {
			//로그인 ~~~
			MemberData data = new MemberInput().loginInput();
			new MemberService().login(data);
		}

	}//main

}//class



































