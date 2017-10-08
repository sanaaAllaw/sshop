/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sshop;

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
    static double height;
    static double width;
    static double taskBarHeight;
}
