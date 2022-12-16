package lectureCode;

/**
 * 
 * @author Jamal and Kenneth Johnson
 *
 */
public class Boss extends Worker{
	private Worker[] team;
	private String[] administrationTasks;
	public String[] getAdministrationTasks() {
		return administrationTasks;
	}
	public void setAdministrationTasks(String[] administrationTasks) {
		this.administrationTasks = administrationTasks;
	}
	public Worker[] getTeam() {
		return team;
	}
	public void setTeam(Worker[] team) {
		this.team = team;
	}
}
