package pro;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class FishShoal extends JPanel{
	private ArrayList<Fish> fishList;	
	
	@SuppressWarnings("unchecked")
	public FishShoal() {
		setPreferredSize(new Dimension(500,500));
		setBackground(Color.WHITE);
		fishList = new ArrayList<Fish>(); 
	}
	
	public void add(Fish fish) {
		//creating a ball
		fish = new Fish(new FishShoal());
		fishList.add(fish);
		//create thread
		Thread t = new Thread (fish);
		t.start();
	}
	
	public void remove(Fish fish) {
		if(!fishList.isEmpty()) {
			fishList.remove(0);
		}
	}
	
	public void drawShoal(Graphics g) {
		setPreferredSize(new Dimension(500,500));
		setBackground(Color.white);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
		
		//draw rectangle outline
		g.drawRect(0, 0, getWidth(), getHeight());
		
		//loop to draw all balls
		for(Fish f : fishList) {
			f.draw(g2);
		}
	}
	
	
	/*public Fish canEat(Fish fish) {
		
	}*/
	
	public static void main(String args[]) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//get fish component
		final FishShoal drawF = new FishShoal();
		//add it to frame
		frame.add(drawF);
		
		Fish f = new Fish(new FishShoal());
		//add buttons for speed
		JButton addFish = new JButton("Add fish");
		addFish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drawF.add(f);
			}
		});
		
		JButton removeFish = new JButton("Remove fish");
		removeFish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drawF.remove(f);
			}
		});
		

		
		//add buttons on the panel
		JPanel panel = new JPanel();
		panel.add(addFish);
		panel.add(removeFish);
		//add panel to the frame
		frame.add(panel, BorderLayout.PAGE_END);
		frame.pack();
		frame.setVisible(true);
		
	}
}
