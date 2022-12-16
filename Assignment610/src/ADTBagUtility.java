import java.io.File;

import java.util.Scanner;


public class ADTBagUtility {
	
	/**

	* Creates a bag of items, and change items in the bag, and displays items.

	*/

	public static void start() {

	ADTBagArrayBased list = new ADTBagArrayBased<Integer>();

	// Fill the bag.

	// A Scanner object must be used to read item information from a file.

	// Items need to be created before they are put into the bag.

	fillList(list);

	// Display items in the bag.

	displayList(list);

	}

	/**

	* Stores items into a bag.

	* @param list A reference to a bag

	*/

	public static void fillList(ADTBagArrayBased list){

	try (Scanner fileScan = new Scanner(new File("data.txt"))) {

	String line = "";

	System.out.println("Loading data from file..\nPlease wait..");

	while (fileScan.hasNext()) {

	line = fileScan.nextLine(); // one line of data

	Integer data = Integer.parseInt(line);

	list.insert(data);

	}

	}

	catch(Exception e) {

	e.printStackTrace();

	}

	//add items into the bag and/or remove items from the bag.

	//All operations in ADT Bag design must be used/tested here.

	//THE CODE BELOW IS FOR TESTING ONLY//

	System.out.println("After loading data from file bag:");

	displayList(list);

	System.out.println("\n\nAdding 4 more items");

	list.insert(130);

	list.insert(140);

	list.insert(150);

	list.insert(160);

	System.out.println("After adding more items to bag:");

	displayList(list);

	System.out.println("Removing last item..");

	list.removeLast();

	System.out.println("After removing last item from bag:");

	displayList(list);

	System.out.println("Removing random item..");

	list.removeRandom();

	System.out.println("After removing random item from bag:");

	displayList(list);

	System.out.println("Getting item at index 1 :" + list.get(1));

	System.out.println("Getting item 50(if available else null) :" + list.get((Integer)50));

	System.out.println("Getting item 150(if available else null) :" + list.get((Integer)150));//We get null since 150 was a removed from bag [removeLast()]

	}

	/**

	* Displays items in the bag.

	* @param list A reference to a bag

	*/

	public static void displayList(ADTBagArrayBased list){

	System.out.println("\n\nBAG CONTENTS:");

	for(int i = 0;i<list.size();i++) {

	System.out.println("Item " + (i+1) + ": " + list.get(i));

	}

	}


}
