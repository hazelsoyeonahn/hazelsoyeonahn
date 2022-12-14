package exercises;

public class NitFluxTest {
	public static void main(String[] args) {
		NitFluxAccount customer1 = new NitFluxAccount("junojung@hotmail.com", 6);
		NitFluxAccount customer2 = new NitFluxAccount("hazelsoyeonahn@hotmail.com", 24);
		NitFluxAccount customer3 = new NitFluxAccount("sophiaiman@hotmail.com", 12);
		
		System.out.println(customer1.computeCostumerPay());
		System.out.println(customer2.computeCostumerPay());
		System.out.println(customer3.computeCostumerPay());
		
	}
}
