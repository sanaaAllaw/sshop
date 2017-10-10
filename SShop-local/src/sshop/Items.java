/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sshop;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private final TableView<Item_desc> table = new TableView<>();
    @Override
    public void start(Stage primaryStage) {
        //===========================================
        final ObservableList<Item_desc> data = FXCollections.observableArrayList(
                new Item_desc("asdasd", "", "", "", "", "")
        );
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
        appendgrid.setVgap(30);
        appendgrid.setHgap(30);
        Label appendlbl1=new Label("Item Code");
        Label appendlbl2=new Label("Item Name");
        Label appendlbl3=new Label("Item Barcode");
        Label appendlbl4=new Label("Supplier");
        Label appendlbl5=new Label("Original Price");
        Label appendlbl6=new Label("Item Group");
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
        TableColumn item_code_col = new TableColumn("Item Code");
        item_code_col.setMinWidth(100);
        item_code_col.setCellValueFactory(
                new PropertyValueFactory<Item_desc, String>("ItemCode"));
        
        TableColumn item_name_col = new TableColumn("Item Name");
        item_name_col.setMinWidth(100);
        item_name_col.setCellValueFactory(
                new PropertyValueFactory<>("ItemName"));
        
        TableColumn item_barcode_col = new TableColumn("Item Barcode");
        item_barcode_col.setMinWidth(200);
        item_barcode_col.setCellValueFactory(
                new PropertyValueFactory<>("ItemBarcode"));
        
        TableColumn item_supp_col = new TableColumn("Supplier");
        item_supp_col.setMinWidth(200);
        item_supp_col.setCellValueFactory(
                new PropertyValueFactory<>("Supplier"));
        
        TableColumn item_orig_col = new TableColumn("Original Price");
        item_orig_col.setMinWidth(200);
        item_orig_col.setCellValueFactory(
                new PropertyValueFactory<>("OrigPrice"));
        
        TableColumn item_group_col = new TableColumn("Item Group");
        item_group_col.setMinWidth(200);
        item_group_col.setCellValueFactory(
                new PropertyValueFactory<>("ItemGroup"));
        
        table.setItems(data);
        table.getColumns().addAll(item_code_col, item_name_col, item_barcode_col,item_supp_col,item_orig_col,item_group_col);
        v1.getChildren().addAll(buttonsMenu,appendgrid,table);
        v1.setSpacing(10);
        //============================================
        
        StackPane root = new StackPane();
        root.getChildren().add(v1);
        
        Scene scene = new Scene(root, Constantes.primScreenBounds.getWidth()-200-10,
                Constantes.primScreenBounds.getHeight()-Constantes.taskBarHeight);
        String cssURL = this.getClass().getResource("/css/items.css").toExternalForm();
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
    
    //================================================
    //========================class item description to use it for adding to mysql
    public static class Item_desc {
        private final SimpleStringProperty ItemCode;
        private final SimpleStringProperty ItemName;
        private final SimpleStringProperty ItemBarcode;
        private final SimpleStringProperty Supplier;
        private final SimpleStringProperty OrigPrice;
        private final SimpleStringProperty ItemGroup;
        
        private Item_desc(String ItemCode, String ItemName, String ItemBarcode, String Supplier,String OrigPrice,String ItemGroup) {
            this.ItemCode = new SimpleStringProperty(ItemCode);
            this.ItemName = new SimpleStringProperty(ItemName);
            this.ItemBarcode = new SimpleStringProperty(ItemBarcode);
            this.Supplier = new SimpleStringProperty(Supplier);
            this.OrigPrice = new SimpleStringProperty(OrigPrice);
            this.ItemGroup = new SimpleStringProperty(ItemGroup);
        }
        
        public String getItemCode() {
            return ItemCode.get();
        }
        public void setItemCode(String NItemCode) {
            ItemCode.set(NItemCode);
        }
        
        public String getItemName() {
            return ItemName.get();
        }
        public void setItemName(String NItemName) {
            ItemName.set(NItemName);
        }
        
        public String getItemBarcode() {
            return ItemBarcode.get();
        }
        public void setItemBarcode(String NItemBarcode) {
            ItemBarcode.set(NItemBarcode);
        }
        public String getSupplier() {
            return Supplier.get();
        }
        public void setSupplier(String NSupplier) {
            Supplier.set(NSupplier);
        }
        public String getOrigPrice() {
            return OrigPrice.get();
        }
        public void setOrigPrice(String NOrigPrice) {
            OrigPrice.set(NOrigPrice);
        }
        public String getItemGroup() {
            return ItemGroup.get();
        }
        public void setItemGroup(String NItemGroup) {
            ItemGroup.set(NItemGroup);
        }
        
    }
}
