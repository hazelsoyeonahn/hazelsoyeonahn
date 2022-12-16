package lectureCode;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
	public static void main(String[] args) {
		Queue<Integer> line = new LinkedList<Integer>();
		line.add(1);
		line.add(9);
		line.add(13);
		line.remove();
		line.remove();

		Queue<Passenger00> passengers = new LinkedList<Passenger00>();
		// passengers arrive and form a queue

		passengers.add(new Passenger00("Carl"));
		passengers.add(new Passenger00("Darlene"));
		passengers.add(new Passenger00("Bob"));
		passengers.add(new Passenger00("Alice"));
		// gates open and passengers board the plane
		passengers.remove();
		passengers.remove();
	}
}