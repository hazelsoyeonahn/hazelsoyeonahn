package examples;


import java.util.Scanner;

public class EncryptTest {
    public static void main(String[] args)
    {   
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter your plaintext message");
//        String plaintext = scan.nextLine();
//        System.out.println("Enter your plaintext message");
//        
        Message m = new Message("Shhh this is a secret message!",false);
        m.encrypt("SecretKey123".toCharArray());
        System.out.println(m);
        m.decrypt("SecretKey123".toCharArray());
        System.out.println(m);
    }
}
