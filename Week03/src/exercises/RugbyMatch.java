package exercises;

public class RugbyMatch {
	
	private ScoreAction scoreactionHome;
	private ScoreAction scoreactionOpp;
	private RugbyScore homeScore;
	private RugbyScore oppScore;
	private int score = 0;
	
	public RugbyMatch (RugbyScore homeScore, RugbyScore oppScore) {
		this.homeScore = homeScore;
		this.oppScore = oppScore;
	}
	
	public void homeScore(ScoreAction scoreactionHome) {
		this.scoreactionHome = scoreactionHome;
	}
	
	public void oppScore(ScoreAction scoreactionOpp) {
		this.scoreactionOpp = scoreactionOpp;
	}

	public ScoreAction getScoreactionHome() {
		return scoreactionHome;
	}

	public void setScoreactionHome(ScoreAction scoreactionHome) {
		this.scoreactionHome = scoreactionHome;
	}

	public ScoreAction getScoreactionOpp() {
		return scoreactionOpp;
	}

	public void setScoreactionOpp(ScoreAction scoreactionOpp) {
		this.scoreactionOpp = scoreactionOpp;
	}


	public RugbyScore getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(RugbyScore homeScore) {
		this.homeScore = homeScore;
	}

	public RugbyScore getOppScore() {
		return oppScore;
	}

	public void setOppScore(RugbyScore oppScore) {
		this.oppScore = oppScore;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public String toString() {
	
		return this.homeScore+" won over "+this.oppScore+" "+this.scoreactionHome+"-"+this.scoreactionOpp;
	}
	
}