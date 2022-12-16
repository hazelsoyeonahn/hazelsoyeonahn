package Exercises;

public class MoneyTransferException extends IllegalArgumentException {
	long timeStep;
	
	public MoneyTransferException() {
		super();
	}
	
	public MoneyTransferException(String message) {
		super(message);
	}

	public long getTimeStep() {
		return timeStep;
	}

	public void setTimeStep(long timeStep) {
		this.timeStep = timeStep;
	}
}
