
public class BigCoin extends Coin{
	public void flip(){
		super.flip();
		face = gen.nextInt(2);
	}

}
