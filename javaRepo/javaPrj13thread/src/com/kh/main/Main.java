package com.kh.main;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		//새로운 쓰레드 만들기
		Thread t01 = new Thread(() -> {
			String name2 = Thread.currentThread().getName();
			System.out.println("[" + name2 + "] run method called ~~~");
		});
		t01.setName("내가만든쓰레드");
		t01.start();	//쓰레드 만들어지고 일 함
		
		
		
		
		//메인쓰레드 가져오기
		Thread t = Thread.currentThread();
		
		//메인쓰레드 이름 가져오기
		String name = t.getName();
		
		//메인쓰레드 재우기
		t.sleep(3000);
		
		//메인쓰레드가 1 ~ 10 까지 출력하기
		for(int i = 1 ; i <= 10; ++i) {
			System.out.println("[" + name + "]" + i);
		}
		
		
//		Runnable m = new Runnable() {
//			@Override
//			public void run() {
//				String name = Thread.currentThread().getName();
//				System.out.println("[" + name + "] run method called ~~~");
//			}
//		};
		
		
		
	}//main

}//class
































