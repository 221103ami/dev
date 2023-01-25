package com.kh.main;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("===== 예외처리 =====");
		
		Test t = new Test();
		t.m01();
		
//		try {
//			t.m02();
//		}catch(Exception e) {
//			System.out.println(e);
//		}
		
		boolean result = false;
		try {
			result = t.join("user01", "1");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("회원가입 성공 여부 : " + result);
		
		System.out.println("메인 메소드 종료");
	}//main
	
	

}//class

























