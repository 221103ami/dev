package com.kh.mob;

public class Pairi extends Pokemon {
	
	public Pairi() {
		name = "파이리";
		hp = 100;
		atk = 33;
		def = 5;
	}
	
	public void bodyAttack() {
		bodyAttack("파이리");
	}
	
	public void skill() {
		System.out.println("파이어볼!!!");
	}
	
}
