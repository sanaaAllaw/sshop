package sshop;
 
import java.sql.*;
 
/**
 *
 * @author sqlitetutorial.net
 */
public class Conn {
 
    /**
     * Connect to the test.db database
     * @return the Connection object
     */
    public Connection connect() {
        // SQLite connection string
        
        String url = "jdbc:sqlite:src/config/sshop.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
  
    public static void main(String[] args) {
       
    }
 
}