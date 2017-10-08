/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sshop;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author skynete
 */
public class Items extends Application{
    @Override
    public void start(Stage primaryStage) {
        //===========================================
        VBox v1=new VBox();
        GridPane buttonsMenu=new GridPane();
        buttonsMenu.setVgap(10);
        buttonsMenu.setHgap(10);
        Button btnMenu1=new Button("Accept");btnMenu1.setPrefWidth(150);btnMenu1.setId("rich-blue");
        btnMenu1.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/pictures/accept.png"))));
        Button btnMenu2=new Button("Cancel");btnMenu2.setPrefWidth(150);btnMenu2.setId("rich-blue");
        btnMenu2.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/pictures/cancel.png"))));
        Button btnMenu3=new Button("New");btnMenu3.setPrefWidth(150);btnMenu3.setId("rich-blue");
        btnMenu3.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/pictures/new.png"))));
        Button btnMenu4=new Button("First");btnMenu4.setPrefWidth(150);btnMenu4.setId("rich-colored");
        btnMenu4.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/pictures/first.png"))));
        Button btnMenu5=new Button("Previous");btnMenu5.setPrefWidth(150);btnMenu5.setId("rich-colored");
        btnMenu5.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/pictures/previous.png"))));
        Button btnMenu6=new Button("Next");btnMenu6.setPrefWidth(150);btnMenu6.setId("rich-colored");
        btnMenu6.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/pictures/next.png"))));
        Button btnMenu7=new Button("Last");btnMenu7.setPrefWidth(150);btnMenu7.setId("rich-colored");
        btnMenu7.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/pictures/last.png"))));
        buttonsMenu.add(btnMenu1, 1, 1);
        buttonsMenu.add(btnMenu2, 2, 1);
        buttonsMenu.add(btnMenu3, 3, 1);
        buttonsMenu.add(btnMenu4, 4, 1);
        buttonsMenu.add(btnMenu5, 5, 1);
        buttonsMenu.add(btnMenu6, 6, 1);
        buttonsMenu.add(btnMenu7, 7, 1);
        //===================================================================================
        GridPane appendgrid=new GridPane();
        appendgrid.setVgap(10);
        appendgrid.setHgap(10);
        Label appendlbl1=new Label("Currency Code");
        Label appendlbl2=new Label("Currency Name");
        Label appendlbl3=new Label("Secondary Name");
        Label appendlbl4=new Label("Numeric Code");
        Label appendlbl5=new Label("Minimum Rate");
        Label appendlbl6=new Label("Maximum Rate");
        TextField appendtxt1=new TextField();
        TextField appendtxt2=new TextField();
        TextField appendtxt3=new TextField();
        TextField appendtxt4=new TextField();
        TextField appendtxt5=new TextField();
        TextField appendtxt6=new TextField();
        appendgrid.add(appendlbl1, 1, 1);appendgrid.add(appendtxt1, 2, 1);
        appendgrid.add(appendlbl2, 1, 2);appendgrid.add(appendtxt2, 2, 2);
        appendgrid.add(appendlbl3, 1, 3);appendgrid.add(appendtxt3, 2, 3);
        appendgrid.add(appendlbl4, 3, 1);appendgrid.add(appendtxt4, 4, 1);
        appendgrid.add(appendlbl5, 3, 2);appendgrid.add(appendtxt5, 4, 2);
        appendgrid.add(appendlbl6, 3, 3);appendgrid.add(appendtxt6, 4, 3);
        
        //===================================================================================
        v1.getChildren().addAll(buttonsMenu,appendgrid);
        //============================================
        
        StackPane root = new StackPane();
        root.getChildren().add(v1);
        
        Scene scene = new Scene(root, Constantes.primScreenBounds.getWidth()-200-10, 
                Constantes.primScreenBounds.getHeight()-Constantes.taskBarHeight);
        String cssURL = this.getClass().getResource("/css/supplier.css").toExternalForm();
        scene.getStylesheets().add(cssURL);
        primaryStage.setX(200+10);
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
