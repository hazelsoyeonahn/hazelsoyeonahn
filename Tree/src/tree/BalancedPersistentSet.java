package tree;
/*
 * This class contains Red-Black Tree referenced from
 * https://www.geeksforgeeks.org/red-black-tree-set-2-insert/
 * However, I could make this tree functional.
 * I can add cow->fly->dog correctly then failed in inserting bat
 * 
 * This class extends BinarySearchTree, shares some of its variables.
 * You can test this method in BalancedGUI.
 */
import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;

import tree.BinarySearchTree.BinaryTreeIterator;
import tree.BinarySearchTree.BinaryTreeNode;

public class BalancedPersistentSet<E> extends BinarySearchTree{
	Color color;
	public ArrayList<BinaryTreeNode> visitedList;
	private LinkedList<E> list;
	
	//BinartyTreeNode class is inserted from BinarySearchTree
	public class BinaryTreeNode extends BinarySearchTree.BinaryTreeNode{

		public BinaryTreeNode(Object element) {
			super(element);
			super.leftChild = nil;
			super.rightChild = nil;
			this.color = Color.red;
		}
	}

	public BalancedPersistentSet(){
	}
	
	//this method rotates left
	protected BinaryTreeNode leftRotate(BinaryTreeNode node) {
		BinaryTreeNode x = (BinaryTreeNode)node.rightChild;
		BinaryTreeNode y = (BinaryTreeNode)x.leftChild;
		x.leftChild = node;
		node.rightChild = y;
		return x;
	}
	
	//this method rotates right
	protected BinaryTreeNode rightRotate(BinaryTreeNode node) {
		BinaryTreeNode x = (BinaryTreeNode)node.leftChild;
		BinaryTreeNode y = (BinaryTreeNode)x.rightChild;
		x.rightChild = node;
		node.leftChild = y;
		return x;
	}
	
	boolean ll = false;
	boolean rr = false;
	boolean lr = false; 
	boolean rl = false;
	
	//method for inserting node
	public void insert(E data) {
		visitedList = new ArrayList<BinaryTreeNode>();
		if(this.rootNode == null) { //if rootNode is empty it is first node of the set
			this.rootNode = new BinaryTreeNode(data);
			this.rootNode.color = Color.black; //first node is always black
		}
		else
			this.rootNode = insertFixup(this.rootNode, data);
	}
	
	//helper function for insertion. 
	@SuppressWarnings("unused")
	public BinaryTreeNode insertFixup(tree.BinarySearchTree.BinaryTreeNode rootNode, E data) {
		boolean f = false;
		
		//compare data and rootNode
		int comparison = compare(data, rootNode.element);
		visitedList.add((BinaryTreeNode)rootNode);
		
		//insert in proper position, determine where to insert
		if(rootNode == null) {
			return(new BinaryTreeNode(data));
		}
		else if(comparison<0) {
			if(rootNode.leftChild != null) 
				rootNode.leftChild = insertFixup(rootNode.leftChild, data);
			else if(rootNode.leftChild == null)
				rootNode.leftChild = new BinaryTreeNode(data);
			if(rootNode != this.rootNode) {
				if(rootNode.color == Color.red && rootNode.leftChild.color == Color.red)
					f = true;
			}
		}
		
		else {
			if(rootNode.rightChild != null)
				rootNode.rightChild = insertFixup(rootNode.rightChild, data);
			else if(rootNode.rightChild == null)
				rootNode.rightChild = new BinaryTreeNode(data);
			if(rootNode!=this.rootNode) {
				if(rootNode.color == Color.red && rootNode.rightChild.color == Color.red)
					f = true;
			}
		}
		
		//rotate and recolor nodes
		if(this.ll) {
			rootNode = leftRotate((BinaryTreeNode) rootNode);
			rootNode.color = Color.black;
			rootNode.leftChild.color = Color.red;
			this.ll = false;
		}
		else if(this.rr) {
			rootNode = rightRotate((BinaryTreeNode) rootNode);
			rootNode.color = Color.black;
			rootNode.rightChild.color = Color.red;
			this.rr = false;
		}
		else if(this.rl) {
			rootNode.rightChild = rightRotate((BinaryTreeNode)rootNode.rightChild);
			rootNode = leftRotate((BinaryTreeNode)rootNode);
			rootNode.color = Color.black;
			rootNode.leftChild.color = Color.red;
		}
		else if(this.lr) {
			rootNode.leftChild = leftRotate((BinaryTreeNode)rootNode.leftChild);
			rootNode = rightRotate((BinaryTreeNode)rootNode);
			rootNode.color = Color.black;
			rootNode.rightChild.color = Color.red;
			this.lr = false;
		}
		
		//if flag is up, take a look at conflict
		if(f) {
			BinaryTreeNode rootPar = getParent((BinaryTreeNode)rootNode);
			if(rootPar.rightChild == rootNode) {
				if(rootPar.leftChild == null || rootPar.leftChild.color == Color.black) {
					if(rootNode.leftChild != null && rootNode.leftChild.color == Color.red)
						this.rl = true;
					else if(rootNode.rightChild != null && rootNode.rightChild.color == Color.red)
						this.ll = true;
				}
				else {
					rootPar.leftChild.color = Color.black;
					rootNode.color = Color.black;
					if(rootPar != this.rootNode)
						rootPar.color = Color.red;
				}
			}
			else {
				if(rootPar.rightChild == null || rootPar.rightChild.color == Color.black) {
					if(rootNode.leftChild != null && rootNode.leftChild.color == Color.red)
						this.rr = true;
					else if(rootNode.rightChild != null && rootNode.rightChild.color == Color.red)
						this.lr = true;
				}
				else {
					rootPar.rightChild.color = Color.black;
					rootNode.color = Color.black;
					if(rootPar != this.rootNode)
						rootPar.color = Color.red;
				}
			}
			f = false;
		}
		return (BinaryTreeNode)rootNode;
	}
	
	//this method finds parent nodes of a BinaryTreeNode
	public BinaryTreeNode getParent(BinaryTreeNode node) {
		BinaryTreeNode parent = (BinaryTreeNode)node;
		BinaryTreeNode child = (BinaryTreeNode) node;
		
		for(int i=0; i<visitedList.size(); i++) {
			if(visitedList.get(i).leftChild != null && visitedList.get(i).leftChild.equals(child))
				parent = visitedList.get(i);
			if(visitedList.get(i).rightChild != null && visitedList.get(i).rightChild.equals(child))
				parent = visitedList.get(i);
		}
		return parent;
	}
	
	
	
	public static void main(String args[]) {
		BalancedPersistentSet rbt = new BalancedPersistentSet();	
	}
}
