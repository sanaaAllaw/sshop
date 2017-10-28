package sshop;

//STEP 1. Import required packages
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCMysql {
    // JDBC driver name and database URL
   static String DB_URL ="";
    static String USER = "";
    static String PASS = "";
    private static void iniCon() {
    try{
      Properties p = new Properties();
      p.load(new FileInputStream("src/config/connection.ini"));
      DB_URL=p.getProperty("url");
      USER=p.getProperty("username");
      PASS=p.getProperty("password");
      
      }
    catch (Exception e) {
      System.out.println(e);
      }
    
    }
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   /* static final String DB_URL = "jdbc:mysql://localhost/sshop";
    
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "1234";*/
    public static Connection connectmysql(){
        iniCon();
       Connection dbConnection = null;

		try {

			Class.forName(JDBC_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(
                             DB_URL, USER,PASS);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}
}//end JDBCExample