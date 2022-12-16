package Exercises;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AppendingText {
	private static void append(String FileName, String text) {
		OutputStream out = null;
		try {
			out = new FileOutputStream(new File(FileName), true);
			out.write(text.getBytes(), 0, text.length());
		}catch(IOException e) {
			System.err.println("Error: Cannot read from file");
			e.printStackTrace();
		}finally {
			try {
				out.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		append("append.txt","This is Hazel's appended file. I am a Mathematical Engineering Science student.");
	}
}
