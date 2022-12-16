package exercises;
/**
 * This clas
 * 
 * @author hazelsoyeonahn
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class StyleOptionsPanel extends JPanel{
	private JLabel saying;
	private JCheckBox bold, italic;
	private JComboBox fontNames; 
	private JSlider fontSize;
	private JLabel sizeLabel;
	private String[] names = {"Make A Selection","Times New Roman","Rockwell","Helvetica","Calibri", "Monospaced"};
	private String[] sizes = {"20","22","24","26","28","30","32","34","36","38"};
	//sets up a panel with a label and some check boxes
	//that control the style of the label's font
	
	public StyleOptionsPanel() {

		saying = new JLabel("Say it with style!");
		saying.setFont(new Font("Helvetica", Font.PLAIN, 36));
		bold = new JCheckBox("Bold");
		bold.setBackground(Color.cyan);
		italic = new JCheckBox("Italic");
		italic.setBackground(Color.cyan);
		fontNames = new JComboBox(names);
		fontNames.setBackground(Color.white);
		fontSize = new JSlider(10, 40, 10);
		sizeLabel = new JLabel("Font size: ");
		
		fontSize.setPaintTicks(true);
		fontSize.setPaintLabels(true);
		fontSize.setMajorTickSpacing(5);
		fontSize.setMinorTickSpacing(1);
		
		StyleListener listener = new StyleListener();
		bold.addItemListener(listener);
		italic.addItemListener(listener);
		fontNames.addItemListener(listener);
		add(saying);
		add(bold);
		add(italic);
		add(fontNames);
		add(fontSize);
		setBackground(Color.cyan);
		setPreferredSize(new Dimension(1000,100));
		}
	
	private class StyleListener implements ItemListener
	{
		//Updates the style of the label font style
		
		public void itemStateChanged(ItemEvent event) {
			int style = Font.PLAIN;
			int size = (int)fontSize.getValue();
			String font = fontNames.getSelectedItem().toString();
			
			if(bold.isSelected()) {
				style = Font.BOLD;
			}
			
			if(italic.isSelected()) {
				style += Font.ITALIC;
			}
			saying.setFont(new Font(font, style, size));
			
			
		}
	}
}
