import java.util.Random;

public class ADTBagArrayBased<T> {
	private T[] bag;

	private final int CAPACITY = 15;

	int position;

	@SuppressWarnings("unchecked")

	public ADTBagArrayBased() {

	position = -1;

	bag = (T[]) new Object[CAPACITY];

	}

	public void insert(T item) {

	if (isFull()) {

	System.out.println("Cannot add " + item + ". Bag is full");

	} else {

	position++;

	bag[position] = item;

	System.out.println(item + " added to bag");

	}

	}

	public void removeLast() {

	if (isEmpty()) {

	System.out.println("Bag is empty");

	} else {

	bag[position] = null;

	position--;

	System.out.println("Item removed from bag");

	}

	}

	public void removeRandom() {

	Random r = new Random();

	int max = position;

	int min = 0;

	int index = r.nextInt((max - min) + 1) + min;

	if (index == position)

	removeLast();

	else {

	for (int i = index; i <= position; i++) {

	bag[i] = bag[i + 1];

	}

	bag[position] = null;

	position--;

	}

	System.out.println("Removed item at index " + index);

	}

	public T get(T item) {

	for (int i = 0; i <= position; i++) {

	if (bag[i].equals(item)) {

	return item;

	}

	}

	return null;

	}

	public T get(int index) {

	if (index >= 0 && index <= position) {

	return bag[index];

	} else {

	return null;

	}

	}

	public int size() {

	return position + 1;

	}

	public boolean isFull() {

	return position == bag.length - 1;

	}

	public boolean isEmpty() {

	return position == -1;

	}

	
}
