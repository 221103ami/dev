package com.kh.main;

import java.util.Scanner;

import com.kh.game.Games;

public class Main {
	
	public static final Scanner SC = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Games games = new Games();
		
		System.out.println("===== 미니게임 =====");
		
		System.out.println("1. 가위바위보");
		System.out.println("2. 구구단");
		System.out.println("3. 업다운");
		
		System.out.print("원하는 게임을 선택하세요");
		int gameNum = SC.nextInt();
		
		switch(gameNum) {
		case 1 : /* games.구구단게임시작(); */ break;
		case 2 : /* games.가위바위보게임시작(); */ break;
		case 3 : games.startUpDown(); break;
		default : System.out.println("잘못 입력하셨습니다.");
		}
		
		
	}//main 

	
	
}//class
























