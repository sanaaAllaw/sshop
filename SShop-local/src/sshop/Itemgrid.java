/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sshop;

import java.time.LocalDate;
import java.util.HashMap;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author skynete
 */
public class Itemgrid extends Application {
    ListView<String> listView = new ListView<>();
    HashMap<String,String> SpeciefItemCodeMap=new HashMap<>();
    
    @Override
    public void start(Stage primaryStage) {
        HashMap<String,String> ItemAllHash=new HashMap<>();
        ItemAllHash=generalFunc.GetAllItems();
        final ObservableList<String> data = FXCollections.observableArrayList();
        final ObservableList<ItemGridAll> datareturn = FXCollections.observableArrayList();
        for (int i=0;i<ItemAllHash.size();i++){
            data.add(ItemAllHash.get("itemname"));
        }
        GridPane grd1=new GridPane();
        grd1.setVgap(10);
        grd1.setHgap(10);
        VBox v1=new VBox();
        
        v1.getChildren().addAll(listView,grd1);
        
        Button btn1=new Button("Accept");
        Button btn2=new Button("Cancel");
        
        
        grd1.add(btn1, 1, 4);grd1.add(btn2, 2, 4);
        
        btn2.setOnAction((ActionEvent event) -> {
            
            primaryStage.close();
        });
        btn1.setOnAction((ActionEvent event) -> {
            PurchaseInvoice.data1.clear();
            for(int i=0;i<datareturn.size();i++){
                PurchaseInvoice.data1.add(new PurchaseInvoice.purchase
                ("", "", LocalDate.now().toString(), "",
                        datareturn.get(i).getItemCode(), "1", "0",
                        "", ""));
            }
            primaryStage.close();
        });
        listView.getItems().addAll(data);
        listView.setCellFactory(CheckBoxListCell.forListView((String item) -> {
            BooleanProperty observable = new SimpleBooleanProperty();
            observable.addListener((obs, wasSelected, isNowSelected) -> {
                SpeciefItemCodeMap=generalFunc.getSpecifiedItem(item);
                if (isNowSelected) {
                    
                    datareturn.add(new ItemGridAll(item,SpeciefItemCodeMap.get("itemname")));
                    
                } else {
                    datareturn.remove(new ItemGridAll(item,SpeciefItemCodeMap.get("itemname")));
                    
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
    public static class ItemGridAll {
        private final SimpleStringProperty ItemCode;
        private final SimpleStringProperty ItemName;
        
        private ItemGridAll(String ItemCode,String ItemName) {
            
            this.ItemCode = new SimpleStringProperty(ItemCode);
            this.ItemName = new SimpleStringProperty(ItemName);
            
        }
        public String getItemCode() {
            return ItemCode.get();
        }
        public void setSuppName(String NItemCode) {
            ItemCode.set(NItemCode);
        }
        public String getItemName() {
            return ItemName.get();
        }
        public void setItemName(String NItemName) {
            ItemName.set(NItemName);
        }
        
    }
}
