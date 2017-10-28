/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sshop;

import java.util.HashMap;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.SetChangeListener;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author skynete
 */
public class SuppGrid extends Application {
    ListView<String> listView = new ListView<>();
    
    @Override
    public void start(Stage primaryStage) {
        HashMap<String,String> SuppAllHash=new HashMap<>();
        SuppAllHash=generalFunc.GetAllSupp();
        final ObservableList<String> data = FXCollections.observableArrayList();
        final ObservableList<String> datareturn = FXCollections.observableArrayList();
        for (int i=0;i<SuppAllHash.size();i++){
            data.add(SuppAllHash.get("suppname"));           
        }
        GridPane grd1=new GridPane();
        grd1.setVgap(10);
        grd1.setHgap(10);
        VBox v1=new VBox();
        
        v1.getChildren().addAll(listView,grd1);
        
        Button btn1=new Button("Accept");
        Button btn2=new Button("Cancel");
        
        
        grd1.add(btn1, 1, 4);grd1.add(btn2, 2, 4);
       
       btn1.setOnAction((ActionEvent event) -> {
          for(int i=0;i<datareturn.size();i++){
              Constantes.statichashmapsuppreturn.put(i, datareturn.get(i));
          }
          PurchaseInvoice.supptxt.setText(Constantes.statichashmapsuppreturn.get(0));
          primaryStage.close();
        });
        btn2.setOnAction((ActionEvent event) -> {
            primaryStage.close();
        });
        listView.getItems().addAll(data);
       listView.setCellFactory(CheckBoxListCell.forListView((String item) -> {
           BooleanProperty observable = new SimpleBooleanProperty();
           observable.addListener((obs, wasSelected, isNowSelected) -> {
               if (isNowSelected) {
                   datareturn.clear();
                   datareturn.add(item);
                  
               } else {
                   datareturn.remove(item);
                   
               }   
           });
           //observable.set(data.contains(item));         
           return observable;
        }));
        BorderPane root = new BorderPane();
        root.setCenter(v1);
        
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
   public static class suppgrid {
        private final SimpleStringProperty suppName;
       
        
        private suppgrid(String suppName) {
           
            this.suppName = new SimpleStringProperty(suppName);
           
        }
         public String getSuppName() {
            return suppName.get();
        }
        public void setSuppName(String NSuppName) {
            suppName.set(NSuppName);
        }
       
        
    } 
}
