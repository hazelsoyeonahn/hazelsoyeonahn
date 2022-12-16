package ex3_4;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class BinarySearchList {
	
	static void search(ListIterator<Integer> iterator, int n, int item, char c) {
		int half = n/2;
		int current = 0;
		
		if(n == 0)
			return;
		
		if(c == 'R') {
			System.out.println("\nMove "+half+" position to the right");
			for(int i=0; i<half-1; i++) {
				iterator.next();
			}
			current = iterator.nextIndex();
		}else {
			System.out.println("\nMove "+half+" position to the left");
			for(int i=0; i<half-1; i++) {
				iterator.previous();
			}
			current = iterator.previous();
		}
		
		System.out.println("Comparing.."+current+" and "+item);
		if(current == item)
			System.out.println("Item found");
		else if(current < item) {
			if(half != 0) {
				if(c == 'R')
					search(iterator, n-half, item, 'R');
				else {
					iterator.next();
					search(iterator, n-half, item, 'R');
				}
			}
		}else {
			if(half != 0) {
				if(c == 'L')
					search(iterator, n-half, item, 'L');
				else {
					iterator.previous();
					search(iterator, n-half, item, 'L');
				}
			}
		}
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			System.out.print((10*i) + " ");
			list.add(10*i);
		}
		
		int size = list.size();
		ListIterator<Integer> iterator = list.listIterator();
		search(iterator, size, 36, 'R');
	}

}
