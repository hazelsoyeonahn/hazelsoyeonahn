package assignment2;
/*
 * Exact class implements Exact Approach.
 * This class ensures that the minimum lengths are correctly found.
 * By implementing divide and conquer approach and greedy approach.
 * It will find the minimum length of lines with greedy class.
 * Then it will divide those problems and measure length.
 * If founded length and total length of measured lengths are same,
 * the approach is proved accurate.
 */

import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Exact extends JPanel{
	int n;
	int[][] vertex;
	int nonInterEdge;
	int triangle;
	int totalInterEdge;
	Integer min;
	//constructor
	public Exact(int n, int[][] vertex) {
		JLabel label = new JLabel();
		this.n = n;
		this.vertex = vertex;
		this.nonInterEdge = n - 3;
		this.triangle = n - 2;
		this.totalInterEdge = (n*(n-3))/2;
		label.setText("Non Inter Edge: "+nonInterEdge+" , Number of triangle: "+triangle+", Total Inter Edge: "+totalInterEdge);
		super.add(label);
	}
	
	//paint JLabel
	public void paintComponent(Graphics g) {
		Greedy greedy = new Greedy(n,vertex);
		Polygon p = new Polygon();
		ArrayList<Integer> minimum = new ArrayList<Integer>();
		//draw first polygon with greedy approach
		for(int j=0; j<n; j++) {
			p.addPoint(vertex[j][0], vertex[j][1]);
		}
		g.drawPolygon(p);
		//triangle doesn't need to be considered
		if(n == 3) {
			System.out.println("There is no InterEdge");
			g.drawString("Triangle has no line",300, 300);
		}
		//square can be divided by two polygons
		if(n == 4) {
			minimum = greedy.getSmallest();
			min = greedy.min;
			//draw lines for the first polygon
			for(int k=0; k<nonInterEdge*2; k++) {
				g.drawLine(vertex[minimum.get(k)][0], vertex[minimum.get(k)][1],
						vertex[minimum.get(k+1)][0], vertex[minimum.get(k+1)][1]);
				k++;
			}
			g.drawString("length: "+min,70, 160);
			
			ArrayList<Integer> tri1= new ArrayList<Integer>();
			ArrayList<Integer> tri2 = new ArrayList<Integer>();
			
			tri1.add(0);
			tri1.add(1);
			tri1.add(2);
			tri2.add(2);
			tri2.add(3);
			tri2.add(0);
			
			//divide square to two triangles
			int[][] vertexPoly1 = new int [tri1.size()][2];
			int[][] vertexPoly2 = new int [tri2.size()][2];
			//add correct position
			for(int i=0; i<tri1.size(); i++) {
				vertexPoly1[i][0] = vertex[tri1.get(i)][0];
				vertexPoly1[i][1] = vertex[tri1.get(i)][1];
			}
			//add correct position
			for(int i=0; i<tri2.size(); i++) {
				vertexPoly2[i][0] = vertex[tri2.get(i)][0];
				vertexPoly2[i][1] = vertex[tri2.get(i)][1];
			}
			//draw first triangle
			Polygon pol1 = new Polygon();
			for(int j=0; j<vertexPoly1.length; j++) {
				pol1.addPoint(vertexPoly1[j][0]+200, vertexPoly1[j][1]);
			}
			g.drawPolygon(pol1);
			//draw second triangle
			Polygon pol2 = new Polygon();
			for(int j=0; j<vertexPoly2.length; j++) {
				pol2.addPoint(vertexPoly2[j][0]+400, vertexPoly2[j][1]);
			}
			g.drawPolygon(pol2);
			
			g.drawString("The length of a triangle is "+min,100, 260);
			g.drawString("Therefore, this tessellation is proved by exact approach", 100, 300);
		}
		if(n > 4) {
		minimum = greedy.getSmallest();
		min = greedy.min;
		//draw lines for first polygon
		for(int k=0; k<nonInterEdge*2; k++) {
			g.drawLine(vertex[minimum.get(k)][0], vertex[minimum.get(k)][1],
					vertex[minimum.get(k+1)][0], vertex[minimum.get(k+1)][1]);
			k++;
		}
		g.drawString("length: "+min,70, 160);
		
		//choose edge
			int v0 = triangle/2; //choose middle of the vertexes		
			int v2 = v0+1; //next vertexes is the one on the left side
			int common1 = 0;
			int common2 = 0;
			System.out.println("Chosen vertex v0: "+v0+" v2: "+v2);
			
			//find the index number of the vertex, 
			//so you know each vertex is connected to which vertex.
			int numV0 = minimum.indexOf(v0);
			int numV2 = minimum.indexOf(v2);
			boolean isCommon = false;
			//there should be common vertex between v0 and v2 if they are forming a triangle
			//if even right side is the common vertex with v2
			if(numV0%2 == 0) {
				common1 = minimum.get(numV0+1);
			}
			//if odd left side is the common vertex with v2
			else {
				common1 = minimum.get(numV0-1);
			}
			//double check if both common vertexes are equal
			if(numV2%2 == 0) {
				common2 = minimum.get(numV2+1);
			}
			else {
				common2 = minimum.get(numV2-1);
			}
			//check if both commons are same
			if(common1 == common2) {
				isCommon = true;
				System.out.println("Found common vertex: "+common2);
			}
			
			ArrayList<Integer> polygon1 = new ArrayList<Integer>();
			ArrayList<Integer> polygon2 = new ArrayList<Integer>();
			ArrayList<Integer> triangleArr = new ArrayList<Integer>();	
			//if common vertex is found, divide it with 2 polygon and 1 triangle of v0 and v2
			while(isCommon) {
				//triangle is always made with v0,v2 and common vertex
				triangleArr.add(v0);
				triangleArr.add(v2);
				triangleArr.add(common1);
				//rotate vertex until find reach the end
				while(common1 != v0+1) {
					if(common1 == n) {
						common1 = 0;
					}
					polygon1.add(common1);
					++common1;
				}
				while(common2 != v2-1) {
					if(common2 == n) {
						common2 = 0;
					}
					polygon2.add(common2);
					--common2;
				}
				System.out.println("First set of polygon: "+polygon1);
				System.out.println("Second set of polygon: "+polygon2);
				isCommon = false;
			}
				
			//create new array of vertex for new polygons 
			int[][] vertexPoly1 = new int [polygon1.size()][2];
			int[][] vertexPoly2 = new int [polygon2.size()][2];
			int[][] triangle = new int [triangleArr.size()][2];
			
			//save polygons positions to the new arrays
			for(int i=0; i<triangleArr.size(); i++) {
				triangle[i][0] = vertex[triangleArr.get(i)][0];
				triangle[i][1] = vertex[triangleArr.get(i)][1];
			}
				
			for(int i=0; i<polygon1.size(); i++) {
				vertexPoly1[i][0] = vertex[polygon1.get(i)][0];
				vertexPoly1[i][1] = vertex[polygon1.get(i)][1];
			}
			for(int i=0; i<polygon2.size(); i++) {
				vertexPoly2[i][0] = vertex[polygon2.get(i)][0];
				vertexPoly2[i][1] = vertex[polygon2.get(i)][1];
			}
			
			//take greedy approach again to evaluate new polygons except when it's a triangle.
			Greedy g1 = new Greedy(polygon1.size(),vertexPoly1);
			Greedy g2 = new Greedy(polygon2.size(),vertexPoly2);
				
			ArrayList<Integer> gred1 = new ArrayList<Integer>();
			if(polygon1.size()!=3)
				gred1 = g1.getSmallest();		
			else
				g1.min = 0; //if triangle no length
			
			ArrayList<Integer> gred2 = new ArrayList<Integer>();
			if(polygon2.size()!=3)
				gred2 = g2.getSmallest();
			else
				g2.min = 0;
			
			//draw second polygon
			Polygon pol1 = new Polygon();		
			for(int j=0; j<vertexPoly1.length; j++) {
				pol1.addPoint(vertexPoly1[j][0]+200, vertexPoly1[j][1]);
			}
			g.drawPolygon(pol1);
				
			//check if it's triangle that doesn't need lines then draw lines.
			if(!gred1.isEmpty()) {
				for(int k=0; k<gred1.size(); k++) {
				g.drawLine(vertexPoly1[gred1.get(k)][0]+200, vertexPoly1[gred1.get(k)][1],
						vertexPoly1[gred1.get(k+1)][0]+200, vertexPoly1[gred1.get(k+1)][1]);
				k++;
			}
			g.drawString("length: "+g1.min,270, 160);
			}
			
			//draw thrid polygon
			Polygon pol2 = new Polygon();		
			for(int j=0; j<vertexPoly2.length; j++) {
				pol2.addPoint(vertexPoly2[j][0]+400, vertexPoly2[j][1]);
			}
			g.drawPolygon(pol2);
				
			//check if it's triangle that doesn't need lines then draw lines.
			if(!gred2.isEmpty()) {
				for(int k=0; k<gred2.size(); k++) {
				g.drawLine(vertexPoly2[gred2.get(k)][0]+400, vertexPoly2[gred2.get(k)][1],
						vertexPoly2[gred2.get(k+1)][0]+400, vertexPoly2[gred2.get(k+1)][1]);
				k++;
			}
			g.drawString("length: "+g2.min,470, 160);
			}
			
			//finally draw the triangle
			Polygon pol3 = new Polygon();
			for(int j=0; j<triangle.length; j++) {
				pol3.addPoint(triangle[j][0]+600, triangle[j][1]);
			}
			g.drawPolygon(pol3);
				
			//get length of side of triangle, so we can calculate the total length
			int totalLength = 0;
			int x1 = triangle[0][0];
			int x2 = triangle[1][0];
			int y1 = triangle[0][1];
			int y2 = triangle[1][1];

			totalLength += ((int) Math.sqrt((Math.abs(y2 - y1)*Math.abs(y2 - y1))+(Math.abs(x2-x1)*Math.abs(x2-x1))));
				
			int xx1 = triangle[1][0];
			int xx2 = triangle[2][0];
			int yy1 = triangle[1][1];
			int yy2 = triangle[2][1];

			totalLength += ((int) Math.sqrt((Math.abs(yy2 - yy1)*Math.abs(yy2 - yy1))+(Math.abs(xx2 - xx1)*Math.abs(xx2-xx1))));
				
			g.drawString("length: "+totalLength,670, 160);
			
			//check if first polygon length is equal to the total length of other polygons.ß
			if(min == (g1.min+g2.min+totalLength)) {
				g.drawString("Total length of a triangle and 2 polygons are "+g1.min+"+"+g2.min+"+"+totalLength+" = "+min,100, 260);
				g.drawString("Therefore, this tessellation is proved by exact approach", 100, 300);
			}
		}
	}
}
