package com.kh.game;

import com.kh.main.Main;

public class Games {
	
	public void startUpDown() {
		
		//정답설정
		int answer = (int) (Math.random() * 100 + 1);
		
		while(true) {
			//입력받기
			System.out.print("1 ~ 100 사이의 정수를 입력하세요");
			int user = Main.SC.nextInt();
			
			//판단하기
			if(user == answer) {
				System.out.println("정답입니다 ~ !");
				break;
			}else if(user < answer) {
				System.out.println("UP");
			}else {
				System.out.println("DOWN");
			}
		}//while
		
		
	}

}//class






















