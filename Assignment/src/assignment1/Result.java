package assignment1;

/*
 * This class stores Module and Grade objects
 * 
 * The class has a constructor, toString method, get and set methods.
 * 
 * @author Hazel Ahn 16945085
 */

public class Result {
	Module module;
	Grade grade;
	
	// a constructor for the Result class
	public Result(Module module, Grade grade) {
		this.module = module;
		this.grade = grade;
	}
	
	// a method to get Module
	public Module getModule() {
		return module;
	}
	
	// a method to set Module
	public void setModule(Module module) {
		this.module = module;
	}

	// a method to get Grade
	public Grade getGrade() {
		return grade;
	}

	// a method to set Grade
	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return ""+module+""+grade;
	}
	
	
}
