package exercises;

public class Person {
	int age;
	double weight;
	boolean student;
	char gender;
	
	public Person(int age, double weight, boolean student, char gender) {
		this.age = age;
		this.weight = weight;
		this.student = student;
		this.gender = gender;
	}
	
	public Person() {
		this.age = -1;
		this.weight = -1;
		this.student = false;
		this.gender = '?';
	}
}
