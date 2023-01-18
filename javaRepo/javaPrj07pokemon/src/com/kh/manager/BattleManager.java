package com.kh.manager;

import com.kh.mob.Pokemon;

public class BattleManager {
	
	public boolean battle(Pokemon attack , Pokemon deffender) {
		
		attack.attack(); 
		deffender.setHp( deffender.getHp() - attack.getAtk() );
		System.out.println(deffender.getName() + " 의 남은체력 : " + deffender.getHp());
		if(deffender.getHp() <= 0) {
			System.out.println(attack.getName() + " 승리 !!!");
			//break;
			return true;
		}else {
			return false;
		}
		
	}//method

}//class
