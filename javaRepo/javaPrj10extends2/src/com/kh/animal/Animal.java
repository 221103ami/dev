package com.kh.animal;

public abstract class Animal {
	
	public Animal(String type , int age) {
		this.type = type;
		this.age = age;
	}

	public String type;
	public int age;
	
	public void eat() {
		System.out.println("밥먹음");
	}
	
	public abstract void cry();
	
}






















