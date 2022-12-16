package ex1_4;
/*
 * This class implements RandomObtaionable class
 * and test its functionality.
 */

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomArrayList<E> extends ArrayList<E> implements RandomObtainable {

	public E getRandom() throws NoSuchElementException {
		Random random = new Random();
		return this.get(random.nextInt(this.size()));
	}

	public boolean removeRandom() throws UnsupportedOperationException {
		Random random = new Random();
		return this.remove(this.get(random.nextInt(this.size())));
	}

	public static void main(String[] args) {
		RandomArrayList<Integer> randomArray = new RandomArrayList();
		
		randomArray.add(2);
		randomArray.add(88);
		randomArray.add(77);
		randomArray.add(35);
		randomArray.add(25);
		randomArray.add(63);
		
		System.out.println("Array: "+randomArray);
		System.out.println("Remove random number..."+randomArray.removeRandom());
		System.out.println("Array: "+randomArray);
		System.out.println("Get random number..."+randomArray.getRandom());
	}
}
