/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sshop;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author skynete
 */
public class Home extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Dimension scrnSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        Constantes.taskBarHeight = scrnSize.height - winSize.height;
        
        Constantes.height = Constantes.primScreenBounds.getHeight()-Constantes.taskBarHeight;
        
        //==================================================grid contains buttons
        GridPane grid1=new GridPane();
        grid1.setVgap(10);
        grid1.setHgap(10);
        
        Button btnLogout =new Button("Logout");btnLogout.setPrefWidth(170);btnLogout.setId("rich-blue");
        btnLogout.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/pictures/logoutpnj.png"))));
        Button btnExit =new Button("Exit");btnExit.setPrefWidth(170);btnExit.setId("rich-blue");
        btnExit.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/pictures/logout-icon.png"))));
        Button btnsupp =new Button("Supplier");btnsupp.setPrefWidth(170);btnsupp.setId("rich-blue");
        btnsupp.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/pictures/truck-icon.png"))));
        Button btnCust =new Button("Customer");btnCust.setPrefWidth(170);btnCust.setId("rich-blue");
        btnCust.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/pictures/Office-Customer-Male-Light-icon.png"))));
        Button btnINV =new Button("Invoice");btnINV.setPrefWidth(170);btnINV.setId("rich-blue");
        btnINV.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/pictures/invoice.png"))));
        Button btnITM =new Button("Items");btnITM.setPrefWidth(170);btnITM.setId("rich-blue");
        btnITM.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/pictures/items.png"))));
        Button btnPUR =new Button("Purchase");btnPUR.setPrefWidth(170);btnPUR.setId("rich-blue");
        btnPUR.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/pictures/money.png"))));
        Button btnCUR =new Button("Currency");btnCUR.setPrefWidth(170);btnCUR.setId("rich-blue");
        btnCUR.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/pictures/dollar.png"))));
        Button btnRate =new Button("Rate");btnRate.setPrefWidth(170);btnRate.setId("rich-blue");
        btnRate.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/pictures/wallet.png"))));
        Button btnEMP =new Button("Operator");btnEMP.setPrefWidth(170);btnEMP.setId("rich-blue");
        btnEMP.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/pictures/oper.png"))));
        
        grid1.add(btnLogout, 1, 1);
        grid1.add(btnExit, 1, 2);
        grid1.add(btnsupp, 1, 3);
        grid1.add(btnCust, 1, 4);
        grid1.add(btnINV, 1, 5);
        grid1.add(btnITM, 1, 6);
        grid1.add(btnPUR, 1, 7);
        grid1.add(btnCUR, 1, 8);
        grid1.add(btnRate, 1, 9);
        grid1.add(btnEMP, 1, 10);
        //===================button actions
        btnLogout.setOnAction((ActionEvent event) -> {
            
             primaryStage.close();
             SShop ss1=new SShop();
            try {
                ss1.start(Constantes.ShopStage);
            } catch (AWTException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        });
        btnExit.setOnAction((ActionEvent event) -> {
             System.exit(0);
        });
        btnITM.setOnAction((ActionEvent event) -> {
             Items item1=new Items();
             item1.start(Constantes.StageSup);
        });
        btnsupp.setOnAction((ActionEvent event) -> {
             Supplier sp1=new Supplier();
             sp1.start(Constantes.StageItem);
        });
        //================end button actions
        //==================================================grid contains buttons
        StackPane root = new StackPane();
        root.getChildren().add(grid1);
        
        Scene scene = new Scene(root, 200, Constantes.height);
        String cssURL = this.getClass().getResource("/css/home.css").toExternalForm();
        scene.getStylesheets().add(cssURL);
        primaryStage.setX(0);
        primaryStage.setY(0);
        primaryStage.setTitle("");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}