package lectureCode;

public class Apple implements PowerButton {
	private boolean powerStatus;

	@Override
	public void on() {
		this.powerStatus = true;
		// POST: Power On Self Test:
		// check Boot-ROM/RAM
		// Boot chime�
	}

	@Override
	public void off() {
		this.powerStatus = false;
		// Do power off routines: close files, etc.
	}

	@Override
	public boolean isOn() {
		return this.powerStatus;
	}
}