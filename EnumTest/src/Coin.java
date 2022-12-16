import java.util.Random;

public class Coin {
	protected Random gen;
	protected int face = 0;
	protected int a = 0;
	protected static int b = 0;
	
	public Coin() {
		gen = new Random();
	}
	
	public void flip() {
		face = gen.nextInt(2);
		a++;
		b++;
	}
	
	public int getFace() {
		return face;
	}
	
	public static int getB() {
		return b;
	}
	
	public int getA() {
		return a;
	}

}
