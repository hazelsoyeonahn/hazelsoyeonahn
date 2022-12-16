package lectureCode;

public class Kiwi implements Indigenous, Carnivore{
    public String getIndigenousName(){	
        return "Kiwi";
    }
    public String getIndigenousRegion(){
        return "New Zealand";
    }
    public String[] getDietList()
    {    	return new String[]{"Worms", "Huhu Grubs", "Ants", "Sand Mites"};
    }
}
