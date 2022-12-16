package exercises;


public class Customer implements Comparable<Customer> {
	private String name;
	private int salary;
	
	public Customer(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}
	
	public int compareTo(Customer o) {
		return this.name.compareTo(o.name);
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", salary=" + salary + "]";
	}
	
	
}
