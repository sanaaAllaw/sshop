package sshop;

//STEP 1. Import required packages
import java.sql.*;

public class JDBCMysql {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/sshop";
    
    //  Database credentials
    static final String USER = "root";
<<<<<<< HEAD
    static final String PASS = "1234";
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
=======
    static final String PASS = "";
    public static Connection connectmysql(){
        Connection conn = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");
        }catch(SQLException | ClassNotFoundException se){
        }finally{
            //finally block used to close resources
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        return conn;
    }
    public static void main(String[] args) {
        
    }//end main
>>>>>>> 36718b3974feab1b5eeacbd0beae5e1390783db9
}//end JDBCExample