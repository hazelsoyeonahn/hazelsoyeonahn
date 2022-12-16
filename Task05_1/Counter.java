package Task05_1;
/*
 * The 2 threads manipulates one integer num value. 
 */

public class Counter {

    int num = 1;

    public static void main(String[] args) {
    	final Counter obj = new Counter();
    	Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while(obj.num <= 10) {
						obj.printNum();
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
					while(obj.num<=10) {
						obj.printNum();
					}
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
    	});
      
        t1.setName("odd");
        t2.setName("even");
        t1.start();
        t2.start();

    }

    public synchronized void printNum() throws InterruptedException{
       if(Thread.currentThread().getName().equals("odd")) {
    	   if(num%2 != 0) {
    		   System.out.println(num+" "); ++num;
    		   notify();
    	   }else {
    		   wait();
    	   }
       }else if(Thread.currentThread().getName().equals("even")) {
    	   if(num%2 == 0) {
    		   System.out.println(num+" "); ++num;
    		   notify();
    	   }else {
    		   wait();
    	   }
       }
    }

}
