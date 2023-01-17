package com.kh.main;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("=====메소드=====");
		
		Test t = new Test();
		
		t.hello();
		
		t.plusOne(10);
		
//		String s = t.getMyName();
//		System.out.println(s);
		
		System.out.println( t.getMyName() );
		
		int result = t.plus(10, 20);
		System.out.println(result);

	}//main

}//class











