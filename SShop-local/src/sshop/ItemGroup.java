/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sshop;

import java.util.HashMap;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
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
    TextField txt1=new TextField();
    TextField txt2=new TextField();
    
    ComboBox<String> comb1=new ComboBox<>();
    @Override
    public void start(Stage primaryStage) {
        
        GridPane grd1=new GridPane();
        grd1.setVgap(10);
        grd1.setHgap(10);
        Label l1=new Label("GroupId");
        Label l2=new Label("Group Description");
        Label l3=new Label("Group Type");
        
        
        
        
        Button btn1=new Button("Accept");
        Button btn2=new Button("Cancel");
        
        grd1.add(l1, 1, 1);grd1.add(txt1, 2, 1);
        grd1.add(l2, 1, 2);grd1.add(txt2, 2, 2);
        grd1.add(l3, 1, 3);grd1.add(comb1, 2, 3);
        grd1.add(btn1, 1, 4);grd1.add(btn2, 2, 4);
        txt1.setText(generalFunc.getItemGroupCode());
        txt1.setDisable(true);
        comb1.getItems().addAll(
                "Men",
                "Women",
                "Children"
        );
        
        comb1.getSelectionModel().selectFirst();
        btn1.setOnAction((ActionEvent event) -> {
            HashMap<Integer,String> hashgroupItem=new HashMap();
            hashgroupItem.put(0, txt1.getText());
            hashgroupItem.put(1, txt2.getText());
            hashgroupItem.put(2, comb1.getSelectionModel().getSelectedItem());
            generalFunc.InsertItemGroupMysql(hashgroupItem);
            Items.GetAllItemGroup();
            clearFields();
            primaryStage.close();
        });
        btn2.setOnAction((ActionEvent event) -> {
            primaryStage.close();
        });
        BorderPane root = new BorderPane();
        root.setCenter(grd1);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Item Group");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void clearFields(){
        //appendtxt1.clear();
        txt1.clear();
        txt2.clear();
        comb1.getSelectionModel().selectFirst();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
   
}
