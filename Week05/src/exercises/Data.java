package exercises;

public class Data extends Standard{
	 protected int data_usage;
     protected double dataRate;
     protected int data_limit;

     public Data()
     {
             super();
             this.data_usage = 0;
             this.dataRate = 0.0;
             this.data_limit = 0;
     }

     public Data(double tkRate, double txtRate,double dtRate)
     {
             super(tkRate, txtRate);
             this.data_usage = 0;
             this.dataRate = dtRate;
             this.data_limit = 0;
     }

     public void transfer(int n)
     {

             this.data_usage += n;
             if (this.data_usage > this.data_limit)
             System.out.println(" Data limit reached ");
     }

     public void setDataRate(double rate)
     {
             this.dataRate = rate;
     }

     public void setDataLimit(int limit)
     {
             this.data_limit = limit;
     }

     public String toString()
     {
             String rtnStr = String.format(
              " %s Data: [%d/%d] ", super.toString(),this.data_usage, this.data_limit);

             return rtnStr;
     }

     public double getTotal()
     {
             return super.getTotal()+ (this.data_usage * this.dataRate)/ 100;
     }
}


