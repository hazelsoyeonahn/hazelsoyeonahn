package exercises;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NewWindowAdapter extends WindowAdapter{
	public void CloseWindw(WindowEvent w) {
		System.exit(0);
	}
}
