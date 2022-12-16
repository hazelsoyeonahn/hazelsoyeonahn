package assignment1;

/*
 * This class checks students grade then print the results out to console.
 * 
 * This class contains a static method Module[] semesterOneModuleOfferings() which returns a primitive array of 13 Module objects.
 * This class has a default constructor TechnicalSchool().
 * It has a get method of offerings variable.
 * It has a toString method.
 * This class contains isCertified method to check if student is certified.
 * And a method Module lookup(String) for searching codes.
 * 
 * @author Hazel Ahn 16945085
 */


public class TechnicalSchool {
	
	// maintains a private instance variable which stores the Semester 1 Modules based on Table 1
	private static Module[] offerings = new Module[] {
			new Module(ModuleType.TAUGHT, "Programming", "PROG101", Level.ONE),
			new Module(ModuleType.TAUGHT, "Database Design", "DATA222", Level.TWO),
			new Module(ModuleType.TAUGHT, "Object-Oriented Programming", "PROG202", Level.TWO),
			new Module(ModuleType.TAUGHT, "Information Systems", "INSY313", Level.THREE),
			new Module(ModuleType.TAUGHT, "Web Services", "WEBS332", Level.THREE),
			new Module(ModuleType.SELF_STUDY, "Technology Applications", "TECH103", Level.ONE),
			new Module(ModuleType.SELF_STUDY, "Theory of Computation", "THEO111", Level.ONE),
			new Module(ModuleType.SELF_STUDY, "Model Checking", "MODC233", Level.TWO),
			new Module(ModuleType.SELF_STUDY, "Topology", "TOPG233", Level.TWO),
			new Module(ModuleType.SELF_STUDY, "Logic", "LOGI321", Level.THREE),
			new Module(ModuleType.PROJECT, "Web App Dev", "PROJ399", Level.THREE),
			new Module(ModuleType.CLIENT_PROJECT, "Great Code Company", "EXTO396", Level.THREE),
	};
	
	// a method which returns a populated primitive array
	private static Module[] semesterOneModuleOfferings() {
		return offerings;
	}
	
	// a default constructor instantiates the offerings variable
	public TechnicalSchool () {
		offerings = TechnicalSchool.semesterOneModuleOfferings();
		
	}

	// get method for offerings variable
	public Module[] getOfferings() {
		return offerings;
	}
	
/**
	 * a method that looks up for the matching code
	 * 
	 * @param code a string of code
	 * @return return true if the student is certified with all of the conditions, otherwise false.
	 * @author Hazel Ahn
	 */
	int returnLookup = 0;
	public Module lookup(String code) {
		
		for(int x = 0; x < offerings.length; ++x) {
			if(code.equalsIgnoreCase(offerings[x].getCode())) {
				returnLookup = x;
			}
		}
		return offerings[returnLookup];
	}
	
/**	 a method that checks if this student is certified
	 * 
	 * @param student a array of Student object 
	 * @author Hazel Ahn
	 */
	public boolean isCertified (Student student) {
		Result results[] = student.getTranscript();
		
		int level1 = 0;
		int level2 = 0;
		int level3 = 0;
		int level4 = 0;
		int taught = 0;
		int selfStudy = 0;
		
		for(int y = 0; y < results.length; ++y) {
			Level level = results[y].getModule().getLevel();
			ModuleType moduleType = results[y].getModule().getType();
			boolean pass = results[y].getGrade().ispass();
			
			if(pass) {
				if(level == Level.ONE) {
					if((moduleType == ModuleType.SELF_STUDY )|| (moduleType == ModuleType.TAUGHT)) {
					++level1;
					}
				}
				else if(level == Level.TWO) {
					if(moduleType == ModuleType.SELF_STUDY) {
					++selfStudy;
					}
					++level2;
				}
				else if(level == Level.THREE) {
					if(moduleType == ModuleType.TAUGHT) {
					++taught;
					++level3;
				}
					else if((moduleType == ModuleType.PROJECT )||(moduleType == ModuleType.CLIENT_PROJECT) ) {
					++level4;
					++level3;
				}
					else if(moduleType == ModuleType.SELF_STUDY){
					++level3;
				}
					}
			}
		}
		if(level1 >= 3 && (level2 >= 3 && selfStudy > 1) && (level3 >= 4 && taught >= 2) && level4 >= 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "TechnicalSchool [returnThis=" + offerings[returnLookup] + "]";
	}
	
	
}
