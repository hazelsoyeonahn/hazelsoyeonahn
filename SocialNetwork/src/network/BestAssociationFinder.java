package network;
/*
 * This a class implements AllPairFloydWarshall class written by Andrew Ensor.
 * This class accepts n x n association table then finds best association.
 * It calculates all of association, finds best association 
 * by multiply values of its associated edges.
 * 
 * It also can find the smallest weight by using AllPairsFloydWarshall class.
 * as array d is already suggesting smallest value of its associations.
 * 
 */

import java.util.ArrayList;

public class BestAssociationFinder {
	private static final int INFINITY = Integer.MAX_VALUE;
	protected double[][][] d; //d[k][i][i] is weight of path from v_i to v_j
	protected int[][][] p; //p[k][i][i] is penultimate vertex in path
	private static ArrayList<Integer> names = new ArrayList<Integer>();
	
	//association
	static double[][] association = {
	         {0, 0.4, INFINITY, INFINITY, INFINITY, 0.5},
	         {0.4, 0, 0.5, INFINITY, 0.3, INFINITY},
	         {INFINITY, 0.5, 0, 0.7, 0.8, INFINITY},
	         {INFINITY, INFINITY, 0.7, 0, INFINITY, INFINITY},
	         {INFINITY, 0.3, 0.8, INFINITY, 0, 0.4},
	         {0.5, INFINITY, INFINITY, INFINITY, 0.4, 0}};
	
	//weighted graph
	static double[][] weighted = {
			{0, 0.916, INFINITY, INFINITY, INFINITY, 0.693},
	         {0.916, 0, 0.693, INFINITY, 1.204, INFINITY},
	         {INFINITY, 0.693, 0, 0.357, 0.223, INFINITY},
	         {INFINITY, INFINITY, 0.357, 0, INFINITY, INFINITY},
	         {INFINITY, 1.204, 0.223, INFINITY, 0, 0.916},
	         {0.693, INFINITY, INFINITY, INFINITY, 0.916, 0}};
	
	
	static int numberOfmembers = association.length;
	
	//constructor that calls AllPairsFloydWarshall method then prints out the result
	public BestAssociationFinder(double[][] association) {
		AllPairsFloydWarshall apfw = new AllPairsFloydWarshall(association);
		this.d = apfw.d;
		this.p = apfw.p;
		System.out.println(apfw);
	}
	
	//this method will find the path and multiply the values
	public double findAssociation(int person1, int person2) {
		double asso = 0.0;
		double sumOfAsso = d[numberOfmembers][person1][person2];
		int penultimateV = p[numberOfmembers][person1][person2];
		boolean found = false;
		
		//if there is only one edge
		if(person1 == penultimateV) {
			names.add(person1);
			names.add(person2);	
			return association[person1][person2];
		}
		//if there is more than one edge
		else {
			double edge = association[person2][penultimateV];
			if(association[person1][penultimateV] != INFINITY)
				edge += association[person1][penultimateV];
			//if there are 2 edges then equal to sumOfAsso
			if(edge == sumOfAsso)
				asso = association[person2][penultimateV]*association[person1][penultimateV];
			//otherwise find inner Association
			else {
				double remained = findAssociation(person1, penultimateV); //recursive to find inner association
				asso = remained * association[person2][penultimateV];
			}
			//add all of association if they are not already added
			if(!names.contains(person1))
				names.add(person1);
			if(!names.contains(penultimateV))
				names.add(penultimateV);
			if(!names.contains(person2))
				names.add(person2);	
		}
		
		return asso;
	}
	
	//this method returns the sum of shortest path weight
	public double findWeight(int person1, int person2) {
		return d[weighted.length][person1][person2];
	}
	
	//print names according to its number
	public void printNames() {
		System.out.println("Associated people: ");
		for(Integer i : names) {
			if(i == 0)
			System.out.println("Anna");
		else if(i == 1)
			System.out.println("Carl");
		else if(i == 2)
			System.out.println("Emma");
		else if(i == 3)
			System.out.println("Fred");
		else if(i == 4)
			System.out.println("Dave");
		else if(i == 5)
			System.out.println("Bill");
		else
			System.out.println("Member doesn't exist");
		}
		
	}

	public static void main(String args[]) {
		//number representation of each person
		int anna = 0;
		int carl = 1;
		int emma = 2;
		int fred = 3;
		int dave = 4;
		int bill = 5;
		
		BestAssociationFinder baf = new BestAssociationFinder(association);
		
		//find association
		System.out.println("Association strength: "+baf.findAssociation(bill, carl));
		baf.printNames();
		System.out.println();
		
		
		//clear graph
		names = new ArrayList<Integer>();
		//find weight
		baf = new BestAssociationFinder(weighted);
		System.out.println("Association weighted: "+baf.findWeight(anna, emma));
	}
}
