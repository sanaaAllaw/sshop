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
     public static HashMap<String,String> GetAllItems(){
        HashMap<String,String> hashmapitemList=new HashMap<>();
        String sql = "SELECT * FROM items";
        
        try (
                Statement stmt  = SShop.connmysql.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                hashmapitemList.put("itemcode", String.valueOf(rs.getString("item_code")));
                hashmapitemList.put("itemname", String.valueOf(rs.getString("item_name")));
                hashmapitemList.put("itemprice", String.valueOf(rs.getString("item_orig_price")));
               
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return hashmapitemList;
    }
    public static HashMap<String,String> GetAllSupp(){
        HashMap<String,String> hashmapsuppList=new HashMap<>();
        String sql = "SELECT * FROM supplier";
        
        try (
                Statement stmt  = SShop.connmysql.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                hashmapsuppList.put("suppname", String.valueOf(rs.getString("supp_name")));
               
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return hashmapsuppList;
    }
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
    public static void AddItems(HashMap<String,String> ItemGroupHash){
        try{
            String query = "INSERT INTO `sshop`.`items` (`item_code`, `item_name`, `item_barcode`,"
                    + " `item_supp`, `item_orig_price`, `item_group`, `Itemscol`, `item_pic`) "
                    + "VALUES (?,?,?,?,?,?,?,?);";
            PreparedStatement preparedStmt = SShop.connmysql.prepareStatement(query);
            preparedStmt.setString (1,ItemGroupHash.get("itemcode"));
            preparedStmt.setString (2,ItemGroupHash.get("itemname"));
            preparedStmt.setString (3,ItemGroupHash.get("itembar"));
            preparedStmt.setString (4,ItemGroupHash.get("itemsupp"));
            preparedStmt.setString (5,ItemGroupHash.get("itemprice"));
            preparedStmt.setString (6,ItemGroupHash.get("itemgrp"));
            preparedStmt.setString (7,ItemGroupHash.get("itemcol"));
            preparedStmt.setString (8,ItemGroupHash.get("itempic"));
            preparedStmt.execute();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
    public static String getRateBuCurr(String fromcurrvar,String tocurrvar){
        String ratevar="";
        PreparedStatement preparedStmt = null;
        if(fromcurrvar==tocurrvar){
            return "1";
        }
      String sql = "SELECT ratevalue FROM rate where fromcurr= ? and tocurr= ?";
        
        try {
                preparedStmt = SShop.connmysql.prepareStatement(sql);
                preparedStmt.setString (1,fromcurrvar);
                preparedStmt.setString (2,tocurrvar);
                ResultSet rs    = preparedStmt.executeQuery();
            
            // loop through the result set
            if (rs.next()) {
                ratevar=rs.getString("ratevalue");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ratevar;
    }
    //===================================
    public static void AddSupp(HashMap<String,String> ItemGroupHash){
        try{
            String query = "INSERT INTO `sshop`.`supplier` "
                    + "(`supp_code`, `supp_name`, `currency`, `rate`, `address`, `mobile`) "
                    + "VALUES (?,?,?,?,?,?);";
            PreparedStatement preparedStmt = SShop.connmysql.prepareStatement(query);
            preparedStmt.setString (1,ItemGroupHash.get("Suppcode"));
            preparedStmt.setString (2,ItemGroupHash.get("Suppname"));
            preparedStmt.setString (3,ItemGroupHash.get("Curr"));
            preparedStmt.setString (4,ItemGroupHash.get("Rate"));
            preparedStmt.setString (5,ItemGroupHash.get("Address"));
            preparedStmt.setString (6,ItemGroupHash.get("Mobile"));
            
           // preparedStmt.setString (7,ItemGroupHash.get("Supppic"));
            preparedStmt.execute();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
    public static void Addpiv(HashMap<String,String> pivGroupHash){
        try{
            String query = "INSERT INTO `sshop`.`purchase` "
                    + "(`pivno`,  `suppcode`, `datevar`, `item`, `qty`, `price`, `discount`, `curr`)"
                    + " VALUES (?,?,?,?,?,?,?,?);";
            PreparedStatement preparedStmt = SShop.connmysql.prepareStatement(query);
            preparedStmt.setString (1,pivGroupHash.get("pivno"));
            preparedStmt.setString (2,pivGroupHash.get("suppcode"));
            preparedStmt.setString (3,pivGroupHash.get("date"));
            preparedStmt.setString (4,pivGroupHash.get("item"));
            preparedStmt.setString (5,pivGroupHash.get("qty"));
            preparedStmt.setString (6,pivGroupHash.get("price"));
            preparedStmt.setString (7,pivGroupHash.get("discount"));
            preparedStmt.setString (8,pivGroupHash.get("curr"));
            
           // preparedStmt.setString (7,ItemGroupHash.get("Supppic"));
            preparedStmt.execute();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
    public static void InsertItemGroupMysql(HashMap<Integer,String> ItemsHash){
        try{
            String query = " insert into item_group (GroupId, GroupDesc,GroupType)"
                    + " values (?, ? ,?)";
            PreparedStatement preparedStmt = SShop.connmysql.prepareStatement(query);
            preparedStmt.setString (1,ItemsHash.get(0));
            preparedStmt.setString (2,ItemsHash.get(1));
            preparedStmt.setString (3,ItemsHash.get(2));
            preparedStmt.execute();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
    //=================================
    public static void UpdateSpeciefItem(HashMap<String,String> SpecifiedItemCodevar){
        PreparedStatement preparedStatement = null;
        String selectSQL = "UPDATE `sshop`.`items` SET  "
                + "`item_name`=?, `item_barcode`=?, `item_supp`=?,"
                + " `item_orig_price`=?, `item_group`=?, `Itemscol`=?,"
                + " `item_pic`=? WHERE item_code=?;";
        try{
            preparedStatement = SShop.connmysql.prepareStatement(selectSQL);
            preparedStatement.setString (1,SpecifiedItemCodevar.get("itemname"));
            preparedStatement.setString (2,SpecifiedItemCodevar.get("itembar"));
            preparedStatement.setString (3,SpecifiedItemCodevar.get("itemsupp"));
            preparedStatement.setString (4,SpecifiedItemCodevar.get("itemprice"));
            preparedStatement.setString (5,SpecifiedItemCodevar.get("itemgrp"));
            preparedStatement.setString (6,SpecifiedItemCodevar.get("itemcol"));
            preparedStatement.setString (7,SpecifiedItemCodevar.get("itempic"));
            
            preparedStatement.setString (8,SpecifiedItemCodevar.get("itemcode"));
            preparedStatement.executeQuery();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
    //===========================================
    public static HashMap<String,String> getSpecifiedItem(String SpecifiedItemCodevar){
        HashMap<String,String> SpeciefItemCodeMap=new HashMap<>();
        PreparedStatement preparedStatement = null;
        boolean boolcheckvar=false;
        String selectSQL = "SELECT * FROM items WHERE item_code = ? ";
        try{
            
            preparedStatement = SShop.connmysql.prepareStatement(selectSQL);
            preparedStatement.setString(1, SpecifiedItemCodevar);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                SpeciefItemCodeMap.put("itemcode", rs.getString("item_code"));
                SpeciefItemCodeMap.put("itemname", rs.getString("item_name"));
                SpeciefItemCodeMap.put("itembar", rs.getString("item_barcode"));
                SpeciefItemCodeMap.put("itemsupp", rs.getString("item_supp"));
                SpeciefItemCodeMap.put("itemprice", rs.getString("item_orig_price"));
                SpeciefItemCodeMap.put("itemgrp", rs.getString("item_group"));
                SpeciefItemCodeMap.put("itemcol", rs.getString("Itemscol"));
                SpeciefItemCodeMap.put("itempic", rs.getString("item_pic"));
            }
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return SpeciefItemCodeMap;
    }
    //=================================
    //===========================================
    public static HashMap<String,String> getSpecifiedSupp(String SpecifiedSuppCodevar){
        HashMap<String,String> SpeciefItemCodeMap=new HashMap<>();
        PreparedStatement preparedStatement = null;
        boolean boolcheckvar=false;
        String selectSQL = "SELECT * FROM supplier WHERE supp_code = ? ";
        try{
            
            preparedStatement = SShop.connmysql.prepareStatement(selectSQL);
            preparedStatement.setString(1, SpecifiedSuppCodevar);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                SpeciefItemCodeMap.put("itemcode", rs.getString("item_code"));
                SpeciefItemCodeMap.put("itemname", rs.getString("item_name"));
                SpeciefItemCodeMap.put("itembar", rs.getString("item_barcode"));
                SpeciefItemCodeMap.put("itemsupp", rs.getString("item_supp"));
                SpeciefItemCodeMap.put("itemprice", rs.getString("item_orig_price"));
                SpeciefItemCodeMap.put("itemgrp", rs.getString("item_group"));
                SpeciefItemCodeMap.put("itemcol", rs.getString("Itemscol"));
                SpeciefItemCodeMap.put("itempic", rs.getString("item_pic"));
            }
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return SpeciefItemCodeMap;
    }
    //=================================
     public static HashMap<Integer,String> getAllCurr(){
        HashMap<Integer,String> SpeciefCurr=new HashMap<>();
        PreparedStatement preparedStatement = null;
        Integer currcounter=0;
        boolean boolcheckvar=false;
        String selectSQL = "SELECT * FROM currencies";
        try{
            
            preparedStatement = SShop.connmysql.prepareStatement(selectSQL);
            
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                SpeciefCurr.put(currcounter, rs.getString("iso_code"));
                currcounter++;
            
            }
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return SpeciefCurr;
    }
     //============================================
    public static HashMap<Integer,HashMap<String,String>> getAllItems(){
        Integer i=0;
        HashMap<Integer,HashMap<String,String>> ItemsAllHash = new HashMap<>();
        HashMap<String,String> hashItemDetail =new HashMap<>();
        PreparedStatement preparedStatement = null;
        boolean boolcheckvar=false;
        String selectSQL = "SELECT * from items";
        try{
            preparedStatement = SShop.connmysql.prepareStatement(selectSQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                hashItemDetail.put("itemcode", rs.getString("item_code"));
                hashItemDetail.put("itemname", rs.getString("item_name"));
                hashItemDetail.put("itembar", rs.getString("item_barcode"));
                hashItemDetail.put("itemsupp", rs.getString("item_supp"));
                hashItemDetail.put("itemprice", rs.getString("item_orig_price"));
                hashItemDetail.put("itemgrp", rs.getString("item_group"));
                hashItemDetail.put("itemcol", rs.getString("Itemscol"));
                hashItemDetail.put("itempic", rs.getString("item_pic"));
                ItemsAllHash.put(i, hashItemDetail);
                i++;
            }
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return ItemsAllHash;
    }
    //=================================
     //============================================
    public static HashMap<Integer,HashMap<String,String>> getAllSupp(){
        Integer i=0;
        HashMap<Integer,HashMap<String,String>> ItemsAllHash = new HashMap<>();
        HashMap<String,String> hashItemDetail =new HashMap<>();
        PreparedStatement preparedStatement = null;
        boolean boolcheckvar=false;
        String selectSQL = "SELECT * from supplier";
        try{
            preparedStatement = SShop.connmysql.prepareStatement(selectSQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                hashItemDetail.put("Suppcode", rs.getString("supp_code"));
                hashItemDetail.put("Suppname", rs.getString("supp_name"));
                hashItemDetail.put("Curr", rs.getString("currency"));
                hashItemDetail.put("Rate", rs.getString("rate"));
                hashItemDetail.put("Address", rs.getString("address"));
                hashItemDetail.put("Mobile", rs.getString("mobile"));
                
                hashItemDetail.put("supppic", rs.getString("supppic"));
                ItemsAllHash.put(i, hashItemDetail);
                i++;
            }
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return ItemsAllHash;
    }
    //=================================
    public static Boolean checkItemCodeExistance(String ItemCodevar){
        Boolean existbool=false;
        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT item_code FROM items WHERE item_code = ? ";
        try{
            preparedStatement = SShop.connmysql.prepareStatement(selectSQL);
            preparedStatement.setString(1, ItemCodevar);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                existbool=true;
            }
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return existbool;
    }
    
    //=====================================
    public static String getItemCode(){
        PreparedStatement preparedStatement = null;
        Integer ItemNumbervar=0;
        String formatted = null;
        String selectSQL = "SELECT count(*) as itemcount FROM items order by item_code desc limit 1";
        try{
            preparedStatement = SShop.connmysql.prepareStatement(selectSQL);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                ItemNumbervar=rs.getInt("itemcount");
                formatted = String.format("%06d", ItemNumbervar);
            }
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return formatted;
    }
    //=====================================
     public static String getPIVCode(){
        PreparedStatement preparedStatement = null;
        Integer ItemNumbervar=0;
        String formatted = null;
        String selectSQL = "SELECT count(*) as pivcount FROM purchase order by pivno desc limit 1";
        try{
            preparedStatement = SShop.connmysql.prepareStatement(selectSQL);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                ItemNumbervar=rs.getInt("pivcount");
                formatted = String.format("%06d", ItemNumbervar);
            }
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return formatted;
    }
    public static String getSuppCode(){
        PreparedStatement preparedStatement = null;
        Integer ItemNumbervar=0;
        String formatted = null;
        String selectSQL = "SELECT count(*) as suppcount FROM supplier order by supp_code desc limit 1";
        try{
            preparedStatement = SShop.connmysql.prepareStatement(selectSQL);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                ItemNumbervar=rs.getInt("suppcount");
                formatted = String.format("%06d", ItemNumbervar);
            }
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return formatted;
    }
    //=================================================
    public static String getItemGroupCode(){
        PreparedStatement preparedStatement = null;
        Integer ItemNumbervar=0;
        String formatted = null;
        String selectSQL = "SELECT count(*) as itemgroupcount FROM item_group order by groupid desc limit 1";
        try{
            preparedStatement = SShop.connmysql.prepareStatement(selectSQL);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                ItemNumbervar=rs.getInt("itemgroupcount");
                formatted = String.format("%06d", ItemNumbervar);
            }
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return formatted;
    }
    public static String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
    public static boolean checkLogin(String uservar,String passvar){
        PreparedStatement preparedStatement = null;
        boolean boolcheckvar=false;
        String selectSQL = "SELECT username, password FROM users WHERE username = ? and password= ?";
        try{
            preparedStatement = SShop.connmysql.prepareStatement(selectSQL);
            preparedStatement.setString(1, uservar);
            preparedStatement.setString(2, MD5(passvar));
            ResultSet rs = preparedStatement.executeQuery();
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
