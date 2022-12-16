package examples;

public class ContractWorker extends Hourly {

	private String startDate;
	private String endDate;

	public ContractWorker(String name, String address, String phone, String socialSecurityNumber, double payRate,
			String startDate, String endDate) {
		super(name, address, phone, socialSecurityNumber, payRate);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
