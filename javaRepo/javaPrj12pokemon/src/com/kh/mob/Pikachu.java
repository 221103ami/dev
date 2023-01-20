package com.kh.mob;

public class Pikachu extends Pokemon {
	
	public Pikachu() {
		name = "피카츄";
		hp = 100;
		atk = 30;
		def = 10;
	}
	
	public void bodyAttack() {
		bodyAttack(name);
	}
	
	public void skill() {
		System.out.println("백만볼트!!!");
	}

}
