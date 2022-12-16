package examples;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Message implements Encryptable {

	public String message;
	public boolean isEncrypted;

	public Message(String message, boolean encrypted) {
		this.message = message;
		isEncrypted = encrypted;
	}

	public void encrypt(char[] key) {
		if (!isEncrypted) { // String builder used to hold Encrypted String
			StringBuilder encrypted = new StringBuilder();
			isEncrypted = true;
			// loop through each char
			for (int i = 0; i < message.length(); i++) {
				char current = message.charAt(i);
				// check if the current char between printable ascii values
				if (current >= 33 && current <= 126) {
					current -= 33; // keep first character the value 0
					// add on current key at position i mod length of key
					current += key[i % key.length];
					// mod to keep char in range 33-126 (keyboard characters)
					current = (char) ((int) current % 94 + 33);
					encrypted.append(current);
				} else
					encrypted.append(current);
			}
			message = encrypted.toString();
		}
	}

	public void decrypt(char[] key) {
		if (isEncrypted) {
			isEncrypted = false;
			StringBuilder decrypted = new StringBuilder();
			for (int i = 0; i < message.length(); i++) {
				char current = message.charAt(i);
				if (current >= 33 && current <= 126) {
					current -= 33;
					current += 282; // done to keep value positive (3*94)
					current -= key[i % key.length];
					current = (char) ((int) current % 94 + 33);
					decrypted.append(current);
				} else
					decrypted.append(current);
			}
			message = decrypted.toString();
		}
	}

	public boolean isEncrypted() {
		return isEncrypted;
	}

	public String toString() {
		return message;
	}

	public static void main(String[] args) {
		int choice = 0;
		do {
			choice = JOptionPane.showOptionDialog(null, "What do you Wanna do?", "Choose an Option",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
					new String[] { "Encrypt", "Decrypt", "Quit" }, "Encrypt");
			if (choice == 0 || choice == 1) {
				String text = JOptionPane.showInputDialog("Enter your Plaintext or Ciphertext Message ");
				String password = JOptionPane.showInputDialog("Enter your Password key");

				Message m = new Message(text, choice == 1);
				String status = "Encrypted";
				if (choice == 0) {
					m.encrypt(password.toCharArray());
					System.out.println("Encrypted Message:" + m.toString());
				} else {
					m.decrypt(password.toCharArray());
					status = "Decrypted";
					System.out.println("Decrypted Message:" + m.toString());
				}
				JOptionPane.showMessageDialog(null, m.toString(), status, JOptionPane.INFORMATION_MESSAGE);
				System.out.println(m.toString());
			}
		} while (choice != 2 && choice != JOptionPane.CLOSED_OPTION);
	}
}
