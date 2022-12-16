package lectureCode;

public class Passenger implements Comparable<Passenger> {
	private String name;
	private RewardsClub membership;

	public Passenger(String name, RewardsClub membership) {
		this.name = name;
		this.membership = membership;
	}

	public String toString() {
		return this.name + " (" + this.membership + ")";
	}

	@Override
	public int compareTo(Passenger o) {
		return this.membership.compareTo(o.membership);
	}
}
