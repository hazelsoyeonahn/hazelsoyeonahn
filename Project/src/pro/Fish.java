package pro;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import java.lang.Math;
import javax.swing.JComponent;

public class Fish implements Runnable{
	
	private double x,y,dx,dy,size,diameter = 25;
	private boolean isAlive;
	public static final int WORLD_WIDTH = 500;
	public static final int WORLD_HEIGHT = 500;
	private Color color;
	private FishShoal shoal;
	private JComponent component;
	
	
	public Fish (FishShoal shoal){
		this.shoal = shoal;
		
	}

	@Override
	public void run(){
		//loopint the thread
		while(true) {
			//move ball
			move();
			//paint ball
			component.repaint();
			//pauce
			try {
				Thread.sleep(60);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public double getX(){
		
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public double getSize(){
		return size;
	}
	
	public void kill(){
		
	}
	
	private double speed = Math.sqrt((dx*x)+(dy*y));
	private void move(){
		
		//to make x direction in a range
		if(x<0|| (x+diameter) > component.getWidth()) {
			dx = -dx;
		}

	//to make y direction in a range
		if(y<0|| (y+diameter) > component.getHeight()) {
			dy = -dy;
		}
	//add velocity
		x += (size*dx)/(2*speed);
		y += (size*dy)/(2*speed);
	}
	
	public void eat(Fish target){
		
	}
	
	public void draw(Graphics g){
		g.setColor(color);
		g.drawLine((int)x, (int)y, (int)diameter, (int)diameter);
	}
	
	


}
