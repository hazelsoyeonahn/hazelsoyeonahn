package assignment1;

/*
 *  This class maintains an array of results, called a transcript
 *  
 *  The class contains a String instance variable that represents student's name,
 * 	static integer value for maximum transcript length,
 * 	an integer instance variable that represents a number of result,
 * 	an array of Result class array
 * 
 * 	@author Hazel Ahn 16945085
 */

public class Student {
	
	private String name;
	private static int MAX_TRANSCRIPT_LENGTH = 20;
	private int nResults = 0;
	private Result[] transcript = new Result[20];
	TechnicalSchool techSchool;

	// a constructor initializes name
	public Student(String name) {
		this.name = name;
	}

/**
 * This class creates a Result object and updates the number of results
 * 
 * @param module module of a student
 * @param grade the grade of a student
 * @author Hazel Ahn
 */
	
	public void addResultToTranscript(Module module, Grade grade) {
		
		transcript[nResults] = new Result(module, grade);
		++nResults;
	}

	// a method to get name
	public String getName() {
		return name;
	}
	
	// a method to set name
	public void setName(String name) {
		this.name = name;
	}
	
	// a method to get the number of result
	public int getnResults() {
		return nResults;
	}
	
	// a method to set the number of result
	public void setnResults(int nResults) {
		this.nResults = nResults;
	}

/**
 * a method to get the result object of transcript.
 * this method restricts the null pointers.
 * 
 * @return non-null pointed transcripts
 */
	public Result[] getTranscript() {
		Result[] gTranscript = new Result[nResults];
		int x = 0;
		for(int y = 0; y < MAX_TRANSCRIPT_LENGTH; ++y){
			if(transcript[y]!=null) {
				gTranscript[x] = transcript[y];
				++x;
			}
		}
		return gTranscript;
	}
	
	// a method to set the transcript
	public void setTranscript(Result[] transcript) {
		this.transcript = transcript;
	}
	
	// a toString method for sending final string to the console
	public String toString() {
		
		if(nResults == 0) {
			return "";
		}
		
		else if(nResults == 1) {
			return "Transcript for " + name +"\n"+transcript[0];
		}
		
		else if(nResults == 2) {
			return "Transcript for " + name +"\n"+transcript[0]+"\n"+transcript[1];
		}
		
		else if(nResults == 3) {
			return "Transcript for " + name +"\n"+transcript[0]+"\n"+transcript[1]+"\n"+transcript[2];
		}
		
		else if(nResults == 4) {
			return "Transcript for " + name +"\n"+transcript[0]+"\n"+transcript[1]+"\n"+transcript[2]+"\n"+transcript[3];
		}

		else if(nResults == 5) {
			return "Transcript for " + name +"\n"+transcript[0]+"\n"+transcript[1]+"\n"+transcript[2]+"\n"+transcript[3]+"\n"+transcript[4];
		}
		
		else if(nResults == 6) {
			return "Transcript for " + name +"\n"+transcript[0]+"\n"+transcript[1]+"\n"+transcript[2]+"\n"+transcript[3]+"\n"+transcript[4]+"\n"+transcript[5];
		}
		
		else if(nResults == 7) {
			return "Transcript for " + name +"\n"+transcript[0]+"\n"+transcript[1]+"\n"+transcript[2]+"\n"+transcript[3]+"\n"+transcript[4]+"\n"+transcript[5]+"\n"+transcript[6];
		}
		
		else if(nResults == 8) {
			return "Transcript for " + name +"\n"+transcript[0]+"\n"+transcript[1]+"\n"+transcript[2]+"\n"+transcript[3]+"\n"+transcript[4]+"\n"+transcript[5]+"\n"+transcript[6]+"\n"+transcript[7];
		}
		
		else if(nResults == 9) {
			return "Transcript for " + name +"\n"+transcript[0]+"\n"+transcript[1]+"\n"+transcript[2]+"\n"+transcript[3]+"\n"+transcript[4]+"\n"+transcript[5]+"\n"+transcript[6]+"\n"+transcript[7]+"\n"+transcript[8];
		}
		
		else if(nResults == 10) {
			return "Transcript for " + name +"\n"+transcript[0]+"\n"+transcript[1]+"\n"+transcript[2]+"\n"+transcript[3]+"\n"+transcript[4]+"\n"+transcript[5]+"\n"+transcript[6]+"\n"+transcript[7]+"\n"+transcript[8]+"\n"+transcript[9];
		}
		
		else if(nResults == 11) {
			return "Transcript for " + name +"\n"+transcript[0]+"\n"+transcript[1]+"\n"+transcript[2]+"\n"+transcript[3]+"\n"+transcript[4]+"\n"+transcript[5]+"\n"+transcript[6]+"\n"+transcript[7]+"\n"+transcript[8]+"\n"+transcript[9]+"\n"+transcript[10];
		}
		
		else if(nResults == 12) {
			return "Transcript for " + name +"\n"+transcript[0]+"\n"+transcript[1]+"\n"+transcript[2]+"\n"+transcript[3]+"\n"+transcript[4]+"\n"+transcript[5]+"\n"+transcript[6]+"\n"+transcript[7]+"\n"+transcript[8]+"\n"+transcript[9]+"\n"+transcript[10]+"\n"+transcript[11];
		}
		
		else if(nResults == 13) {
			return "Transcript for " + name +"\n"+transcript[0]+"\n"+transcript[1]+"\n"+transcript[2]+"\n"+transcript[3]+"\n"+transcript[4]+"\n"+transcript[5]+"\n"+transcript[6]+"\n"+transcript[7]+"\n"+transcript[8]+"\n"+transcript[9]+"\n"+transcript[10]+"\n"+transcript[11]+"\n"+transcript[12];
		}
		
		else if(nResults == 14) {
			return "Transcript for " + name +"\n"+transcript[0]+"\n"+transcript[1]+"\n"+transcript[2]+"\n"+transcript[3]+"\n"+transcript[4]+"\n"+transcript[5]+"\n"+transcript[6]+"\n"+transcript[7]+"\n"+transcript[8]+"\n"+transcript[9]+"\n"+transcript[10]+"\n"+transcript[11]+"\n"+transcript[12]+"\n"+transcript[13];
		}
		
		else if(nResults == 15) {
			return "Transcript for " + name +"\n"+transcript[0]+"\n"+transcript[1]+"\n"+transcript[2]+"\n"+transcript[3]+"\n"+transcript[4]+"\n"+transcript[5]+"\n"+transcript[6]+"\n"+transcript[7]+"\n"+transcript[8]+"\n"+transcript[9]+"\n"+transcript[10]+"\n"+transcript[11]+"\n"+transcript[12]+"\n"+transcript[13]+"\n"+transcript[14];
		}
		
		else if(nResults == 16) {
			return "Transcript for " + name +"\n"+transcript[0]+"\n"+transcript[1]+"\n"+transcript[2]+"\n"+transcript[3]+"\n"+transcript[4]+"\n"+transcript[5]+"\n"+transcript[6]+"\n"+transcript[7]+"\n"+transcript[8]+"\n"+transcript[9]+"\n"+transcript[10]+"\n"+transcript[11]+"\n"+transcript[12]+"\n"+transcript[13]+"\n"+transcript[14]+"\n"+transcript[15];
		}
		
		else if(nResults == 17) {
			return "Transcript for " + name +"\n"+transcript[0]+"\n"+transcript[1]+"\n"+transcript[2]+"\n"+transcript[3]+"\n"+transcript[4]+"\n"+transcript[5]+"\n"+transcript[6]+"\n"+transcript[7]+"\n"+transcript[8]+"\n"+transcript[9]+"\n"+transcript[10]+"\n"+transcript[11]+"\n"+transcript[12]+"\n"+transcript[13]+"\n"+transcript[14]+"\n"+transcript[15]+"\n"+transcript[16];
		}
		
		else if(nResults == 18) {
			return "Transcript for " + name +"\n"+transcript[0]+"\n"+transcript[1]+"\n"+transcript[2]+"\n"+transcript[3]+"\n"+transcript[4]+"\n"+transcript[5]+"\n"+transcript[6]+"\n"+transcript[7]+"\n"+transcript[8]+"\n"+transcript[9]+"\n"+transcript[10]+"\n"+transcript[11]+"\n"+transcript[12]+"\n"+transcript[13]+"\n"+transcript[14]+"\n"+transcript[15]+"\n"+transcript[16]+"\n"+transcript[17];
		}
		
		else if(nResults == 19) {
			return "Transcript for " + name +"\n"+transcript[0]+"\n"+transcript[1]+"\n"+transcript[2]+"\n"+transcript[3]+"\n"+transcript[4]+"\n"+transcript[5]+"\n"+transcript[6]+"\n"+transcript[7]+"\n"+transcript[8]+"\n"+transcript[9]+"\n"+transcript[10]+"\n"+transcript[11]+"\n"+transcript[12]+"\n"+transcript[13]+"\n"+transcript[14]+"\n"+transcript[15]+"\n"+transcript[16]+"\n"+transcript[17]+"\n"+transcript[18];
		}
		
		else if(nResults == 20) {
			return "Transcript for " + name +"\n"+transcript[0]+"\n"+transcript[1]+"\n"+transcript[2]+"\n"+transcript[3]+"\n"+transcript[4]+"\n"+transcript[5]+"\n"+transcript[6]+"\n"+transcript[7]+"\n"+transcript[8]+"\n"+transcript[9]+"\n"+transcript[10]+"\n"+transcript[11]+"\n"+transcript[12]+"\n"+transcript[13]+"\n"+transcript[14]+"\n"+transcript[15]+"\n"+transcript[16]+"\n"+transcript[17]+"\n"+transcript[18]+"\n"+transcript[19];
		}

		return this.toString();
	}

}
