package sshop;

//STEP 1. Import required packages
import java.sql.*;

public class JDBCMysql {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/sshop";
    
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    public static Connection connectmysql(){
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