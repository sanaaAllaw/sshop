/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author skynete
 */
public class Constantes {
    static Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
   public static String pathvar = "C:\\sshop";
    static Stage ShopStage=new Stage(StageStyle.DECORATED);
    static Stage StageMenu=new Stage(StageStyle.DECORATED);
    static Stage StageSup=new Stage(StageStyle.DECORATED);
    static Stage StageItem=new Stage(StageStyle.DECORATED);
    static Stage StageGroup=new Stage(StageStyle.DECORATED);
    static Stage StageCust=new Stage(StageStyle.DECORATED);
    static Stage StagePIV=new Stage(StageStyle.DECORATED);
    static Stage StageSuppgrid=new Stage(StageStyle.DECORATED);
    static Stage StageItemgrid=new Stage(StageStyle.DECORATED);
    static Stage StageProducts=new Stage(StageStyle.DECORATED);
    static Stage Stagesett=new Stage(StageStyle.DECORATED);
    static Stage StageReport=new Stage(StageStyle.DECORATED);
    static Stage Stageslm=new Stage(StageStyle.DECORATED);
     static Stage Stagesdash=new Stage(StageStyle.DECORATED);
    static Integer indexvar;
    static String currentItemSelected;
    static HashMap<Integer,String> statichashmapsuppreturn=new HashMap<>();
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
     
    static double height;
    static double width;
    static double taskBarHeight;
     
}
