package pro;
import java.awt.List;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileSorter<E extends Comparable>{
	
	int limit;
	String fileName;
	
	public FileSorter(int limit, String fileName) {
		this.limit = limit;
		this.fileName = fileName;
	}
	
	@SuppressWarnings("null")
	public static void readFile(int limit, String fileName) throws IOException {

		//reading txt file
		String content = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
	//	System.out.println(content); //printing the whole 
		
		//split the file
		String[] splitString = content.split(" ");
		//declare an array of string to creat new string with limit;
		
		//count until reach the limit then move to next array
		int count =0;
		//count for new String
		int spCount = 0;
		//count how many arrays are there in splitString
		int spStringCount = 0;
		for (String s : splitString) {
		  //  System.out.println(s);  //printing splitString
		    ++spStringCount;
		}
		String[] splitLimit = new String[limit];
		String tempFile = "file";
		String[] readFile = new String[spStringCount];
		int fileCount = 0;
		for (int i=0; i<spStringCount; ++i) {
		splitLimit[spCount] = splitString[i];
		++count;
		++spCount;
		//make sure to output file in limited number of strings.
			if(spCount == limit) {
				sort(splitLimit);
				//printArray(splitLimit);
				System.out.println("\n");
				spCount = 0;
				File temp = File.createTempFile(tempFile+count, ".txt");
				BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
				 for(int j =0; j<limit; j++) {
					bw.write(splitLimit[j]+" ");
				 }
				 bw.close();
					//read file
				 BufferedReader br = new BufferedReader(new FileReader(temp));
				  while((readFile[fileCount] = br.readLine()) != null){
				   System.out.println("File Output:" + readFile[fileCount]);
				   ++fileCount;
				  }	
			}
			//mergeSort(readFile);
		}
}

	public static void sort(String[] splitLimit) {
		quickSort(splitLimit, 0, splitLimit.length);
	}
	
	private static void quickSort(String[] splitLimit, int start, int end) {
		if(end-start>1) {
			int indexPartition = partition(splitLimit, start, end);
			quickSort(splitLimit, start, indexPartition);
			quickSort(splitLimit, indexPartition+1, end);
		}
	}
	
	private static int partition(String[] splitLimit, int start, int end) {
		String temp;
		String partitionElement = splitLimit[start];
		int leftIndex = start;
		int rightIndex = end-1;
		
		while(leftIndex<rightIndex) {
			while(splitLimit[leftIndex].compareTo(partitionElement)<=0 && leftIndex<rightIndex)
				leftIndex++;
			while(splitLimit[rightIndex].compareTo(partitionElement)>0)
				rightIndex--;
			if(leftIndex<rightIndex) {
				temp = splitLimit[leftIndex];
				splitLimit[leftIndex] = splitLimit[rightIndex];
				splitLimit[rightIndex] = temp;
			}
		}
		splitLimit[start] = splitLimit[rightIndex];
		splitLimit[rightIndex] = partitionElement;
		return rightIndex;
	}

	public static void mergeSort(String[] readFile) {
		mergeSortSegment(readFile, 0, readFile.length);
	}


	private static void mergeSortSegment(String[] readFile, int start, int end) {
		int numElements = end-start;
		if (numElements>1) {
			int middle = (start+end)/2;
			//sort the part to the left of middle
			mergeSortSegment(readFile, start, middle);
			//sort the part to the right of middle
			mergeSortSegment(readFile, middle, end);
			//copy the two parts elements into a temporary array
			String[] tempList = (String[]) (new Comparable[numElements]); //unchecked
			for(int i=0; i<numElements; i++)
				tempList[i] = readFile[start+i];
			//merge the two sorted parts from tempList back into list
			int indexLeft = 0; //current index of left part
			int indexRight = middle-start; //current index of right
			
			for(int i=0; i<numElements; i++) {
				//determine which element to next put in list
			if(indexLeft<(middle-start)) //left part still has elements
			{
				if(indexRight<(end-start))//right part also has elem
				{
					if(tempList[indexLeft].compareTo(tempList[indexRight])>0)//left element smaller
						readFile[start+i] = tempList[indexLeft++];
					else//right element smaller
						readFile[start+i] = tempList[indexRight++];
				}
				else //take element from left part
					readFile[start+i] = tempList[indexLeft++];
			}
			else //take element from right part
				readFile[start+i] = tempList[indexRight++];
			}
		}
		
	}

	public static void printArray(String[] splitLimit) {
		for(String i : splitLimit) {
			System.out.print(i+" ");
		}
	}
	
	
	public static void main(String[] args) throws IOException {

		readFile(20,"append.txt");
	}
		
	
}
