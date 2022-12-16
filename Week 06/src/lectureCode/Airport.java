package lectureCode;

import java.util.PriorityQueue;
import java.util.Queue;

public class Airport {
	public static void board(Queue<Passenger> passengers) {
		while (!passengers.isEmpty())
			System.out.println(passengers.remove());
	}

	public static void main(String args[]) {
		Queue<Passenger> passengers = new PriorityQueue<Passenger>(20);
		passengers.add(new Passenger("Mike", RewardsClub.BRONZE));
		passengers.add(new Passenger("Bob", RewardsClub.GOLD));
		passengers.add(new Passenger("Alice", RewardsClub.SILVER));
		passengers.add(new Passenger("Jay", RewardsClub.GOLD));
		passengers.add(new Passenger("Robin Banks", RewardsClub.BRONZE));
		passengers.add(new Passenger("Ken", RewardsClub.NONMEMBER));
		board(passengers);
	}
}
