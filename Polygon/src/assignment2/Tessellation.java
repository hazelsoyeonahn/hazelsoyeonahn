package assignment2;
/*
 * Tessellation class is a driver class to implement Brute Force Approach,
 * Greedy Technique approach and Exact approach.
 * This class have JFrame and can call each approach with different number of vertices.
 * The vertices includes the position of each vertices.
 */

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class Tessellation {	
	public int[][] threeVertices(){
		int[][] vertex = new int[3][2];
		vertex[0][0] = 50;
		vertex[0][1] = 50;
		vertex[1][0] = 170;
		vertex[1][1] = 150;
		vertex[2][0] = 50;
		vertex[2][1] = 150;
		return vertex;
	}
	
	public int[][] fourVertices(){
		int[][] vertex = new int[4][2];
		vertex[0][0] = 50;
		vertex[0][1] = 50;
		vertex[1][0] = 170;
		vertex[1][1] = 50;
		vertex[2][0] = 170;
		vertex[2][1] = 150;
		vertex[3][0] = 50;
		vertex[3][1] = 150;
		return vertex;
	}
	
	public int[][] fiveVertices(){
		int[][] vertex = new int[5][2];
		vertex[0][0] = 50;
		vertex[0][1] = 50;
		vertex[1][0] = 100;
		vertex[1][1] = 40;
		vertex[2][0] = 180;
		vertex[2][1] = 80;
		vertex[3][0] = 130;
		vertex[3][1] = 136;
		vertex[4][0] = 30;
		vertex[4][1] = 120;
		return vertex;
	}
	
	public int[][] sixVertices(){
		int[][] vertex = new int[6][2];
		vertex[0][0] = 50;
		vertex[0][1] = 50;
		vertex[1][0] = 100;
		vertex[1][1] = 40;
		vertex[2][0] = 180;
		vertex[2][1] = 80;
		vertex[3][0] = 140;
		vertex[3][1] = 140;
		vertex[4][0] = 100;
		vertex[4][1] = 150;
		vertex[5][0] = 40;
		vertex[5][1] = 120;
		return vertex;
	}
	
	public int[][] sevenVertices(){
		int[][] vertex = new int[7][2];
		vertex[0][0] = 50;
		vertex[0][1] = 50;
		vertex[1][0] = 100;
		vertex[1][1] = 40;
		vertex[2][0] = 180;
		vertex[2][1] = 80;
		vertex[3][0] = 140;
		vertex[3][1] = 130;
		vertex[4][0] = 100;
		vertex[4][1] = 150;
		vertex[5][0] = 10;
		vertex[5][1] = 120;
		vertex[6][0] = 10;
		vertex[6][1] = 100;
		return vertex;
	}
	
	public static void main(String args[]) {		
		JFrame frame = new JFrame();
		frame.setTitle("Tessellation");
		frame.setSize(1000,1000);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		//Please remove //(comment)to run each approach.
		Container contentPane = frame.getContentPane();
		//contentPane.add(new BruteForce(3,new Tessellation().threeVertices()));
		//contentPane.add(new BruteForce(4,new Tessellation().fourVertices())); //test 4 vertices
		//contentPane.add(new BruteForce(5,new Tessellation().fiveVertices()));
		//contentPane.add(new BruteForce(6, new Tessellation().sixVertices()));
		//contentPane.add(new BruteForce(7, new Tessellation().sevenVertices()));
		//contentPane.add(new Greedy(3, new Tessellation().threeVertices()));
		//contentPane.add(new Greedy(4, new Tessellation().fourVertices()));
		//contentPane.add(new Greedy(5, new Tessellation().fiveVertices()));
		//contentPane.add(new Greedy(6, new Tessellation().sixVertices()));
		//contentPane.add(new Greedy(7, new Tessellation().sevenVertices()));
		//contentPane.add(new Exact(3, new Tessellation().threeVertices()));
		//contentPane.add(new Exact(4, new Tessellation().fourVertices()));
		contentPane.add(new Exact(7, new Tessellation().sevenVertices()));
		frame.setVisible(true);
	}
}
