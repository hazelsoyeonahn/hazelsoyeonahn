package ex2_2;

public class Element implements Comparable<Element>{
	public int value;
	
	public Element(int value) {
		this.value = value;
	}
	
	@Override
	public int compareTo(Element e) {
		if(this.value > e.value)
			return 1;
		else
			return 0;
	}
}
