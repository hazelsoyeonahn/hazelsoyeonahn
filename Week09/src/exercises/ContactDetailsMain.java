package exercises;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;

public class ContactDetailsMain {
	public static void main(String[] args) {
		ArrayList<ContactDetails> contactDetails = new ArrayList<>();
		
		contactDetails.add(new ContactDetails(Relationship.FAMILY,"GwangKeun","Ahn","Samsung"));
		contactDetails.add(new ContactDetails(Relationship.FAMILY,"Woosun","Yun","Lotte"));
		contactDetails.add(new ContactDetails(Relationship.FAMILY,"Jungmin","Ahn","YupDDeock"));
		contactDetails.add(new ContactDetails(Relationship.FAMILY,"Juno","Jung","Mojo"));
		contactDetails.add(new ContactDetails(Relationship.COLLEAGUE,"Louise","Chapman","Atomic Coffee Roasters"));
		contactDetails.add(new ContactDetails(Relationship.COLLEAGUE,"Heesun","Lee","Atomic Coffee Roasters"));
		contactDetails.add(new ContactDetails(Relationship.FRIEND,"Bomi","Jung","No company"));
		
		//collection method
		Collections.sort(contactDetails);
		System.out.println("Printing sorted list by last name:");
		for(ContactDetails c : contactDetails) {
			System.out.println(c);
		}
		
		//getting minimum
		System.out.println("\nminimum:");
		System.out.println(Collections.min(contactDetails));
		
		//getting maximum
		System.out.println("\nmaximum:");
		System.out.println(Collections.max(contactDetails));
		
		//shuffle
		Collections.shuffle(contactDetails);
		System.out.println("\nshuffle:");
		for(ContactDetails c : contactDetails) {
			System.out.println(c);
		}
		
		//Sort relationship
		Collections.sort(contactDetails,compareByRelationship());
		System.out.println("\nsorted by relationship:");
		for(ContactDetails c : contactDetails) {
			System.out.println(c);
		}
	}

	private static Comparator compareByRelationship() {
		Comparator<ContactDetails> contactDetailsComparator = new Comparator<ContactDetails>() {
			public int compare(ContactDetails o1, ContactDetails o2) {
				return o2.getRelationship().compareTo(o1.getRelationship());
			}
		};
		return contactDetailsComparator;
	}
}
