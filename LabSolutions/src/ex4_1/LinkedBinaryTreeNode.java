package ex4_1;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

public class LinkedBinaryTreeNode<E> implements MutableTreeNode{
	
	private E element;
	private MutableTreeNode parent;
	private List<MutableTreeNode> children;

	//default constructor
	public LinkedBinaryTreeNode() {
		this(null);
	}
	
	//constructor
	public LinkedBinaryTreeNode(E element) {
		this.element = element;
		parent = null;
		children = new ArrayList<MutableTreeNode>();
	}

	//returns the child's speicific index
	@Override
	public TreeNode getChildAt(int childIndex) throws IndexOutOfBoundsException{
		return children.get(childIndex);
	}

	//returns the number of children
	@Override
	public int getChildCount() {
		return children.size();
	}

	//returns parent
	@Override
	public TreeNode getParent() {
		return parent;
	}

	//returns the index of node
	//if null return -1
	@Override
	public int getIndex(TreeNode node) {
		if(node == null) {
			throw new IllegalArgumentException();
		}
		else {
			return children.indexOf(node);
		}
	}

	//returns that this node allows children
	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	//returns whether this node is leaf
	@Override
	public boolean isLeaf() {
		return (getChildCount()==0);
	}

	@Override
	public Enumeration<E> children() {
		return (Enumeration<E>)(new Enumerator(children.iterator()));
	}

	//add the child's node at specific index, updating this node
	//and child node to reflect the change
	@Override
	public void insert(MutableTreeNode child, int index) throws IllegalArgumentException{
		if(child == null)
			throw new IllegalArgumentException("null child");
		child.removeFromParent(); //remove child from existing parent
		children.add(index, child); //update list of child nodes
		child.setParent(this); //update the child nodes
	}

	//remove the child at index from this node, updating this
	//node and child node to reflect the change
	@Override
	public void remove(int index) {
		MutableTreeNode child = children.get(index); //update list
		if(child != null)
			remove(child);
	}

	//remove the specific child from this node, updating this
	//node and child node to reflect the change
	@Override
	public void remove(MutableTreeNode node) {
		if(children.remove(node)) //node found and removed
			node.setParent(null);
		
	}

	//set the element held in this node
	@Override
	public void setUserObject(Object object) {
		this.element = (E)object; //unchecked, could throw exception
		
	}

	//remove this node from its parent, updating this
	//node and its parent node
	@Override
	public void removeFromParent() {
		if(this.parent != null) {
			parent.remove(this);
			this.parent = null;
		}
		
	}

	//sets this parent to be newParent
	//but does not update newParent
	@Override
	public void setParent(MutableTreeNode newParent) {
		removeFromParent(); //remove this node from its existing parent
		this.parent = newParent;
		
	}
	
	public static void main(String[] args) {
		//some sample nodes
		MutableTreeNode root = new LinkedBinaryTreeNode<String>("A");
		MutableTreeNode nodeB = new LinkedBinaryTreeNode<String>("B");
		MutableTreeNode nodeC = new LinkedBinaryTreeNode<String>("C");
		MutableTreeNode nodeD = new LinkedBinaryTreeNode<String>("D");
		MutableTreeNode nodeE = new LinkedBinaryTreeNode<String>("E");
		MutableTreeNode nodeF = new LinkedBinaryTreeNode<String>("F");
		MutableTreeNode nodeG = new LinkedBinaryTreeNode<String>("G");
		
		//build a tree
		nodeB.insert(nodeD, 0);
		nodeB.insert(nodeE, 1);
		nodeC.insert(nodeF, 0);
		nodeC.insert(nodeG, 1);
		root.insert(nodeB, 0);
		root.insert(nodeC, 1);
		
	}

}


class Enumerator<E> implements Enumeration<E>{
	private Iterator<E> iterator;
	
	public Enumerator(Iterator<E> iterator) {
		this.iterator = iterator;
	}

	@Override
	public boolean hasMoreElements() {
		return iterator.hasNext();
	}

	@Override
	public E nextElement() {
		return iterator.next();
	}
	
}


