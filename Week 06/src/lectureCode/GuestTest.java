package lectureCode;

import java.util.Arrays;

public class GuestTest {
	public static void main(String[] args) {
		Guest bob = new Guest("bob", 12);
		Guest amy = new Guest("amy", 12);
		Guest andy = new Guest("andy", 15);
		if (bob.compareTo(amy) < 0)
			System.out.println("Guest Bob is less than Amy");
		else if (bob.compareTo(amy) > 0)
			System.out.println("Guest Bob is greater than Amy");

		if (bob.compareTo(andy) < 0)
			System.out.println("Guest Bob is less than Andy");
		else if (bob.compareTo(andy) > 0)
			System.out.println("Guest Bob is greater than Andy");

		// NEW TEST, Arrays sorting via Comparable 6 cake pieces, 1 cant eat
		final int CAKE_PIECES = 6;
		Guest[] guests = new Guest[7];
		guests[0] = new Guest("Bob", 12);
		guests[1] = new Guest("Amy", 12);
		guests[2] = new Guest("Andy", 15);
		guests[3] = new Guest("Simon", 15);
		guests[4] = new Guest("Nana Betty", 99);
		guests[5] = new Guest("Sarah", 6);
		guests[6] = new Guest("Zoe", 13);
		// will sort guests using thier comparable compareTo method
		Arrays.sort(guests);

		for (int i = 0; i < guests.length; i++) {
			if (i < CAKE_PIECES)
				System.out.println("CAKE piece for " + guests[i]);
			else
				System.out.println("NO CAKE FOR " + guests[i]);
		}

	}

}
