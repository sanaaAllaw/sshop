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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author skynete
 */
public class ItemGroup extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane grd1=new GridPane();
        grd1.setVgap(10);
        grd1.setHgap(10);
        Label l1=new Label("GroupId");
        Label l2=new Label("Group Description");
        Label l3=new Label("Group Type");
        
        TextField txt1=new TextField();
        TextField txt2=new TextField();
        ComboBox<String> comb1=new ComboBox<>();
        
        Button btn1=new Button("Accept");
        Button btn2=new Button("Cancel");
        
        BorderPane root = new BorderPane();
        
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Item Group");
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
