package exercises;

public class RugbyScoreTest {
	public static void main(String args[]) {
		RugbyScore blues = new RugbyScore("Blues");
		System.out.println(blues);
		blues.score(ScoreAction.TRY);
		System.out.println(blues);
		blues.score(ScoreAction.DROPGOAL);
		System.out.println(blues);

	}
}
