/*
 * Class for a guest with ordering via age first then via name
 */
package lectureCode;

import java.util.Arrays;

public class Guest implements Comparable<Guest> {
	private String name;
	private int age;

	public Guest(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return name + " aged: " + age;
	}

	// Compare guests to give Age order, if age the same then via name
	public int compareTo(Guest other) {
		if (age == other.age) {
			return name.compareTo(other.name);
		} else
			return age - other.age;
	}
}
