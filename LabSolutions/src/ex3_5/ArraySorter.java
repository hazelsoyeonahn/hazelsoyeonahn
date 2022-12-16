package ex3_5;

import java.util.ArrayList;
import java.util.List;

public class ArraySorter<E extends Comparable> {
	
	private E[] elements;
	
	public ArraySorter(E[] List) {
		this.elements = elements;
	}
	
	public void selectionSort(E[] list) {
		int indexMin;
		E temp;
		for(int i=0; i<list.length-1; i++) {
			indexMin = i;
			for(int j=i+1; j<list.length; j++) {
				if(list[j].compareTo(list[indexMin])<0)
					indexMin = j;
			}
			//swap the element at indexMin with the element at i
			temp = list[indexMin];
			list[indexMin] = list[i];
			list[i] = temp;
		}
	}
	
	public void insertionSort(E[] list) {
		E elementInsert;
		for(int i=1; i<list.length; i++) {
			//get the element at index i to insert at some index <=i
			elementInsert = list[i];
			//find index where to insert element to maintain 0..i sorted
			int indexInsert = i;
			while(indexInsert>0 && list [indexInsert - 1].compareTo(elementInsert)>0) {
				//shift element at insertIndex-1 along one to make space
				list[indexInsert] = list[indexInsert-1];
				indexInsert--;
			}
			//insert the element
			list[indexInsert] = elementInsert;
		}
	}
	
	public void bubbleSort(E[] list) {
		E temp;
		for(int i=list.length-1; i>=0; i--) {
			//pass through indices 0..i and bubble (swap) adjacent
			//elements if out of order
			for(int j=0; j<i; j++) {
				if(list[j].compareTo(list[j+1])>0) {
					//swap the elements at indices j and j+1
					temp = list[j+1];
					list[j+1] = list[j];
					list[j] = temp;
				}
			}
		}
	}
	
	public void quickSort(E[] list) {
		quickSortSegment(list,0,list.length);
	}
	
	//recursive method which applies quick sort to the portion
	//of the array between start (inclusive) and end (exclusive)
	private void quickSortSegment(E[] list, int start, int end) {
		if(end-start>1)//then more than one element to sort
		{//partition the segment into two segments
			int indexPartition = partition(list,start,end);
			//sort the segment to the left of the partition element
			quickSortSegment(list, start, indexPartition);
			//sort the segment to the right of the partition element
			quickSortSegment(list,indexPartition+1, end);
		}
	}
		
		//use the index start to partition the segment of the list
		//with the element at start as the partition element
		//separating the list segment into two parts, one less than
		//the partition, the other greater than the partiton
		//returns the index where the partition element ends up
		private int partition(E[] list, int start, int end) {
			E temp; 
			E partitionElement = list[start];
			int leftIndex = start; //start at the left end
			int rightIndex = end-1; //start at the right end
			//swap elements so elements at left part are less than
			//partition element and at right part are greater
			while(leftIndex<rightIndex) {
				//find element starting from left greater than partition
				while(list[leftIndex].compareTo(partitionElement) <= 0 && leftIndex<rightIndex)
					leftIndex++; //this index is on correct side of partition
				//find element starting from right less than partition
				while(list[rightIndex].compareTo(partitionElement)>0)
					rightIndex--; //this index is on correct side of partiton
				if(leftIndex<rightIndex)
				{//swap these two elements
					temp = list[leftIndex];
					list[leftIndex] = list[rightIndex];
					list[rightIndex] = temp;
				}
			}
			//put the partition element between the two parts at  rightIndex
			list[start] = list[rightIndex];
			list[rightIndex] = partitionElement;
			return rightIndex;
	}
		
		public void mergeSort(E[] list) {
			mergeSortSegment(list, 0, list.length);
		}
		
		//recursive method whicih applies merge sort to the portion
		//of the array between start (inclusive) and end (exclusive)
		private void mergeSortSegment(E[] list, int start, int end) {
			int numElements = end-start;
			if(numElements>1) {
				int middle = (start+end)/2;
				//sort the part the he left of middle
				mergeSortSegment(list,start,middle);
				//sort the part to the right tof middle
				mergeSortSegment(list,middle,end);
				//copy the two parts elements into a temporary array
				E[] tempList = (E[])(new Comparable[numElements]); //unchcked
				for (int i=0; i<numElements; i++)
					tempList[i] = list[start+i];
				//merge the two sorted parts from tempList back into list
				int indexLeft = 0; //current index of left part
				int indexRight = middle-start; //current index of right part
				
				for(int i=0; i<numElements; i++) {
					//determine which element to next put in list
					if(indexLeft<(middle-start))//left part still has elements
					{ if(indexRight<(end-start))//right part still has elements
						{	if(tempList[indexLeft].compareTo(tempList[indexRight])<0) //left element smaller
							{list[start+i] = tempList[indexLeft++];}
						else // right element smaller
							{list[start+i] = tempList[indexRight++];}
						}
					else //take element from left part
					{
							list[start+i] = tempList[indexLeft++];
						}
					}else //take element from right part
					{
						list[start+i] = tempList[indexRight++];
					}
				}
			}
		}
		
		public static void main(String[] args) {
			long start;
			long end;
			
			System.out.println("Time complexity for each sort method with Randomly ordered list: \n");
			
			String[] RandomList = {"bat", "cow", "rat", "owl", "ant", "pig", "fox", "cat", "eel", "dog", "fly"};
			
			ArraySorter<String>  st1 = new ArraySorter<String>(RandomList);
			
			//selection sort
			System.out.println("Selection sort: ");
			start = System.nanoTime();
			st1.selectionSort(RandomList);
			end = System.nanoTime();
			System.out.println((end-start)+" nanoseconds.\n");
		
			//insertion sort
			System.out.println("Insertion sort: ");
			start = System.nanoTime();
			st1.insertionSort(RandomList);
			end = System.nanoTime();
			System.out.println((end-start)+" nanoseconds.\n");
			
			//bubble sort
			System.out.println("Bubble sort: ");
			start = System.nanoTime();
			st1.bubbleSort(RandomList);
			end = System.nanoTime();
			System.out.println((end-start)+" nanoseconds.\n");
			
			//quick sort
			System.out.println("Quick sort: ");
			start = System.nanoTime();
			st1.quickSort(RandomList);
			end = System.nanoTime();
			System.out.println((end-start)+" nanoseconds.\n");
			
			//merge sort
			System.out.println("Merge sort: ");
			start = System.nanoTime();
			st1.mergeSort(RandomList);
			end = System.nanoTime();
			System.out.println((end-start)+" nanoseconds.");
			
			System.out.println("===============================================================");
			System.out.println("Time complexity for each sort method with almost ordered list: \n");
			
			String[] orderedList = {"ant", "bat","cat", "cow", "eel", "dog", "fly", "fox"};
			
			ArraySorter<String>  st2 = new ArraySorter<String>(orderedList);
			
			//selection sort
			System.out.println("Selection sort: ");
			start = System.nanoTime();
			st2.selectionSort(orderedList);
			end = System.nanoTime();
			System.out.println((end-start)+" nanoseconds.\n");
		
			//insertion sort
			System.out.println("Insertion sort: ");
			start = System.nanoTime();
			st2.insertionSort(orderedList);
			end = System.nanoTime();
			System.out.println((end-start)+" nanoseconds.\n");
			
			//bubble sort
			System.out.println("Bubble sort: ");
			start = System.nanoTime();
			st2.bubbleSort(orderedList);
			end = System.nanoTime();
			System.out.println((end-start)+" nanoseconds.\n");
			
			//quick sort
			System.out.println("Quick sort: ");
			start = System.nanoTime();
			st2.quickSort(orderedList);
			end = System.nanoTime();
			System.out.println((end-start)+" nanoseconds.\n");
			
			//merge sort
			System.out.println("Merge sort: ");
			start = System.nanoTime();
			st2.mergeSort(orderedList);
			end = System.nanoTime();
			System.out.println((end-start)+" nanoseconds.");
			
			System.out.println("===============================================================");
			System.out.println("Time complexity for each sort method with decreasing ordered list: \n");
			
			String[] decreaseList = {"fox", "fly", "eel", "dog", "cow", "cat", "bat", "ant"};
			
			ArraySorter<String> st3 = new ArraySorter<String>(decreaseList);
			
			//selection sort
			System.out.println("Selection sort: ");
			start = System.nanoTime();
			st3.selectionSort(decreaseList);
			end = System.nanoTime();
			System.out.println((end-start)+" nanoseconds.\n");
		
			//insertion sort
			System.out.println("Insertion sort: ");
			start = System.nanoTime();
			st3.insertionSort(decreaseList);
			end = System.nanoTime();
			System.out.println((end-start)+" nanoseconds.\n");
			
			//bubble sort
			System.out.println("Bubble sort: ");
			start = System.nanoTime();
			st3.bubbleSort(decreaseList);
			end = System.nanoTime();
			System.out.println((end-start)+" nanoseconds.\n");
			
			//quick sort
			System.out.println("Quick sort: ");
			start = System.nanoTime();
			st3.quickSort(decreaseList);
			end = System.nanoTime();
			System.out.println((end-start)+" nanoseconds.\n");
			
			//merge sort
			System.out.println("Merge sort: ");
			start = System.nanoTime();
			st3.mergeSort(decreaseList);
			end = System.nanoTime();
			System.out.println((end-start)+" nanoseconds.");
		}
}

