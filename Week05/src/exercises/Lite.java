package exercises;

public class Lite extends Data{
	        public Lite()
	        {
	                super();
	                super.data_limit = 1024;
	                super.setTalkLimit(20);
	                super.setTextLimit(56);
	        }

	        public Lite(double tkRate, double txtRate,double dtRate)
	        {
	                super(tkRate, txtRate, dtRate);
	                super.setDataLimit(1024);
	                super.setTalkLimit(20);
	                super.setTextLimit(56);
	        }

}
