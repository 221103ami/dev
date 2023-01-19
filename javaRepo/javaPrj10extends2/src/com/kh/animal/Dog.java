package com.kh.animal;

public class Dog extends Animal {
	
	public Dog(String type , int age) {
		super(type, age);
	}
	
	//생성자 (부모 의 type , age 초기화)
//	public Dog(String type , int age) {
//		this.type = type;
//		this.age = age;
//	}


	@Override
	public void cry() {
		System.out.println("멍멍!");
	}
	
}
