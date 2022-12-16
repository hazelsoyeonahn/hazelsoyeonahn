package exercises;

public class Recursion {
	String plusString(String in) {
		String ch = Character.toString(in.charAt(0));
		if(in.length()==0) {
			return"";
		}
		if(in.length()==1) {
			return ch;
		}
		else {
			return ch+plusString(in.substring(1));
		}
	}
	int multiply(int a, int b) {
		if(b==0) {
			return 0;
		}
		return a+multiply(a,b-1);
	}
	String reverse(String in) {
		if(in.length() ==1) {
			return in;
		}
		return reverse(in.substring(1)+Character.toString(in.charAt(0)));
	}
	boolean ispal(String in) {
		if(in.length() == 0 || in.length() == 1) {
			return true;
		}
		if(in.charAt(0)!= in.charAt(in.length()-1)) {
			return false;
		}
		return ispal(in.substring(1,in.length()-1));
	}
	boolean contains(String in, char ch) {
		if(in.length() == 0) {
			return false;
		}
		if(in.charAt(0)==ch) {
			return true;
		}
		return contains(in.substring(1),ch);
	}
	boolean alphaContains(String in, char ch) {
		if(in.length() == 0) {
			return false;
		}
		if(in.charAt(0) == ch) {
			return true;
		}
		return contains(in.substring(1), ch);
	}
	int gcd(int n, int m) {
		if(n%m == 0) {
			return m;
		}
		if(m>n) {
			return gcd(m,n);
		}
		else {
			return gcd(m,n%m);
		}
	}
}
