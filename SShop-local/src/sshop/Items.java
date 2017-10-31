/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sshop;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author skynete
 */
public class Items extends Application{
    File file;
    HashMap<Integer,HashMap<String,String>> ItemsAllHash = new HashMap<>();
    HashMap<String, String> specItemhash=new HashMap<>();
    String filepicture="";
    TextField appendtxt1=new TextField();
    TextField appendtxt2=new TextField();
    TextField appendtxt3=new TextField();
    static ComboBox<String> appendtxt4=new ComboBox<>();
    TextField appendtxt5=new TextField();
    static HashMap<Integer, String> ItemGroupHash=new HashMap<>();
    static ComboBox<String> appendtxt6=new ComboBox<>();
    private final TableView<Item_desc> table = new TableView<>();
    public void clearFields(){
        //appendtxt1.clear();
        appendtxt2.clear();
        appendtxt3.clear();
        appendtxt4.getSelectionModel().selectFirst();
        appendtxt5.clear();
        appendtxt6.getSelectionModel().selectFirst();
    }
    @Override
    public void start(Stage primaryStage) {
        //===========================================
        ItemsAllHash=generalFunc.getAllItems();
        final ObservableList<Item_desc> data = FXCollections.observableArrayList();
        for (int i=0;i<ItemsAllHash.size();i++){
            data.add(new Item_desc(
                    ItemsAllHash.get(i).get("itemcode"),
                    ItemsAllHash.get(i).get("itemname"),
                    ItemsAllHash.get(i).get("itembar"),
                    ItemsAllHash.get(i).get("itemsupp"),
                    ItemsAllHash.get(i).get("itemprice"),
                    ItemsAllHash.get(i).get("itemgrp")));
        }
        GetAllItemGroup();
        GetAllSuppvar();
        VBox v1=new VBox();
        GridPane buttonsMenu=new GridPane();
        HBox hbox1=new HBox();
        hbox1.setSpacing(100);
        
        buttonsMenu.setVgap(10);
        buttonsMenu.setHgap(10);
        //==================================================================
        ImageView imageview1=new ImageView();
        Rectangle clip = new Rectangle(
                imageview1.getFitWidth(), imageview1.getFitHeight()
        );
        clip.setArcWidth(20);
        clip.setArcHeight(20);
        imageview1.setClip(clip);
        
        // snapshot the rounded image.
        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);
        WritableImage image = imageview1.snapshot(parameters, null);
        
        // remove the rounding clip so that our effect can show through.
        imageview1.setClip(null);
        
        // apply a shadow effect.
        imageview1.setEffect(new DropShadow(20, Color.BLACK));
        Image img1=new Image("/pictures/sample.png");
        imageview1.setFitHeight(200);
        imageview1.setFitWidth(200);
        // store the rounded image in the imageView.
        imageview1.setImage(img1);
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
        //=================================================================
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
        
        Button btnaddNewGroup = new Button("New group");
        TextField searchtxt=new TextField();searchtxt.setPrefWidth(300);
        searchtxt.setId("searchtxt");
        searchtxt.setPromptText("Search..");
        //===================================================================search
        searchtxt.textProperty().addListener((Observable observable) -> {
            if(searchtxt.textProperty().get().isEmpty()) {
                table.setItems(data);
                return;
            }
            ObservableList<Item_desc> tableItems = FXCollections.observableArrayList();
            ObservableList<TableColumn<Item_desc, ?>> cols = table.getColumns();
            for (Item_desc data1 : data) {
                for (TableColumn<Item_desc, ?> col1 : cols) {
                    TableColumn col = col1;
                    String cellValue = col.getCellData(data1).toString();
                    cellValue = cellValue.toLowerCase();
                    if (cellValue.contains(searchtxt.textProperty().get().toLowerCase())) {
                        tableItems.add(data1);
                        break;
                    }
                }
            }
            table.setItems(tableItems);
        });
        //===================================================================search
        
        
        appendgrid.add(appendlbl1, 1, 1);appendgrid.add(appendtxt1, 2, 1);
        appendgrid.add(appendlbl2, 1, 2);appendgrid.add(appendtxt2, 2, 2);
        appendgrid.add(appendlbl3, 1, 3);appendgrid.add(appendtxt3, 2, 3);
        appendgrid.add(appendlbl4, 3, 1);appendgrid.add(appendtxt4, 4, 1);
        appendgrid.add(appendlbl5, 3, 2);appendgrid.add(appendtxt5, 4, 2);
        appendgrid.add(appendlbl6, 3, 3);appendgrid.add(appendtxt6, 4, 3);appendgrid.add(btnaddNewGroup, 5, 3);
        
        
        btnMenu3.setOnAction((ActionEvent event) -> {
           clearFields(); 
        });
        btnaddNewGroup.setOnAction((ActionEvent event) -> {
           ItemGroup g1=new ItemGroup();
           g1.start(Constantes.StageGroup); 
        });
        //=============================accept
        btnMenu1.setOnAction((ActionEvent event) -> {
            HashMap<String,String> hashItemslocaly=new HashMap<>();
            hashItemslocaly.put("itemcode", appendtxt1.getText());
            hashItemslocaly.put("itemname", appendtxt2.getText());
            hashItemslocaly.put("itembar", appendtxt3.getText());
            hashItemslocaly.put("itemsupp", appendtxt4.getSelectionModel().getSelectedItem());
            hashItemslocaly.put("itemprice", appendtxt5.getText());
            hashItemslocaly.put("itemgrp", appendtxt6.getSelectionModel().getSelectedItem());
            hashItemslocaly.put("itemcol", "");
            if(!"".equals(filepicture)){
                hashItemslocaly.put("itempic", file.toURI().toString());
            }else{
                hashItemslocaly.put("itempic", "");
            }
            if(generalFunc.checkItemCodeExistance(appendtxt1.getText())==true){
                generalFunc.UpdateSpeciefItem(hashItemslocaly);
            }else{
                generalFunc.AddItems(hashItemslocaly);
            }
            data.add(new Item_desc(appendtxt1.getText(),  appendtxt2.getText(), appendtxt3.getText(),
                    appendtxt4.getSelectionModel().getSelectedItem(), appendtxt5.getText(), 
                    appendtxt6.getSelectionModel().getSelectedItem()));
            clearFields();
        });
        btnMenu2.setOnAction((ActionEvent event) -> {
            clearFields();
        });
        //====================================================add items to mysql
        //===================================================================================
        TableColumn item_code_col = new TableColumn("Item Code");
        item_code_col.setMinWidth(100);
        item_code_col.setCellValueFactory(
                new PropertyValueFactory<>("ItemCode"));
        
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
        hbox1.getChildren().addAll(appendgrid,imageview1);
        v1.getChildren().addAll(buttonsMenu,hbox1,searchtxt,table);
        v1.setSpacing(10);
        imageview1.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() == 2){
                    file = fileChooser.showOpenDialog(primaryStage);
                    Image image1 = new Image(file.toURI().toString());
                    imageview1.setImage(image);
                    filepicture=file.toURI().toString();
                    try {
                        openFile(file);
                    } catch (IOException ex) {
                        Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        appendtxt1.setText(generalFunc.getItemCode());
        appendtxt1.setDisable(true);
        table.setOnMouseClicked((MouseEvent event) -> {
            if(event.getButton().equals(MouseButton.PRIMARY)){
                if(event.getClickCount() == 2){
                    Item_desc itemcodevar=table.getSelectionModel().getSelectedItem();
                    specItemhash=generalFunc.getSpecifiedItem(itemcodevar.getItemCode());
                    appendtxt1.setText(specItemhash.get("itemcode"));
                    appendtxt2.setText(specItemhash.get("itemname"));
                    appendtxt3.setText(specItemhash.get("itembar"));
                    appendtxt4.getSelectionModel().select(specItemhash.get("itemsupp"));
                    appendtxt5.setText(specItemhash.get("itemprice"));
                    appendtxt6.getSelectionModel().select(specItemhash.get("itemgrp"));
                    imageview1.setImage(new Image(specItemhash.get("item_pic")));
                }
            }
            
        });
        
        
        //============================================
        
        StackPane root = new StackPane();
        root.getChildren().add(v1);
        
        Scene scene = new Scene(root, Constantes.primScreenBounds.getWidth()-200-10,
                700);
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
     public static void GetAllSuppvar(){
       ItemGroupHash=generalFunc.getAllSuppCode();
        for (int i=0;i<ItemGroupHash.size();i++){
            appendtxt4.getItems().add(ItemGroupHash.get(i));
        }
        appendtxt4.getSelectionModel().selectFirst();
   }
    public static void GetAllItemGroup(){
       ItemGroupHash=generalFunc.getAllItemGroup();
        for (int i=0;i<ItemGroupHash.size();i++){
            appendtxt6.getItems().add(ItemGroupHash.get(i));
        }
        appendtxt6.getSelectionModel().selectFirst();
   }
    private void openFile(File file) throws IOException {
      Path from = Paths.get(file.toURI());
        Path to = Paths.get("C:\\Users\\skynete\\Documents\\GitHub\\sshop\\SShop-local\\src\\images\\");
        CopyOption[] options = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
        };
        Files.copy(from, to, options);
    }
    //================================================
    //=========clear fields
    
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
