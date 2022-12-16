package lectureCode;

import java.util.ArrayList;

public class ArrayListExample {
	public static void main(String[] args) {
		ArrayList sentence = new ArrayList();
		sentence.add("Hello");
		sentence.add("how");
		sentence.add("are");
		sentence.add("you");
		sentence.add("today?");
		sentence.add(1, "world");
		sentence.remove(2);

		ArrayList list = new ArrayList();
		list.add(new Integer(4));
		list.add(new Integer(10));
		list.add(new Integer(53));
		Integer i = (Integer) list.get(0);
		System.out.println(i.intValue());

		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(5);
		list2.add(6);
		list2.add(3);
		Integer sum = 0;
		for (int index = 0; index < list2.size(); index++) {
			Integer j = (Integer) list2.get(index);
			sum += j;
			System.out.println(j);
		}
	}
}