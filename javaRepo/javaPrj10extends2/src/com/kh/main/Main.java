package com.kh.main;

import com.kh.animal.Dog;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("main called...");
		
		Dog obj = new Dog("포메라니안", 3);
		System.out.println(obj.type);
		System.out.println(obj.age);

	}//main

}//class



















