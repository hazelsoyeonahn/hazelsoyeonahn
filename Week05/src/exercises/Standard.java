package exercises;

public class Standard {
	protected int talk_time;
    protected int text_count;

    protected double talkRate;
    protected double textRate;

    protected int talk_limit;
    protected int text_limit;

    public Standard()
    {
            this.talk_time = 0;
            this.text_count = 0;
            this.talkRate = 0.0;
            this.textRate = 0.0;
            this.talk_limit = 10;
            this.text_limit = 100;
    }

    public Standard(double tRate, double txtRate)
    {
            this.talk_time = 0;
            this.text_count = 0;
            this.talkRate = tRate;
            this.textRate = txtRate;
            this.talk_limit = 10;
            this.text_limit = 100;

    }

    public void talk(int mins)
    {

            this.talk_time += mins;
            if (this.talk_time > this.talk_limit)
            System.out.println(" Talk limit reached");
    }

    public void sendTexts(int text_count)
    {
            this.text_count += text_count;
            if (this.text_count > this.text_limit)
            System.out.println(" Text limit reached ");
    }

    public void setTalkRate(float talkRate)
    {
            this.talkRate = talkRate;
    }

    public void setTextRate(float textRate)
    {
            this.textRate = textRate;
    }

    public void setTalkLimit(int n)
    {
            this.talk_limit = n;
    }

    public void setTextLimit(int n)
    {
            this.text_limit = n;
    }

    public String toString()
    {
            String rtnStr = String.format(
             " Talk : [%d/%d] Text: [%d/%d] ",this.talk_time, this.talk_limit,this.text_count, this.text_limit);

            return rtnStr;
    }

    public double getTotal()
    {
            return (this.talkRate * this.talk_time+ this.textRate * this.text_count)/ 100;
    }
}


