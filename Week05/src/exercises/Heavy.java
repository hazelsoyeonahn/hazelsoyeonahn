package exercises;

public class Heavy extends Data{
	 public Heavy()
     {
             super();
             super.setDataLimit(5120);
             super.setTalkLimit(30);
             super.setTextLimit(156);
     }

     public Heavy(double tkRate, double txtRate,
                     double dtRate)
     {
             super(tkRate, txtRate, dtRate);
             super.setDataLimit(5120);
             super.setTalkLimit(30);
             super.setTextLimit(156);
     }
}
