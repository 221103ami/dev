package com.kh.main;

import com.kh.animal.Animal;
import com.kh.animal.Cat;
import com.kh.animal.Dog;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("=====상속=====");
		
		// 강아지 객체 생성
		// 강아지 품종 값 입력
		// 강아지 품종 출력
		
//		Dog d = new Dog();
////		d.setType("비숑");
//		System.out.println(d.getType());
//		d.cry();
//
//		Cat c = new Cat();
//		c.type = "페르시안";
//		System.out.println(c.type);
//		c.cry();
		
		Dog d = new Dog();
		d.setCurrnetType("자식값변경ㅋㅋ");
		System.out.println( d.getCurrentType() );
		System.out.println( d.getParentType() );
		
		
	}//main

}//class

















