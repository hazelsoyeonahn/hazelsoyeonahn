package exercises;

public class ContactDetails implements Comparable<ContactDetails>{
	private Relationship relationship;
	private String firstName;
	private String lastName;
	private String companyName;
	
	public ContactDetails(Relationship relationship, String firstName, String lastName, String companyName) {
		this.relationship = relationship;
		this.firstName = firstName;
		this.lastName = lastName;
		this.companyName = companyName;
	}

	public Relationship getRelationship() {
		return relationship;
	}

	public void setRelationship(Relationship relationship) {
		this.relationship = relationship;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public int compareTo(ContactDetails o) {
		return this.lastName.compareTo(o.lastName);
	}
	
	@Override
	public String toString() {
		return "ContactDetails [relationship=" + relationship + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", companyName=" + companyName + "]";
	}
	
	
}

