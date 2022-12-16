package network;
/*
 * This class accepts n x n association table and implements dendrogram hierarchy of cluster community.
 * This class contains 6 sets of different person vertex. 
 * Then merges set, one at a time that has smallest weight when complete linkage clustering occurs. 
 * This class is child class of CliqueFinder and borrows its inner class vertex.
 * If you want to see how weights are calculated, remove comment on System.out.println in the loop.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CommunityClusterFinder extends CliqueFinder{
	private static final int INFINITY = Integer.MAX_VALUE;
	static public CliqueFinder cf;
	public BestAssociationFinder baf;
	public Set<vertex> anna = new HashSet<vertex>();
	public Set<vertex> carl = new HashSet<vertex>();
	public Set<vertex> emma = new HashSet<vertex>();
	public Set<vertex> fred = new HashSet<vertex>();
	public Set<vertex> dave = new HashSet<vertex>();
	public Set<vertex> bill = new HashSet<vertex>();
	ArrayList<Set<vertex>> setList = addSet();
	boolean[] isMerged = new boolean[6];
	
	//weighted graph
	static double[][] weighted = {
			{0, 0.916, INFINITY, INFINITY, INFINITY, 0.693},
	         {0.916, 0, 0.693, INFINITY, 1.204, INFINITY},
	         {INFINITY, 0.693, 0, 0.357, 0.223, INFINITY},
	         {INFINITY, INFINITY, 0.357, 0, INFINITY, INFINITY},
	         {INFINITY, 1.204, 0.223, INFINITY, 0, 0.916},
	         {0.693, INFINITY, INFINITY, INFINITY, 0.916, 0}};
	
	/*constructor that initiates CliqueFinder and BestAssociationFounder object
	Then it uses parameter to sort neighbor using sortNeighbors method from CliqueFinder
	Then add vertex element to each set*/
	public CommunityClusterFinder(double[][] weighted) {
		cf = new CliqueFinder();	
		cf.sortNeighbors(weighted);
		anna.add(cf.anna);
		carl.add(cf.carl);
		emma.add(cf.emma);
		fred.add(cf.fred);
		dave.add(cf.dave);
		bill.add(cf.bill);
	}
	
	//this method copies existing weight arrays to indicator array
	public double[][] addCluster() {
		double[][] indicator = new double[weighted.length][weighted.length];
		
		for(int i=0; i<weighted.length; i++) {
			for(int j=0; j<weighted.length; j++) {
				indicator[i][j] = weighted[i][j];
			}
		}
		return indicator;
	}
	
	//this method adds all sets to ArrayList 
	public ArrayList<Set<vertex>> addSet() {
		ArrayList<Set<vertex>> list= new ArrayList<Set<vertex>>();
		list.add(anna);
		list.add(carl);
		list.add(emma);
		list.add(fred);
		list.add(dave);
		list.add(bill);
		
		return list;
	}
	
	//this method merges two sets then returns merged set
	public Set<vertex> mergeSet(Set<vertex> set1, Set<vertex> set2) {
		Set<vertex> merged = new HashSet<vertex>();
		
		merged.addAll(set1);
		merged.addAll(set2);
		
		return merged;
	}
	
	/*
	 * This method receives index parameter then,
	 * returns set according to its index.
	 * If the set is merged, its index might have changed.
	 * So, check if its merged then returns correct set.
	 */
	public Set<vertex> getSet(int index){
		Set<vertex> returnThis = new HashSet<vertex>();
		if(index == 0)
			returnThis= anna;
		if(index == 1)
			returnThis= carl;
		if(index == 2)
			returnThis= emma;
		if(index == 3)
			returnThis= fred;
		if(index == 4)
			returnThis= dave;
		if(index == 5)
			returnThis= bill;
		if(isMerged[index] == true) { //check if this set is merged
			for(Set<vertex> set : setList) {
				for(vertex v1 : set) {
					for(vertex v2 : returnThis)
						if(v1.equals(v2))
							returnThis = set;
				}
			}
		}
			return returnThis;		
	}
	
	//this method returns index according to its vertex
	public int getIndex(vertex v) {
		if(v.equals(cf.anna))
			return 0;
		if(v.equals(cf.carl))
			return 1;
		if(v.equals(cf.emma))
			return 2;
		if(v.equals(cf.fred))
			return 3;
		if(v.equals(cf.dave))
			return 4;
		if(v.equals(cf.bill))
			return 5;
		else
			return INFINITY;
	}
	
	/*
	 * This method determines clusters weight, merge one set by one 
	 * until its all merged into one set.
	 */
	public void clusterFinder() {
		Set<vertex> newSet = new HashSet<vertex>();
		setList = addSet();
		ArrayList<vertex> neigh = new ArrayList<vertex>();
		
		//copy weighted array
		double[][] indicator = addCluster();
		boolean loop = true;
		
		System.out.println(setList);
		
		while(loop) {
			double min = 100;
			int person1 = 0;
			int person2 = 0;
			int mergedNum = 0;
	
			if(setList.size() != 2) {
				for(int i=0; i<setList.size(); i++) {
				for(vertex v: setList.get(i)) {	
					//if set is alone, consider one neighbor
					if(setList.get(i).size() == 1) {
						for(int j=0; j<v.neighbor.length; j++) {
							//if weight is lower than minimum, the weight is minimum
							if(min > indicator[getIndex(v)][getIndex(v.neighbor[j])] && indicator[getIndex(v)][getIndex(v.neighbor[j])] != 0) {
								min = indicator[getIndex(v)][getIndex(v.neighbor[j])];
								person1 = getIndex(v);
								person2 = getIndex(v.neighbor[j]);
								//System.out.println(v+" and "+v.neighbor[j]+" = "+min);
							}		
						}
					}
					//if set is not alone, add all neighbors for all vertexes in the set
					else {	
						mergedNum = i;
						for(int x=0; x<v.neighbor.length; x++) {
							if(!neigh.contains(v.neighbor[x])) //no duplicate in the list
								neigh.add(v.neighbor[x]);
						}
						
						//remove vertex if it is already in the set
						for(vertex vtx: setList.get(i)) {
							if(neigh.contains(vtx))
								neigh.remove(vtx);
						}
					}
				}
				
				//if set is not alone, and ArrayList of neighbors are there
				if(!neigh.isEmpty() ) {
					ArrayList<vertex> vCluster = new ArrayList<vertex>();
					for(vertex v: setList.get(mergedNum))
						vCluster.add(v);
					
					for(int j=0; j<vCluster.size(); j++) {
						for(int x=0; x<neigh.size(); x++) {
							for(int y=0; y<vCluster.get(j).neighbor.length; y++) {
								//if vertexes in the set's neighbor is found
								if(neigh.get(x).equals(vCluster.get(j).neighbor[y])) {	
									double min1 = indicator[getIndex(neigh.get(x))][getIndex(vCluster.get(j))];
								//	System.out.println(neigh.get(x)+" and "+vCluster.get(j)+" = "+min1);
									double min2 = 0;
									
									//get other vertex in the set that is neighbor to previous vertex
									for(vertex v: setList.get(mergedNum)) {
										for(int z=0; z<v.neighbor.length; z++) {
												if(!v.equals(vCluster.get(j)) && v.neighbor[z].equals(vCluster.get(j))) {
												 min2 = weighted[getIndex(v)][getIndex(vCluster.get(j))];
											}
										}
										
									}
									// minimum must be smaller or equal when its alone in the set
									if(min >= min1) {
										//if min is equal but the people are different, must use first option
										//as some mins needs to add min1 + min2
										if(person1 == getIndex(neigh.get(x)) && person2 == getIndex(vCluster.get(j))) {
											min = min1 + min2;
										person1 = getIndex(neigh.get(x));
										person2 = getIndex(vCluster.get(j));
									//	System.out.println(min+" ="+min1+" + "+min2);
										}
									}
								}
							}
						}
					}
				}
				
			}
			}
			
			//If setList only have two set. Merge two sets.
			else if(setList.size() == 2) {
				vertex v1 = new vertex();
				vertex v2 = new vertex();
				
				for(vertex v : setList.get(0))
					v1 = v;
				for(vertex v : setList.get(1))
					v2 = v;
				
				person1 = getIndex(v1);
				person2 = getIndex(v2);
			}
			
			//merge new set
			newSet = mergeSet(getSet(person1), getSet(person2));
			
			//make sure indicator is 0 to indicate it is already merged
			indicator[person1][person2] = 0; 
			indicator[person2][person1] = 0;
			//remove two old sets.
			setList.remove(getSet(person1)); 			
			setList.remove(getSet(person2));
			//add new merged set.
			setList.add(newSet);
			//indicate if the person is already merged for getSet method
			isMerged[person1] = true;
			isMerged[person2] = true;
			System.out.println(setList);
			neigh = new ArrayList<vertex>();

			//if only one set in the list, finish the loop
			if(setList.size() == 1)
				loop = false;
		}
	}
	
		//main method
		public static void main(String args[]) {
			CommunityClusterFinder ccf = new CommunityClusterFinder(weighted);
			ccf.addCluster();
			ccf.clusterFinder();
		}
}
