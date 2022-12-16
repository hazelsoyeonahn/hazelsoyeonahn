package examples;

public class Executive extends Employee {

	private double bonus;

	public Executive(String name, String address, String phone, String socialSecurityNumber, double payRate) {
		super(name, address, phone, socialSecurityNumber, payRate);
		this.bonus = 0.0;
	}

	public void awardBonus(double bonus) {
		this.bonus = bonus;

	}

	@Override
	public double pay() {
		double payment = super.pay() + bonus;

		bonus = 0.0;

		return payment;

	}

}
