package test;

public class Dog {
	
	private String type;
	private int age;
	
	public Dog() {
		
	}
	
	public Dog(String type, int age) {
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
	
	public String toString() {
		return "Dog [type=" + type + ", age=" + age + "]";
	}
	
	

}
