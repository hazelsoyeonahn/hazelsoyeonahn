
public class SmallCOin extends Coin{
	public void flip() {
		face = gen.nextInt(2);
		a -= 2;
		b++;
	}
}
