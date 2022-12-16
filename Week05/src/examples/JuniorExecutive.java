package examples;

public class JuniorExecutive extends Executive {
	private int signAmount;

	public JuniorExecutive(String name, String address, String phone, String socialSecurityNumber, double payRate) {
		super(name, address, phone, socialSecurityNumber, payRate);
		this.setSignAmount(0);
	}

	public int getSignAmount() {
		return signAmount;
	}

	public void setSignAmount(int signAmount) {
		this.signAmount = signAmount;
	}

	public double pay() {
		return super.pay() + this.getSignAmount();
	}

}
