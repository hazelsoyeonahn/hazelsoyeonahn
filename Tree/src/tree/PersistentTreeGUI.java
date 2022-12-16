package tree;
/*
 * This is a GUI class for PersistentDynamicSet.
 * When the element is added and removed, it will copy effected nodes
 * and link to uneffected nodes.
 */

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PersistentTreeGUI extends JPanel{
	private PersistentDynamicSet pTree;
	static String element;
	static JPanel panel = new JPanel();
	static JTextField elementInput = new JTextField(10);
	char[] copyBtree;
	
	public PersistentTreeGUI() {
		pTree = new PersistentDynamicSet();
		setPreferredSize(new Dimension(1100,600));
		setBackground(Color.white);
	}
	
	public <E> void addElement(String s) {
		pTree.add(s);	
		elementInput.setText("");
		this.repaint();
	}
	
	public <E> void removeElement(String s) {

		pTree.remove(s);
		elementInput.setText("");
		this.repaint();
	}
	
	int xleft = 100;
	int down = 70;
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(2));
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		
		//draw all nodes in the set
		if(pTree.tree.rootNode != null) {
			//rootnode
			g.drawString(pTree.tree.rootNode.element.toString(),500, 20);
			
			//leftside
			if(pTree.tree.rootNode.leftChild != null) {
				g.drawLine(500, 30, 300, down);
				g.drawString(pTree.tree.rootNode.leftChild.element.toString(),300, 20+down);
				
				if(pTree.tree.rootNode.leftChild.leftChild != null) {
					g.drawLine(300, 30+down, 200, down*2);
					g.drawString(pTree.tree.rootNode.leftChild.leftChild.element.toString(),200, 20+(down*2));
					
					if(pTree.tree.rootNode.leftChild.leftChild.leftChild != null) {
						g.drawLine(200, 30+(down*2), 100, down*3);
						g.drawString(pTree.tree.rootNode.leftChild.leftChild.leftChild.element.toString(),100, 20+(down*3));
					}
					
					if(pTree.tree.rootNode.leftChild.leftChild.rightChild != null) {
						g.drawLine(200, 30+(down*2), 250, down*3);
						g.drawString(pTree.tree.rootNode.leftChild.leftChild.rightChild.element.toString(),250, 20+(down*3));
					}
				}
				
				if(pTree.tree.rootNode.leftChild.rightChild != null) {
					g.drawLine(300, 30+down, 400, down*2);
					g.drawString(pTree.tree.rootNode.leftChild.rightChild.element.toString(),400, 20+(down*2));
					
					if(pTree.tree.rootNode.leftChild.rightChild.leftChild != null) {
						g.drawLine(400, 30+(down*2), 310, down*3);
						g.drawString(pTree.tree.rootNode.leftChild.rightChild.leftChild.element.toString(),310, 20+(down*3));
					}
					
					if(pTree.tree.rootNode.leftChild.rightChild.rightChild != null) {
						g.drawLine(400, 30+(down*2), 490, down*3);
						g.drawString(pTree.tree.rootNode.leftChild.rightChild.rightChild.element.toString(),490, 20+(down*3));
					}
				}
			}
			//rightside
			if(pTree.tree.rootNode.rightChild != null) {
				g.drawLine(500, 30, 700, down);
				g.drawString(pTree.tree.rootNode.rightChild.element.toString(),700,  20+down);
				
				if(pTree.tree.rootNode.rightChild.leftChild != null) {
					g.drawLine(700, 30+down, 600, down*2);
					g.drawString(pTree.tree.rootNode.rightChild.leftChild.element.toString(),600, 20+(down*2));
					
					if(pTree.tree.rootNode.rightChild.leftChild.leftChild != null) {
						g.drawLine(600, 30+(down*2), 530, down*3);
						g.drawString(pTree.tree.rootNode.rightChild.leftChild.leftChild.element.toString(),530, 20+(down*3));
					}
					
					if(pTree.tree.rootNode.rightChild.leftChild.rightChild != null) {
						g.drawLine(600, 30+(down*2), 670, down*3);
						g.drawString(pTree.tree.rootNode.rightChild.leftChild.rightChild.element.toString(),670, 20+(down*3));
					}
				}
				
				if(pTree.tree.rootNode.rightChild.rightChild != null) {
					g.drawLine(700, 30+down, 800, down*2);
					g.drawString(pTree.tree.rootNode.rightChild.rightChild.element.toString(),800, 20+(down*2));
					
					if(pTree.tree.rootNode.rightChild.rightChild.leftChild != null) {
						g.drawLine(800, 30+(down*2), 710, down*3);
						g.drawString(pTree.tree.rootNode.rightChild.rightChild.leftChild.element.toString(),710, 20+(down*3));
					}
					
					if(pTree.tree.rootNode.rightChild.rightChild.rightChild != null) {
						g.drawLine(800, 30+(down*2), 890, down*3);
						g.drawString(pTree.tree.rootNode.rightChild.rightChild.rightChild.element.toString(),890, 20+(down*3));
					}
				}
			}
		}
		
	}
	public static void main(String args[]) {
		JFrame frame = new JFrame("Persistent Tree GUI");
		final PersistentTreeGUI treeG = new PersistentTreeGUI();
		JLabel label = new JLabel("This is 4 level tree. More than 4 level cannot be implemented.");
		label.setBounds(500, 400, label.getWidth(), label.getHeight());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(treeG);
		
		//add buttons
		JButton addElement = new JButton("Add element");
		addElement.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				element = elementInput.getText();
				treeG.addElement(element);
			}
		});
		
		//remove buttons
		JButton removeElement = new JButton("Remove element");
		removeElement.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				element = elementInput.getText();
				treeG.removeElement(element);
			}
		});

		panel.add(label);
		panel.add(elementInput);
		panel.add(addElement);
		panel.add(removeElement);
		
		frame.add(panel, BorderLayout.PAGE_END);
		frame.pack();
		frame.setVisible(true);
		
	}
}
