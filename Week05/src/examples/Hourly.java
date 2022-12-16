package examples;

public class Hourly extends Employee {

	private int hoursWorked;

	public Hourly(String name, String address, String phone, String socialSecurityNumber, double payRate) {
		super(name, address, phone, socialSecurityNumber, payRate);
		this.hoursWorked = 0;
	}

	public void addHours(int moreHours) {
		this.hoursWorked += moreHours;
	}

	@Override
	public double pay() {
		double payment = payRate * hoursWorked;
		hoursWorked = 0;
		return payment;

	}

	@Override
	public String toString() {
		String result = super.toString();
		result += "Current Hours: " + this.hoursWorked + "\n";
		return result;
	}

}
