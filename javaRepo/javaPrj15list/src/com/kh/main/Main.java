package com.kh.main;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("===== list =====");
		
		KhList list = new KhList();
		
		list.add(11);
		list.add(22);
		list.add(33);
		list.add(44444);
		
		int temp = list.get(2);
		System.out.println(temp);

	}//main

}//class































