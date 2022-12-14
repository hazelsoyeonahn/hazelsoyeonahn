package exercises;

public enum ScoreAction {
	
	//enums are static, constant which can be shared.
	
	TRY(5), CONVERSIONKICK(2), PENALTYKICK(3), DROPGOAL(3);
	
	private int score;
	
	private ScoreAction(int score)
	{
		this.score = score;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public String toString()
	{
		return ""+this.getScore();
	}
	
}
