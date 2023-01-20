package com.kh.mob;

public class Ggobuki extends Pokemon {
	
	public Ggobuki() {
		name = "꼬부기";
		hp = 100;
		atk = 25;
		def = 15;
	}
	
	public void bodyAttack() {
		bodyAttack("꼬부기");
	}
	
	@Override
	public void skill() {
		System.out.println("물대포!!!");
	}

}
