package network;
/*
 * This class accepts n x n association table and find the largest cliques.
 * This class implements the Bron'Kerbosch algorithm that finds all the maximal cliques.
 * This class have inner class of vertex class.
 */

import java.util.ArrayList;
import java.util.Collections;

public class CliqueFinder {	
	//vertex class represents vertex which attributes name and an array of neighbor
	class vertex{
		vertex[] neighbor;
		String name;
		
		//constructor accepts index of array size
		public vertex(int index) {
			neighbor = new vertex[index];
		}

		public vertex() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return name;
		}
		
	}

	private static final int INFINITY = Integer.MAX_VALUE;
	//association 
	static double[][] association = {
	         {0, 0.4, INFINITY, INFINITY, INFINITY, 0.5},
	         {0.4, 0, 0.5, INFINITY, 0.3, INFINITY},
	         {INFINITY, 0.5, 0, 0.7, 0.8, INFINITY},
	         {INFINITY, INFINITY, 0.7, 0, INFINITY, INFINITY},
	         {INFINITY, 0.3, 0.8, INFINITY, 0, 0.4},
	         {0.5, INFINITY, INFINITY, INFINITY, 0.4, 0}};
	
	static ArrayList<vertex> r = new ArrayList<vertex>();
	static ArrayList<vertex> p = new ArrayList<vertex>();
	static ArrayList<vertex> x = new ArrayList<vertex>();
	static ArrayList<ArrayList<vertex>> clique = new ArrayList<ArrayList<vertex>>();
	static vertex anna;
	static vertex carl;
	static vertex emma;
	static vertex fred;
	static vertex dave;
	static vertex bill;
	
	//constructor
	public CliqueFinder() {
		//assign each vertex with number of neighbors
		anna = new vertex(2);
		anna.name = "anna";
		carl = new vertex(3);
		carl.name = "carl";
		emma = new vertex(3);
		emma.name = "emma";
		fred = new vertex(1);
		fred.name = "fred";
		dave = new vertex(3);
		dave.name = "dave";
		bill = new vertex(2);
		bill.name = "bill";
		
		//add all of vertex to p list
		p.add(anna);
		p.add(carl);
		p.add(emma);
		p.add(fred);
		p.add(dave);
		p.add(bill);
	}
	
	//find neighbor of each vertex and assign them
	public void sortNeighbors(double[][] association) {
		for(int i=0; i<association.length; i++) {
			int count = 0;
			vertex temp = returnName(i);
			for(int j=0; j<association.length; j++) {
				if(association[i][j] != INFINITY && association[i][j] != 0) {
					temp.neighbor[count] = returnName(j);
					++count;
				}
			}
		}
	}
	
	//return vertex according to its index
	public vertex returnName(int index) {
		if(index == 0)
			return anna;
		if(index == 1)
			return carl;
		if(index == 2)
			return emma;
		if(index == 3)
			return fred;
		if(index == 4)
			return dave;
		if(index == 5)
			return bill;
		return null;
	}
	
	//this method implements Bron-Kerbosch algorithm. Accepts parameter of r,p,x
	//it recursively calls it self until finds all cliques
	public int bronKerbosch(ArrayList<vertex> r, ArrayList<vertex> p, ArrayList<vertex> x) {
		//if p list and x list is empty, clique is found
		if(p.isEmpty() && x.isEmpty()){
			System.out.println("Clique: " + r.toString());
			clique.add(r);
			return 1;
		}
		
		int foundClique = 0;
		
		while(!p.isEmpty()) {
			//create temp array for r,p,x
			ArrayList<vertex> r1 = new ArrayList<vertex>();
			for(vertex v : r) {
				r1.add(v);
			}
			r1.add(p.get(0));
			ArrayList<vertex> p1 = new ArrayList<vertex>();
			ArrayList<vertex> x1 = new ArrayList<vertex>();
			
			//find neighbors
			for(int i=0; i<p.get(0).neighbor.length; i++) {
				if(p.contains(p.get(0).neighbor[i]))
					p1.add(p.get(0).neighbor[i]);
				if(x.contains(p.get(0).neighbor[i]))
					x1.add(p.get(0).neighbor[i]);
			}
			foundClique += bronKerbosch(r1,p1,x1);
			x.add(p.get(0));
			p.remove(p.get(0));
		}
		return foundClique;
	}
	
	//main method
	public static void main(String args[]) {
		CliqueFinder cf = new CliqueFinder();
		cf.sortNeighbors(association);
		int totalClique = cf.bronKerbosch(r, p, x);	
		System.out.println("\nTotal clique is "+totalClique);
		
		//add all of cliqueSize and find maximum
		ArrayList<Integer> cliqueSize = new ArrayList<Integer>();
		//find maximum size of clique
		for(int i=0; i<clique.size(); i++) {
			cliqueSize.add(clique.get(i).size());
		}
		
		Integer max = Collections.max(cliqueSize);
		
		for(ArrayList l: clique) {
			if(l.size() == max)
				System.out.println("Maximum clique is "+ l);
		}
	}
}
