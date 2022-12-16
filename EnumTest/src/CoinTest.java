
public class CoinTest {

	public static void main(String[] args) {
		Coin c1 = new SmallCOin();
		Coin c2 = new BigCoin();
		for(int i = 0; i < 4; i++) {
			c1.flip();
		}
		for (int i = 0; i < 6; i++) {
			c2.flip();
		}
		System.out.println(c1.getA());
		System.out.println(c2.getA());
		System.out.println(Coin.getB());

	}

}
