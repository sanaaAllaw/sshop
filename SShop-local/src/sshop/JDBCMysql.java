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
}//end JDBCExample