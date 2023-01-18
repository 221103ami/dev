package com.kh.main;

import com.kh.person.Person;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("main ~~~");
		
		Person p = new Person();
		
		p.setName("심원용");
		System.out.println(p.getName());
		
		p.setAge(20);
		System.out.println(p.getAge());
		
		p.setAge(3);
		System.out.println(p.getAge());
		
		

	}//main

}//class


































