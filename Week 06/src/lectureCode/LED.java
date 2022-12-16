package lectureCode;

public class LED extends Television {
	private boolean isOn;

	@Override
	public void on() {
		System.out.println("Initialising. Turning on LCD Panel");
		this.isOn = true;
	}

	@Override
	public void off() {
		System.out.println("Turning off LCD Panel");
		this.isOn = false;
	}

	@Override
	public boolean isOn() {
		return this.isOn;
	}
}
