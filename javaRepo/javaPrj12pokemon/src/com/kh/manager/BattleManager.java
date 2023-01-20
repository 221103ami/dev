package com.kh.manager;

import com.kh.mob.Pokemon;

public class BattleManager {
	
	public void startBattle(Pokemon user , Pokemon enemy){
		
		//싸움
		boolean isFinish;
		while(true) {
			isFinish = fight(user, enemy);
			if(isFinish) { break; }
			isFinish = fight(enemy, user);
			if(isFinish) { break; }
		}//while
		
		System.out.println("----- 배틀 종료 -----");
	}//method
	
	public boolean fight(Pokemon attacker , Pokemon defender){
		attacker.bodyAttack();
		int damage = attacker.getAtk() - defender.getDef();
		defender.setHp(defender.getHp() - damage);
		
		if(defender.getHp() <= 0) {
			System.out.println(attacker.getName() + " 승리 !!!");
			return true;
		}else {
			return false;
		}
	}

}//class




























