package com.kh.animal;

public class Dog extends Animal {
	
	public String type = "자식에서 넣은 글자 ~~~";
	
	// 부모 객체의 type 변수를 설정
	public void setParentType(String s) {
		super.type = s;
	}
	// 현재(자식) 객체의 type 변수를 설정
	public void setCurrnetType(String s) {
		this.type = s;
	}
	
	// 부모 객체의 type 변수를 리턴
	public String getParentType() {
		return super.type;
	}
	// 현재(자식) 객체의 type 변수를 리턴
	public String getCurrentType() {
		return this.type;
	}
	
	
	
	//부모 메소드 자식이 또 작성
	@Override
	public void cry() {
		System.out.println("멍멍!");
	}
	

}//class





















