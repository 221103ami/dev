package test;

public class Cat {
	
	private String type;
	private int age;
	public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cat(String type, int age) {
		super();
		this.type = type;
		this.age = age;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Cat [type=" + type + ", age=" + age + "]";
	}
	
	

}
