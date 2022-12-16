
package lectureCode;

import java.util.Iterator;

public class Text {
	private String text;

	public Text(String text) {
		if (text == null)
			text = ""; // ensure text is not null
		this.text = text;
	}

	// return an Iterator (demo of polymorphism via interfaces)
	public Iterator<Character> getCharacterIterator() {
		return new CharacterIterator(text);
	}

	private class CharacterIterator implements Iterator<Character> {
		private String chars;
		private int position;

		public CharacterIterator(String chars) {
			this.chars = chars;
			position = 0;
		}

		public boolean hasNext() {
			return (position < chars.length());
		}

		public Character next() { // return character at position and then increment position
			return new Character(chars.charAt(position++));
		}

		public void remove() { // Empty method, so cannot remove a character
		}
	}
}
