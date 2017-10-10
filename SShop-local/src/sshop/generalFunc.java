/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sshop;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author skynete
 */

public class generalFunc {
    //==========declare function to collect company information from xml file
    public static HashMap<String,String> GetCompanyInfo(){
        HashMap<String,String> hashmapCompList=new HashMap<>();
        String sql = "SELECT * FROM company";
        
        try (
                Statement stmt  = SShop.conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            if (rs.next()) {
                hashmapCompList.put("id", String.valueOf(rs.getInt("id")));
                hashmapCompList.put("name", rs.getString("name"));
                hashmapCompList.put("address", rs.getString("address"));
                hashmapCompList.put("username", rs.getString("username"));
                hashmapCompList.put("password", rs.getString("password"));
                hashmapCompList.put("capital", String.valueOf(rs.getDouble("capital")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return hashmapCompList;
    }
    //==========end declare function to collect company information from xml file
    //=====minimize all other applications
    public static void minimizeApps() throws AWTException{
        Robot r = new Robot();
        r.setAutoDelay(250);
        r.keyPress(KeyEvent.VK_WINDOWS);
        r.keyPress(KeyEvent.VK_D);
        r.keyRelease(KeyEvent.VK_D);
        r.keyRelease(KeyEvent.VK_WINDOWS);
    }
    //=====end minimize all other applications
    public static void AddItemGroup(HashMap<Integer,String> ItemGroupHash){
        try{
            String query = " insert into ItemGroup (GroupId, GroupDesc)"
                    + " values (?, ?)";
            PreparedStatement preparedStmt = SShop.conn.prepareStatement(query);
            preparedStmt.setString (1,ItemGroupHash.get(0));
            preparedStmt.setString (2,ItemGroupHash.get(1));
            preparedStmt.execute();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
    public static String getItemCode(){
        Double ItemNumbervar=0.0;
        String formatted = null;
        formatted = String.format("%06d", ItemNumbervar);
        return formatted;
    }
    public static boolean checkLogin(String uservar,String passvar){
        boolean boolcheckvar=false;
        try{
            String query = "select username,password from users where username=? and password =?";
            
            PreparedStatement preparedStmt = SShop.connmysql.prepareStatement(query);
            preparedStmt.setString (1,uservar);
            preparedStmt.setString (2,passvar);
            ResultSet rs    = preparedStmt.executeQuery(query);
            if (rs.next()) {
                boolcheckvar=true;
            }
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return boolcheckvar;
    }
    
}
