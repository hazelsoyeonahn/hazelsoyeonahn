package Task09_3;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Database {
	Connection conn = null;
	String url = "jdbc:derby:PlayerDB;create=true";  //url of the DB host

    String dbusername = "pdc";  //your DB username
    String dbpassword = "pdc";   //your DB password
    

    public void dbsetup() {
        try {
            conn = DriverManager.getConnection(url, dbusername, dbpassword);
            Statement statement = conn.createStatement();
            String tableName = "UserInfo";

            if (!checkTableExisting(tableName)) {
                statement.executeUpdate("CREATE TABLE " + tableName + " (userid VARCHAR(12), password VARCHAR(12), score INT)");
            }
            //statement.executeUpdate("INSERT INTO " + tableName + " VALUES('Fiction',0),('Non-fiction',10),('Textbook',20)");
            statement.close();

        } catch (Throwable e) {
            System.out.println("error");

        }
    }
    
    private boolean checkTableExisting(String newTableName) {
        boolean flag = false;
        try {

            System.out.println("check existing tables.... ");
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);//types);
            //Statement dropStatement=null;
            while (rsDBMeta.next()) {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                if (tableName.compareToIgnoreCase(newTableName) == 0) {
                    System.out.println(tableName + "  is there");
                    flag = true;
                }
            }
            if (rsDBMeta != null) {
                rsDBMeta.close();
            }
        } catch (SQLException ex) {
        }
        return flag;
    }
    
    public Data checkName(String username, String password) {
        Data data = new Data();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT userid, password, score FROM UserInfo "
                    + "WHERE userid = '" + username + "'");
            if (rs.next()) {
                String pass = rs.getString("password");
                System.out.println("***" + pass);
                System.out.println("found user");
                if (password.compareTo(pass) == 0) {
                    data.score = rs.getInt("score");
                    data.loginFlag = true;
                } else {
                    data.loginFlag = false;
                }
            } else {
                System.out.println("no such user");
                statement.executeUpdate("INSERT INTO UserInfo "
                        + "VALUES('" + username + "', '" + password + "', 0)");
                data.loginFlag = true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(MathQuiz.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    public void quitGame(String username, int score) {

        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeUpdate("UPDATE UserInfo SET score=" + score + " WHERE userid='" + username + "'");

        } catch (SQLException ex) {
            Logger.getLogger(MathQuiz.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
