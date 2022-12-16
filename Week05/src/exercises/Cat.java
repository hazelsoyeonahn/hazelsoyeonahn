package exercises;

public class Cat extends Animal{
	public void feed() {
		this.eat+=1;
		this.happy+=10;
	}
	public Cat() {
		super();
		System.out.println("Cat object instantiated!");
		this.happy = -10;
	}
	
	public String toString() {
		return "Cat has "+super.toString();
	}

}
