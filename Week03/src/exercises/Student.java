package exercises;

public class Student {
	
	private String firstName;
	private String lastName;
	private String id;
	
	public Student (String firstName, String lastName, String id) {
		
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setId(id);
	}
	
	public Student (String id) {
		
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setId(id);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String toString()
	{
		return "Studnet's frist name: "+this.firstName + ", last name: "+this.lastName+ ", ID: "+this.id;
	}
	

}
