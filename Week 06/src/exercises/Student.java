package exercises;

public class Student {
	
	String name;
	String paperCode;
	
	@Override
	public String toString() {
		return name;
	}
	
	public Student(String name, String paperCode) {
		this.name = name;
		this.paperCode = paperCode;
	}

}
