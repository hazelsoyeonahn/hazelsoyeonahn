package Task09_3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model extends Observable{

	public Data data;
	public Database db;
	public String username;
	public int answer = 0;
	
	public Model() {
		this.db = new Database();
		this.db.dbsetup();
	}
	
	public void checkName(String username, String password) {
	   this.username = username;
	   this.data = this.db.checkName(username, password);
	   
	   if(data.loginFlag) {
		   this.newQuestion();
	   }
	   this.setChanged();
	   this.notifyObservers(this.data);
	}

    public void newQuestion() {
        this.data.num1 = getNumber();
        this.data.num2 = getNumber();
        this.answer = this.data.num1 + this.data.num2;
    }

    public int getNumber() {
        Random generator = new Random();
        int i = generator.nextInt(100);
        return i;
    }
    
    public void quitGame() {
    	this.db.quitGame(this.username, this.data.score);
    	this.data.logoffFlag = true;
    	this.setChanged();
    	this.notifyObservers(this.data);
    }
    
    public void checkQuestion(String answer) {
    	if(answer.equals(this.answer+""))
    		data.score += 10;
    	else
    		data.score -= 10;
    	this.newQuestion();
    	this.setChanged();
    	this.notifyObservers(this.data);
    }
}
