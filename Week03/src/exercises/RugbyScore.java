package exercises;

public class RugbyScore {
	private String teamName;
	private int score;
	
	public RugbyScore(String teamName) {
		this.teamName = teamName;
		this.score = 0;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public void score(ScoreAction scoreaction) {
		 this.score += scoreaction.getScore();
	}
	
	public String toString() {
		return "The score is "+this.score;
	}
	
}
