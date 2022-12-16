
/**
 * This DrawingPanel class instiate throws each time when button is pushed.
 * DrawingPanel constructor add ball as arraylist and set panel size and color.
 * addBall method adds ball with certain speed then throw the thread
 * removeBall method will remove ball 
 * paintComponent method will until there is ball in the ArrayList
 * In main, JButton and JFrame has been declared. Buttons and panel has been all added.
 */

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.BasicStroke;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics2D;
import java.awt.List;


public class FishShoal extends JPanel {
	private static ArrayList<Fish> fishList;
	
	//constructor
	public FishShoal() {
		
		fishList = new ArrayList<Fish>();
		setPreferredSize(new Dimension(500,500));
		setBackground(Color.WHITE);
	}
	
	//add a new ball
	public void add(Fish fish) {
		//creating a ball
		fishList.add(fish);
		//create thread
		Thread t = new Thread (fish);
		t.start();
	}
	
	//remove ball
	public void remove() {
		if(!fishList.isEmpty()) {
			fishList.remove(0);
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
		
		//draw rectangle outline
		g.drawRect(0, 0, getWidth(), getHeight());
		
		//loop to draw all balls
		for(Fish f : fishList) {
			f.draw(g2);
		}
	}
	
	static int x = 2;
	static int y = 3;
	
	public static void main(String[] args) {
		//get a frame
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//get ball component
		final FishShoal drawP = new FishShoal();
		//add it to frame
		frame.add(drawP);
		
		//add buttons for speed
		JButton addFish = new JButton("Add fish");
		addFish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drawP.add(new Fish(fishList));
			}
		});
		
		JButton removeFish = new JButton("Remove fish");
		removeFish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drawP.remove();
			}
		});
		
		JButton speedUp = new JButton("Speed up");
		speedUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				x += 1;
				y += 1;
			}
		});
		
		JButton speedDown = new JButton("Speed down");
		speedDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				x -= 1;
				y -= 1;
			}
		});
		
		//add buttons on the panel
		JPanel panel = new JPanel();
		panel.add(addFish);
		panel.add(removeFish);
		panel.add(speedUp);
		//add panel to the frame
		frame.add(panel, BorderLayout.PAGE_END);
		frame.pack();
		frame.setVisible(true);
	}

}