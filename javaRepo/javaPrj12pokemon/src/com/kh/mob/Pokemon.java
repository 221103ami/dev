package com.kh.mob;

public abstract class Pokemon {
	
	protected String name;
	protected int hp;
	protected int atk;
	protected int def;
	
	public abstract void bodyAttack();
	
	public abstract void skill();
	
	public void bodyAttack(String name) {
		System.out.println(name + " 의 몸통박치기!!!");
	}

	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", hp=" + hp + ", atk=" + atk + ", def=" + def + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	

	
	

}//class























