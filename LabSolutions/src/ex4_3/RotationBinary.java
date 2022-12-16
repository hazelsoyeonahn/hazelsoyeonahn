package ex4_3;

public class RotationBinary {
	Node root;
	
	//get maximum of two integer
	public int maximum(int a, int b) {
		return (a>b) ? a:b;
	}
	
	//get height of the tree
	public int height(Node n) {
		if(n==null)
			return 0;
		return n.height;
	}
	
	//Get right rotation
	public Node right(Node n) {
		Node n1 = n.left;
		Node n2 = n.right;
		
		n1.right = n;
		n.left = n2;
		
		n.height = maximum(height(n.left), height(n.right)) + 1;
		n1.height = maximum(height(n1.left), height(n1.right)) + 1;
		
		return n1;
	}
	
	//get left rotation
	public Node left(Node n) {
		Node n1 = n.right;
		Node n2 = n.left;
		
		n1.left = n;
		n.right =n2;
		
		n.height = maximum(height(n.left), height(n.right)) + 1;
		n1.height = maximum(height(n1.left), height(n1.right)) + 1;
		
		return n1;
	}
	
	public int balance(Node n) {
		if(n == null)
			return 0;
		return height(n.left) - height(n.right);
	}
	
	public Node insert(Node n, int key) {
		
		if(n==null)
			return(new Node(key));
		if(key<n.key)
			n.left = insert(n.left, key);
		else if(key > n.key)
			n.right = insert(n.right, key);
		else //duplicate keys not allowed
			return n;
		
		//update height
		n.height = 1 + maximum(height(n.left), height(n.right));
		
		//get balance
		int balance = balance(n);
		//left left case
		if(balance > 1 && key < n.left.key)
			return right(n);
		//right right case
		if(balance < -1 && key > n.right.key)
			return left(n);
		//left right case
		if(balance > 1 && key > n.left.key) {
			n.left = left(n.left);
			return right(n);
		}
		//right left case
		if(balance < -1 && key < n.right.key) {
			n.right = right(n.right);
			return left(n);
		}
		
		return n;
	}
	
	//preorder traversal
	public void preOrder(Node n) {
		if(n != null) {
			System.out.print(n.key + " ");
			preOrder(n.left);
			preOrder(n.right);
		}
	}
	
	public static void main(String[] args) {
		RotationBinary rotate = new RotationBinary();
		
		rotate.root = rotate.insert(rotate.root, 10);
		rotate.root = rotate.insert(rotate.root, 15);
		rotate.root = rotate.insert(rotate.root, 20);
		rotate.root = rotate.insert(rotate.root, 25);
		rotate.root = rotate.insert(rotate.root, 30);
		rotate.root = rotate.insert(rotate.root, 40);
		
		rotate.preOrder(rotate.root);
	}
	
	protected class Node{
		int key, height;
		Node left, right;
		
		public Node(int n){
			key = n;
			height = -1;
		}
	}
}
