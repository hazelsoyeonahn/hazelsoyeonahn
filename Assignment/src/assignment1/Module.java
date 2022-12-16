package assignment1;

/*
 * This simple class that maintains two instance variables 
 * storing string values representing title and code of paper.
 * And two enumeration variables of Level and ModuleType.
 * 
 * The class contains constructor, toString method, get and set method.
 * 
 * @author Hazel Ahn 16945085
 */
public class Module {
	private String title;
	private String code;
	private Level level;
	private ModuleType type;
	
	//constructor of this class
	public Module(ModuleType type, String title, String code, Level level) {
		this.title = title;
		this.code = code;
		this.level = level;
		this.type = type;
	}
	
	@Override
	public String toString(){
		return code+" ";
	}
	
	// a method to get the title
	public String getTitle() {
		return title;
	}
	
	// a method to set the title
	public void setTitle(String title) {
		this.title = title;
	}
	
	// a method to get the code
	public String getCode() {
		return code;
	}
	
	// a method to set the code
	public void setCode(String code) {
		this.code = code;
	}
	
	// a method to get the level
	public Level getLevel() {
		return level;
	}
	
	// a method to set the level
	public void setLevel(Level level) {
		this.level = level;
	}
	
	// a method to get the type
	public ModuleType getType() {
		return type;
	}
	
	// a method to set the type
	public void setType(ModuleType type) {
		this.type = type;
	}
}
