package com.kh.main;

import java.util.Scanner;

public class MemberInput {
	
	public static final Scanner SC = new Scanner(System.in);
	
	public MemberData joinInput() {
		System.out.print("아이디 : ");
		String id = SC.nextLine();
		System.out.print("패스워드 : ");
		String pwd = SC.nextLine();
		System.out.print("닉네임 : ");
		String nick = SC.nextLine();
		MemberData data = new MemberData(id, pwd, nick);
		return data;
	}
	
	public MemberData loginInput() {
		System.out.print("아이디 : ");
		String id = SC.nextLine();
		System.out.print("패스워드 : ");
		String pwd = SC.nextLine();
		return new MemberData(id, pwd , null);
	}

}//class


























