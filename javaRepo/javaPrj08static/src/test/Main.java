package test;

public class Main {
	
	static int cnt = 3;

	public static void main(String[] args) {
		
		System.out.println("main called...");
		
		// 사람 객체 생성 (값 채워서)
		Person p = new Person("심원용" , 20);
		// 객체의 모든 정보 출력
		System.out.println(p);
		
		// 강아지 객체 생성 (값 채워서)
		Dog d = new Dog("푸들" , 2);
		// 객체의 모든 정보 출력
		System.out.println(d);
		
		// 고양이 객체 생성 (값 채워서)
		Cat c = new Cat("페르시안" , 3);
		// 객체의 모든 정보 출력
		System.out.println(c);
		
		System.out.println("=================");
		
		System.out.println(Main.cnt);
		

	}//main

}//class






















