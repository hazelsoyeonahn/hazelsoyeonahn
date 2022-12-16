package ex5_1;

/*
 * Exercise 5.1
 */
import java.util.LinkedHashSet;

public class Student {
	Node[] hashTable;
	
	int size;
	int hashTableSize = 4;
	Node first;
	
	public Student() {
		hashTable = new Node[hashTableSize];
		this.size = 0;
	}
	
	//inner Node class
	static class Node{
		int key;
		Node next;
			
		Node(int key){
			this.key = key;
			this.next = null;
		}
	}
	
	//inserting Students
	public void insert(int key) {
		size++;
		int position = hash(key);
		
		Node node = new Node(key);
		Node start = hashTable[position];
		
		if(hashTable[position] == null) {
			hashTable[position] = node;
		}else {
			node.next = hashTable[position];
			hashTable[position] = node;
		}
		
		//keep call it until loadFactor satisfied
		loadFactor();
	}
	
	public int hash(Integer n) {
		int hashValue = n.hashCode();
		
		hashValue %= hashTable.length;
		
		if(hashValue < 0)
			hashValue += hashTable.length;
		return hashValue;
	}
	
	public int getSize() {
		int size =0;
		for(int i=0; i<hashTable.length; i++) {
			Node start = hashTable[i];
			while(start!=null) {
				size++;
				start = start.next;
			}
		}
		return size;
	}
	
	public void loadFactor() {
		int count = 0;
		for(int i=0; i<hashTable.length; i++) {
			if(hashTable[i]!=null)
				++count;
		}
		
		double loadFactor = (double)count/(double)hashTableSize;
		if(loadFactor >= 0.75) {
			//temp array
			int[] temp = new int[getSize()];
			int countTemp = 0;
			for(int i=0; i<hashTable.length; i++) {
				Node start = hashTable[i];
				
				while(start != null) {
					temp[countTemp] = start.key;
					start = start.next;
					++countTemp;
				}
			}
			//expend capacity
			hashTableSize *= 2;
			hashTable = new Node[hashTableSize];
			//save back make to newly declared hash table
			for(int i=0; i<temp.length; ++i)
				insert(temp[i]);
		}
	}
	
	public void printHashTable() {
		System.out.println();
		for(int i=0; i<hashTable.length; i++) {
			System.out.print("At "+ i +": ");
			
			Node start = hashTable[i];
			while(start!=null) {
				System.out.print(start.key+" ");
				start = start.next;
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int count = 0;
		Student st = new Student();
		
		String[] names = {"John", "Hazel","Hazel", "Juno", "Tom", "Jerry", "Maru", "Zion"};
		
		for(int i=0; i<names.length; i++) {
			st.insert(names[i].charAt(0));
		}
		
		st.printHashTable();
	}
}


