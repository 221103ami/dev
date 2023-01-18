package com.kh.person;

public class Person {
	
	private String name;
	private int age;
	
	//age 게터 / 세터
	public int getAge() {
		return age-1;
	}

	public void setAge(int age) {
		if(this.age > age) {
			System.out.println("값 확인좀");
			return ;
		}
		this.age = age;
	}
	
	//name 게터 / 세터
	public void setName(String name) {
		this.name = name;
	}
	
	

	public String getName() {
		return this.name;
	}

	public String toString() {
		return "이름은 " + name + ", 나이는 " + age;
	}
	
}//class
