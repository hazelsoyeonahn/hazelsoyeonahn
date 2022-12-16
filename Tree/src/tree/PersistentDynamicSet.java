package tree;
/*
 * This class copies the nodes that are affected from the
 * root down to that element and links made to unaffected nodes
 * from the previous version of the binary search tree
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

import tree.BinarySearchTree.BinaryTreeNode;

public class PersistentDynamicSet<E>{
	public BinarySearchTree tree;
	public static ArrayList<BinaryTreeNode> visitedList;
	public ArrayList<BinaryTreeNode> newNodeList;
	
	public PersistentDynamicSet() {
		this.tree = new BinarySearchTree();
	}
	
	public BinarySearchTree add(E o) {
		tree.add(o); //add to the BinarySearchTree
		this.visitedList = tree.visitedList; //get visitedList everytime its added
		this.newNodeList = new ArrayList<BinaryTreeNode>();
		BinaryTreeNode[] newNode = new BinaryTreeNode[visitedList.size()];
		boolean notFound = true;
		
		for(int i=0; i<visitedList.size(); i++) {
			//if tree contains visited path node swap it to newNode
			if(tree.contains(visitedList.get(visitedList.size()-i-1).element.toString())) {
				newNode[visitedList.size()-i-1] = tree.createNode(visitedList.get(visitedList.size()-i-1).element.toString());
			
				//if original node has left child
				if(visitedList.get(visitedList.size()-i-1).leftChild != null) {
					//find if it needs to link to new nodes
					for(int j=0; j<visitedList.size(); j++) {
						if(newNode[j]!=null&&visitedList.get(visitedList.size()-i-1).leftChild.element.toString().equals(newNode[j].element.toString())) {
							newNode[visitedList.size()-i-1].leftChild = newNode[j];
							notFound = false;
						}
					}
					//otherwise link to its original node
					if(notFound) {
						newNode[visitedList.size()-i-1].leftChild = visitedList.get(visitedList.size()-i-1).leftChild;
					}
				}
			
				//if original node has right child
				if(visitedList.get(visitedList.size()-i-1).rightChild != null) {	
					//find if it needs to link to new nodes
					for(int j=0; j<visitedList.size(); j++) {
						if(newNode[j]!=null&&visitedList.get(visitedList.size()-i-1).rightChild.element.toString().equals(newNode[j].element.toString())) {
							newNode[visitedList.size()-i-1].rightChild = newNode[j];
							notFound = false;
						}
					}
					//otherwise link to its original node
					if(notFound) {
						newNode[visitedList.size()-i-1].rightChild = visitedList.get(visitedList.size()-i-1).rightChild;						

					}
				}
				}
			notFound = true;
			}

		return tree;
	}
	
	public BinarySearchTree remove(E o) {
		tree.remove(o); //remove to the bianryTree
		this.visitedList = tree.visitedList; //get new visitedList everytime it removes
		this.newNodeList = new ArrayList<BinaryTreeNode>();
		BinaryTreeNode[] newNode = new BinaryTreeNode[visitedList.size()];
		boolean notFound = true;
		
		for(int i=0; i<visitedList.size(); i++) {
			//if tree contains visited path node swap it to newNode
			if(tree.contains(visitedList.get(visitedList.size()-i-1).element.toString())) {
				newNode[visitedList.size()-i-1] = tree.createNode(visitedList.get(visitedList.size()-i-1).element.toString());
				//if original node has left child
				if(visitedList.get(visitedList.size()-i-1).leftChild != null) {
					//find if it needs to link to new nodes
					for(int j=0; j<visitedList.size(); j++) {
						if(newNode[j]!=null&&visitedList.get(visitedList.size()-i-1).leftChild.element.toString().equals(newNode[j].element.toString())) {
							newNode[visitedList.size()-i-1].leftChild = newNode[j];
							notFound = false;
						}
					}
					//otherwise link to its original node
					if(notFound) {
						newNode[visitedList.size()-i-1].leftChild = visitedList.get(visitedList.size()-i-1).leftChild;
					}
				}
			
				//if original node has right child
				if(visitedList.get(visitedList.size()-i-1).rightChild != null) {	
					//find if it needs to link to new nodes
					for(int j=0; j<visitedList.size(); j++) {
						if(newNode[j]!=null&&visitedList.get(visitedList.size()-i-1).rightChild.element.toString().equals(newNode[j].element.toString())) {
							newNode[visitedList.size()-i-1].rightChild = newNode[j];
							notFound = false;
						}
					}
					//otherwise link to its original node
					if(notFound) {
						newNode[visitedList.size()-i-1].rightChild = visitedList.get(visitedList.size()-i-1).rightChild;						

					}
				}
			
			}
		}
		return tree;
	}
	
	public static void main(String args[]) {
		PersistentDynamicSet pt = new PersistentDynamicSet();
		
		pt.add("cow");
		pt.add("fly");
		pt.add("dog");
		pt.add("bat");
		pt.add("fox");
		pt.add("cat");
		pt.add("eel");
		pt.add("ant");
		pt.remove("fox");

	}
}
