package lectureCode;

import java.util.Iterator;

public class TextTest {
	public static void main(String[] args) {
		Text text = new Text("The quick brown fox jumped over the lazy dog");
		Iterator<Character> it = text.getCharacterIterator();
		while (it.hasNext())
			System.out.println("> " + it.next());
	}

}
