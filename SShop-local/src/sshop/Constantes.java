/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sshop;

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
    static Integer indexvar;
    static String currentItemSelected;
    static HashMap<Integer,String> statichashmapsuppreturn=new HashMap<>();
    static  ObservableList<PurchaseInvoice.purchase> statichashmapItemsreturn=FXCollections.observableArrayList();
    
    static double height;
    static double width;
    static double taskBarHeight;
}
