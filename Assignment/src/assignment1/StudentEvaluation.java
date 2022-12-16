package assignment1;

/*
 * a main class that contains the student informations and print out the results.
 * 
 * @author Hazel Ahn 16945085
 */

public class StudentEvaluation {

	public static void main(String[] args) {
		
		TechnicalSchool techSchool = new TechnicalSchool();
		
		// Robin's module informations
		Student robin = new Student("Robin");
		robin.addResultToTranscript(new Module(ModuleType.TAUGHT, "Programming", "PROG101", Level.ONE), Grade.C);
		robin.addResultToTranscript(new Module(ModuleType.TAUGHT, "Database Design", "DATA222", Level.TWO), Grade.C);
		robin.addResultToTranscript(new Module(ModuleType.TAUGHT, "Information Systems", "INSY313", Level.THREE), Grade.CPLUS);
		robin.addResultToTranscript(new Module(ModuleType.TAUGHT, "Web Services", "WEBS332", Level.THREE), Grade.CPLUS);
		robin.addResultToTranscript(new Module(ModuleType.SELF_STUDY, "Technology Application", "TECH103", Level.ONE), Grade.CPLUS);
		robin.addResultToTranscript(new Module(ModuleType.SELF_STUDY, "Model Checking", "MODC233", Level.TWO), Grade.CMINUS);
		robin.addResultToTranscript(new Module(ModuleType.SELF_STUDY, "Topology", "TOPG233", Level.TWO), Grade.CMINUS);
		robin.addResultToTranscript(new Module(ModuleType.PROJECT, "Web App Dev", "PROJ399", Level.THREE), Grade.APLUS);
		
		// print out Robin's result on the console
		System.out.println(robin);
		System.out.println(techSchool.isCertified(robin));
		System.out.println("\n");
		
		// Kate's module informations
		Student kate = new Student("Kate");
		kate.addResultToTranscript(new Module(ModuleType.TAUGHT, "Programming", "PROG101", Level.ONE), Grade.APLUS);
		kate.addResultToTranscript(new Module(ModuleType.TAUGHT, "Statistics", "STAT102", Level.ONE), Grade.AMINUS);
		kate.addResultToTranscript(new Module(ModuleType.SELF_STUDY, "Technology Applications", "TECH103", Level.ONE), Grade.BPLUS);
		kate.addResultToTranscript(new Module(ModuleType.SELF_STUDY, "Model Checking", "MODC233", Level.TWO), Grade.A);
		kate.addResultToTranscript(new Module(ModuleType.SELF_STUDY, "Topology", "TOPG233", Level.TWO), Grade.C);
		kate.addResultToTranscript(new Module(ModuleType.TAUGHT, "Database Design", "DATA222", Level.TWO), Grade.A);
		kate.addResultToTranscript(new Module(ModuleType.TAUGHT, "Information System", "INSY313", Level.THREE), Grade.BPLUS);
		kate.addResultToTranscript(new Module(ModuleType.TAUGHT, "Web Services", "WEBS332", Level.THREE), Grade.AMINUS);
		kate.addResultToTranscript(new Module(ModuleType.PROJECT, "Web App Dev", "PROG399", Level.THREE), Grade.B);
		kate.addResultToTranscript(new Module(ModuleType.CLIENT_PROJECT, "Great Code Company", "EXTO396", Level.THREE), Grade.B);
		
		// print out Kate's result on the console
		//System.out.println(kate);
		//System.out.println(techSchool.isCertified(kate));
		//System.out.println("\n");
		
		// Axel's module informations
		Student axel = new Student("Axel");
		axel.addResultToTranscript(new Module(ModuleType.TAUGHT, "Programming", "PROG101", Level.ONE), Grade.BPLUS);
		axel.addResultToTranscript(new Module(ModuleType.TAUGHT, "Statistics", "STAT102", Level.ONE), Grade.C);
		axel.addResultToTranscript(new Module(ModuleType.TAUGHT, "Database Design", "DATA222", Level.TWO), Grade.A);
		axel.addResultToTranscript(new Module(ModuleType.TAUGHT, "Information Systems", "INSY313", Level.THREE), Grade.AMINUS);
		axel.addResultToTranscript(new Module(ModuleType.TAUGHT, "Web Services", "WEB332", Level.THREE), Grade.A);
		axel.addResultToTranscript(new Module(ModuleType.SELF_STUDY, "Technology Applications", "TECH103", Level.ONE), Grade.D);
		axel.addResultToTranscript(new Module(ModuleType.SELF_STUDY, "Model Checking", "MODC233", Level.TWO), Grade.B);
		axel.addResultToTranscript(new Module(ModuleType.SELF_STUDY, "Topology", "TOPG233", Level.TWO), Grade.B);
		axel.addResultToTranscript(new Module(ModuleType.PROJECT, "Web App Dev", "PROJ399", Level.THREE), Grade.CMINUS);
		axel.addResultToTranscript(new Module(ModuleType.CLIENT_PROJECT, "Great Code Company", "EXTO396", Level.THREE), Grade.C);
		
		
		// print out Axel's results on the console
		System.out.println(axel);
		System.out.println(techSchool.isCertified(axel));
		System.out.println("\n");
		
		// Jim's module informations
		Student jim = new Student("Jim");
		jim.addResultToTranscript(new Module(ModuleType.TAUGHT, "Programming", "PROG101", Level.ONE), Grade.A);
		jim.addResultToTranscript(new Module(ModuleType.TAUGHT, "Statistics", "STAT102", Level.ONE), Grade.BPLUS);
		jim.addResultToTranscript(new Module(ModuleType.TAUGHT, "Database Design", "DATA222", Level.TWO), Grade.CPLUS);
		jim.addResultToTranscript(new Module(ModuleType.TAUGHT, "Object-Oriented Programming", "PROG202", Level.TWO), Grade.C);
		jim.addResultToTranscript(new Module(ModuleType.TAUGHT, "Information Systems", "INSY313", Level.THREE), Grade.C);
		jim.addResultToTranscript(new Module(ModuleType.TAUGHT, "Web Services", "WEBS332", Level.THREE), Grade.CPLUS);
		jim.addResultToTranscript(new Module(ModuleType.SELF_STUDY, "Technology Applications", "TECH103", Level.ONE), Grade.CMINUS);
		jim.addResultToTranscript(new Module(ModuleType.SELF_STUDY, "Theory of Computation", "THEO111", Level.ONE), Grade.D);
		jim.addResultToTranscript(new Module(ModuleType.SELF_STUDY, "Model Checking", "MODC233", Level.TWO), Grade.APLUS);
		jim.addResultToTranscript(new Module(ModuleType.SELF_STUDY, "Topology", "TOPG233", Level.TWO), Grade.A);
		jim.addResultToTranscript(new Module(ModuleType.SELF_STUDY, "Logic", "LOGI321", Level.THREE), Grade.B);
		jim.addResultToTranscript(new Module(ModuleType.PROJECT, "Web App Dev", "PROJ399", Level.THREE), Grade.BMINUS);
		jim.addResultToTranscript(new Module(ModuleType.CLIENT_PROJECT, "Great Code Company", "PROG101", Level.THREE), Grade.APLUS);
		
		// print out Jim's results on the console
		System.out.println(jim);
		System.out.println(techSchool.isCertified(jim));
		System.out.println("\n");
		
		
		// Check the functionality with different student informations
		// Hazel's module informations 
		Student hazel = new Student("Hazel");
		hazel.addResultToTranscript(new Module(ModuleType.TAUGHT, "Programming", "PROG101", Level.ONE), Grade.B);
		hazel.addResultToTranscript(new Module(ModuleType.TAUGHT, "Statistics", "STAT102", Level.ONE), Grade.APLUS);
		hazel.addResultToTranscript(new Module(ModuleType.TAUGHT, "Database Design", "DATA222", Level.TWO), Grade.A);
		hazel.addResultToTranscript(new Module(ModuleType.TAUGHT, "Objected-Oriented Programming", "PROG202", Level.TWO), Grade.APLUS);
		hazel.addResultToTranscript(new Module(ModuleType.TAUGHT, "Information Systemts", "INSY313", Level.THREE), Grade.APLUS );
		hazel.addResultToTranscript(new Module(ModuleType.SELF_STUDY, "Theory of Computation", "THEO111", Level.ONE), Grade.AMINUS);
		hazel.addResultToTranscript(new Module(ModuleType.SELF_STUDY, "Topology", "TOPG233", Level.TWO), Grade.APLUS);
		hazel.addResultToTranscript(new Module(ModuleType.TAUGHT, "Web Services", "WEB332", Level.THREE), Grade.A);
		hazel.addResultToTranscript(new Module(ModuleType.SELF_STUDY, "Logic", "LOGI321", Level.THREE), Grade.A);
		hazel.addResultToTranscript(new Module(ModuleType.PROJECT, "Web App Dev", "PRJ399", Level.THREE), Grade.APLUS);
		hazel.addResultToTranscript(new Module(ModuleType.SELF_STUDY, "Model Checking", "MODC233", Level.TWO), Grade.BMINUS);
		
		// print out Hazel's results on the console
		System.out.println(hazel);
		System.out.println(techSchool.isCertified(hazel));
		System.out.println("\n");
		
		// Juno's module information
		Student juno = new Student("Juno");
		juno.addResultToTranscript(new Module(ModuleType.TAUGHT, "Programming", "PROG101", Level.ONE), Grade.C);
		juno.addResultToTranscript(new Module(ModuleType.TAUGHT, "Database Design", "DATA222", Level.TWO), Grade.CPLUS);
		juno.addResultToTranscript(new Module(ModuleType.TAUGHT, "Object-Oriented Programming", "PROG202", Level.TWO), Grade.A);
		juno.addResultToTranscript(new Module(ModuleType.TAUGHT, "Information Systems", "INSY313", Level.THREE), Grade.C);
		juno.addResultToTranscript(new Module(ModuleType.TAUGHT, "Statistics", "STAT102", Level.ONE), Grade.AMINUS);
		juno.addResultToTranscript(new Module(ModuleType.TAUGHT, "Web Services", "WEBS332", Level.THREE), Grade.C);
		juno.addResultToTranscript(new Module(ModuleType.SELF_STUDY, "Technology Applications", "TECH103", Level.ONE), Grade.B);
		juno.addResultToTranscript(new Module(ModuleType.SELF_STUDY, "Model Checking", "MODC233", Level.TWO), Grade.APLUS);
		juno.addResultToTranscript(new Module(ModuleType.SELF_STUDY, "Logic", "LOGI321", Level.THREE), Grade.BMINUS);
		juno.addResultToTranscript(new Module(ModuleType.SELF_STUDY, "Topology", "TOPG233", Level.TWO), Grade.A);
		juno.addResultToTranscript(new Module(ModuleType.SELF_STUDY, "Theory of Computation", "THEO111", Level.ONE), Grade.D);
		juno.addResultToTranscript(new Module(ModuleType.CLIENT_PROJECT, "Great Code Company", "EXTO396", Level.THREE), Grade.D);
		
		// print out Juno's results on the console
		System.out.println(juno);
		System.out.println(techSchool.isCertified(juno));
	}

}
