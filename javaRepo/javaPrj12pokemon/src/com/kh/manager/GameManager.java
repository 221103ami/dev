package com.kh.manager;

import java.util.Scanner;

import com.kh.mob.Ggobuki;
import com.kh.mob.Pairi;
import com.kh.mob.Pikachu;
import com.kh.mob.Pokemon;

public class GameManager {

	Pokemon[] mobArr = new Pokemon[3];
	Pokemon user;
	Pokemon enemy;
	
	public void gameStart() {
		// 몬스터 생성 및 정보출력
		generateMob();
		
		// 유저가 몹 선택
		selectMob();
		
		// 컴퓨터 몹 선택
		selectEnemy();
		
		// 배틀
		BattleManager bm = new BattleManager();
		bm.startBattle(user, enemy);
	}
	
	private void generateMob() {
		mobArr[0] = new Pikachu();
		mobArr[1] = new Pairi();
		mobArr[2] = new Ggobuki();
		
		printMobInfo(mobArr);
	}

	private void printMobInfo(Pokemon[] mobArr) {
		for(Pokemon mob : mobArr) {
			System.out.println(mob);
		}
	}
	
	//유저가 포켓몬 선택
	private void selectMob() {
		System.out.print("원하시는 포켓몬 번호를 입력하세요");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		user = mobArr[num-1];
		System.out.println("선택한 포켓몬 : " + user);
	}
	
	//컴퓨터 포켓몬 선택
	private void selectEnemy() {
		int random = (int)(Math.random() * mobArr.length);
		enemy = mobArr[random];
		System.out.println("적 포켓몬 : " + enemy);
	}
	

}//class


























