package ex2_1;

public class ArraySet {
	private int[] array;
	private int number;
	
	public ArraySet(int number) {
		this.number = number;
		array = new int[this.number];
	}
	
	public int contains(int n) {
		for(int i=0; i<this.number; i++) {
			if(this.array[i] == n)
				return i;
		}
		return -1;
	}
	
	public void add() {
		for(int i=0; i<this.number; i++) {
			this.array[i] = i;
		}
	}
	
	public void remove(int n) {
		int i = 0;
		for(i=0; i<this.number; i++) {
			if(this.array[i] == n)
				break;
		}
		while(i < this.number-1) {
			array[i] = array[i+1];
			i++;
		}
		array[i] = 0;
		this.number -= 1;
	}
	
	public static void main(String[] args) {
		int n = 0;
		long start, end;
		ArraySet set;
		
		while(n<1000) {
			n += 100;
			System.out.println("Running for number: "+ n);
			set = new ArraySet(n);
			
			start = System.nanoTime();
			set.add();
			end = System.nanoTime();
			System.out.println("Add method: "+(end-start));
			
			start = System.nanoTime();
			int half = set.contains(n/2);
			end = System.nanoTime();
			System.out.println("Contains method: "+(end-start));
			
			start = System.nanoTime();
			set.remove(n/2);
			end = System.nanoTime();
			System.out.println("Remove method: "+(end-start));

		}
	}
}
