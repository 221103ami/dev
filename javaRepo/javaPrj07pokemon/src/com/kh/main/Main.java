package com.kh.main;

import com.kh.manager.BattleManager;
import com.kh.mob.Pokemon;

public class Main {

	public static void main(String[] args) {
		System.out.println("=====포켓몬=====");
		
		Pokemon p1 = new Pokemon("피카츄" , 100, 30);
		Pokemon p2 = new Pokemon("파이리" , 85, 33);
		
		System.out.println(p1);
		System.out.println(p2);
		
		Pokemon user = p1;
		Pokemon enemy = p2;
		 
		BattleManager bm = new BattleManager();
		boolean isFinish;
		while(true) {
			isFinish = bm.battle(user , enemy);
			if(isFinish) { break; }
			
			isFinish = bm.battle(enemy , user);
			if(isFinish) { break; }
		}//while

	}//main
	
	

}//class



























