package Task09_3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener{

	public Model model;
	public View view;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		this.view.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if(str.equals("Next")) {
			this.model.checkQuestion(this.view.calcSolution.getText());
		}
		else if(str.equals("Quit")) {
			this.model.quitGame();
		}
		else if(str.equals("Log in")) {
			String username = this.view.unInput.getText();
			String password = this.view.pwInput.getText();
			this.model.checkName(username, password);
		}
	}

}
