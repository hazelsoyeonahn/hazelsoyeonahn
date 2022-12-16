package Exercises;
import java.util.Date;

public class MoneyTransfer {
	private CustomerAccountUpdate from;
	private CustomerAccountUpdate to;
	private double amount;
	private long timeStamp;
	
	public MoneyTransfer() {
		super();
	}
	
	public MoneyTransfer(CustomerAccountUpdate from, CustomerAccountUpdate to, double amount) {
		super();
		if(from.name == null) {
			MoneyTransferException me = new MoneyTransferException("Customer's account is null");
			me.setTimeStep(this.timeStamp);
			throw me;
		}
		else if(from.name == "") {
			MoneyTransferException me = new MoneyTransferException("Customer's account is empty");
			me.setTimeStep(this.timeStamp);
			throw me;
		}
		if(to.name == null){
			MoneyTransferException me = new MoneyTransferException("Null detail has been founded");
			me.setTimeStep(this.timeStamp);
			throw me;
		}
		else if(to.name == "") {
			MoneyTransferException me = new MoneyTransferException("Customer's detail is empty");
			me.setTimeStep(this.timeStamp);
			throw me;
		}
		if(amount < 0) {
			MoneyTransferException me = new MoneyTransferException("Transfer can not be negative");
			me.setTimeStep(this.timeStamp);
			throw me;
		}
		
		this.from = from;
		this.to = to;
		this.amount = amount;
		this.timeStamp = System.currentTimeMillis();
		
	}

	public CustomerAccountUpdate getFrom() {
		return from;
	}

	public void setFrom(CustomerAccountUpdate from) {	
		if(from.name == null) {
			MoneyTransferException me = new MoneyTransferException("Customer's account is null");
			me.setTimeStep(this.timeStamp);
			throw me;
		}
		else if(from.name == "") {
			MoneyTransferException me = new MoneyTransferException("Customer's account is empty");
			me.setTimeStep(this.timeStamp);
			throw me;
		}
		this.from = from;
	}

	public CustomerAccountUpdate getTo() {
		return to;
	}

	public void setTo(CustomerAccountUpdate to) {
		if(to.name == null){
			MoneyTransferException me = new MoneyTransferException("Null detail has been founded");
			me.setTimeStep(this.timeStamp);
			throw me;
		}
		else if(to.name == "") {
			MoneyTransferException me = new MoneyTransferException("Customer's detail is empty");
			me.setTimeStep(this.timeStamp);
			throw me;
		}
		this.to = to;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		if(amount < 0) {
			MoneyTransferException me = new MoneyTransferException("Transfer can not be negative");
			me.setTimeStep(this.timeStamp);
			throw me;
		}
		
		this.amount = amount;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		Date date = new Date(timeStamp);
		String dateString = date.toString();
		return "MoneyTransfer [from=" + from + ", to=" + to + ", amount=" + amount + ", timeStamp=" + timeStamp + "]";
	}
	

}
