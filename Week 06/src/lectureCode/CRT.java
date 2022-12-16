package lectureCode;

public class CRT extends Television {
	@Override
	public void on() {
		System.out.println("Initialise CRT");
	}

	@Override
	public void off() {
		System.out.println("Shut off CRT");
	}

	@Override
	public boolean isOn() {
		return false;
	}
}
