package Task05_2;

public class Star {
	int i =1;

    public static void main(String[] args) {
        int max = 9;
        Star aStar = new Star();
        System.out.println("Figure:");
        
        Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while(aStar.i <=9) {
						aStar.printStar();
					}
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}       	
        });
        
        Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while(aStar.i <= 9) {
						aStar.printStar();
					}
				}catch(InterruptedException e) {
					e.printStackTrace();
				}				
			}       	
        });
        
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }

    private synchronized void printStar() throws InterruptedException{
    	if(Thread.currentThread().getName().equals("t1")) {
    		 //Print spaces
            for (int j = 0; j < (9 - i); j++) {
                System.out.print(" ");
            }
            notify();
            wait();
    	}
    	else if(Thread.currentThread().getName().equals("t2")) {
    		 //Print stars
            for (int j = 0; j < (2 * i - 1); j++) {
                System.out.print("*");
            } ++i;
            System.out.println();
            
            notify();
            wait();
    	}     
    }
}
