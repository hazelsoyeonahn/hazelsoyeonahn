package exercises;

public class CoinChanger {
	private int ten;
	private int twenty;
	private int fifty;
	private int oneDollar;
	private int twoDollar;
	
	public CoinChanger(int ten, int twenty, int fifty, int oneDollar, int twoDollar) {
		this.setFifty(fifty);
		this.setTen(ten);
		this.setTwenty(twenty);
		this.setOneDollar(oneDollar);
		this.setTwoDollar(twoDollar);
	}
	
	public int getTen() {
		return ten;
	}

	public void setTen(int ten) {
		this.ten = ten;
	}

	public int getTwenty() {
		return twenty;
	}

	public void setTwenty(int twenty) {
		this.twenty = twenty;
	}

	public int getFifty() {
		return fifty;
	}

	public void setFifty(int fifty) {
		this.fifty = fifty;
	}

	public int getOneDollar() {
		return oneDollar;
	}
	
	public void setOneDollar(int oneDollar) {
		this.oneDollar = oneDollar;
	}

	public int getTwoDollar() {
		return twoDollar;
	}
	
	public void setTwoDollar(int twoDollar) {
		this.twoDollar = twoDollar;
	}

	
	public int computeChange() {
		int totalCents = ten*10 + twenty*20 + fifty*50 + oneDollar*100 + twoDollar*200;
		
		return totalCents;
	}
	
	public int dollars() {
		return this.computeChange()/100;
	}
	
	public int cents() {
		return this.computeChange()%100;
	}
	
	public String toString() {
		return "The total value of the coin collection is: $"+this.dollars()+"."+this.cents();
	}

}
