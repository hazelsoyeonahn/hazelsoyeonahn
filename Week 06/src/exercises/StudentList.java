package exercises;
import java.util.ArrayList;

public class StudentList {
	
	private ArrayList<Student> students;
	public StudentList() {
		students = new ArrayList<Student>();
	}
	
	public void add(Student s) {
		students.add(s);
	}
	
	public ArrayList<String> enrolledln(String paperCode){
		ArrayList<String> names = new ArrayList<String>();
		for(Student s: students) {
			if(s.paperCode.contains(paperCode))
				names.add(s.name);
		}
		return names;
	}
	
	public static void main(String[] args) {
		StudentList studentList = new StudentList();
		
		studentList.add(new Student("Bob", "COMP503, COMP600"));
		studentList.add(new Student("Robin", "COMP501, COMP600"));
		studentList.add(new Student("Jamal", "COMP503"));
		System.out.println(studentList.enrolledln("COMP503"));
	}

}
