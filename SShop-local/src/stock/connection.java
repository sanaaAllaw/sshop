package stock;

import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class connection {
    
    static String url;
    static String username;
    static String password ;
   
    
    public static Connection getDBConnection() {
        doit();
        Connection dbConnection = null;
        
        try {
            
            Class.forName(url);
            
        } catch (ClassNotFoundException e) {
            
            System.out.println(e.getMessage());
            
        }
        
        try {
            
            dbConnection = DriverManager.getConnection(
                    url, username,password);
            return dbConnection;
            
        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
            
        }
        
        return dbConnection;
        
    }
    
    public static void doit() {
    try{
      Properties p = new Properties();
      Path currentRelativePath = Paths.get("");
        
      p.load(new FileInputStream(Constantes.pathvar+"/config/connection.ini"));
      url= p.getProperty("url");
      username= p.getProperty("username");
      password=p.getProperty("password");
    
      }
    catch (Exception e) {
      System.out.println(e);
      }
    }
    public static void main(String[] argv) {
        
        
    doit();
        
    }
}