package lectureCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterfaceTester {
	
	public static void printIndigenousNames(List<Indigenous> list) {
		for (Indigenous natives : list) {
			System.out.println(natives.getIndigenousName() + " are from " + natives.getIndigenousRegion());
		}
	}

	public static void printCarnivore(Carnivore c) {
		System.out.println(c.toString() + " is a carnivore and eats " + Arrays.toString(c.getDietList()));
	}

	public static void main(String[] args) {
		List<Indigenous> list = new ArrayList<Indigenous>();

		Kiwi kiwi = new Kiwi();
		Indigenous sf = new SilverFern();
		Cat cat = new Cat();
		Carnivore cat2 = new Cat();
		list.add(new Kauri());
		list.add(kiwi);
		list.add(sf);
		printIndigenousNames(list);
		printCarnivore(kiwi);
		printCarnivore(cat);
		printCarnivore(cat2);
	}
}
