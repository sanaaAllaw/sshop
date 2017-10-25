/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sshop;

import java.io.File;
import java.util.HashMap;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
public class Supplier extends Application{
    File file;
    HashMap<Integer, String> currMap=new HashMap<>();
    HashMap<Integer,HashMap<String,String>> SuppAllHash = new HashMap<>();
    HashMap<String, String> specSupphash=new HashMap<>();
    String filepicture="";
    TextField appendtxt1=new TextField();
    TextField appendtxt2=new TextField();
    ComboBox<String> appendtxt3=new ComboBox<>();
    TextField appendtxt4=new TextField();
    TextField appendtxt5=new TextField();
    TextField appendtxt6=new TextField();
    private final TableView<supp_desc> table = new TableView<>();
    public void clearFields(){
        //appendtxt1.clear();
        appendtxt2.clear();
        appendtxt3.getSelectionModel().selectFirst();
        appendtxt4.clear();
        appendtxt5.clear();
        appendtxt6.clear();
        appendtxt1.setText(generalFunc.getSuppCode());
    }
    @Override
    public void start(Stage primaryStage) {
        //===========================================
        clearFields();
        SuppAllHash=generalFunc.getAllSupp();
        final ObservableList<supp_desc> data = FXCollections.observableArrayList();
        for (int i=0;i<SuppAllHash.size();i++){
            data.add(new supp_desc(
                    SuppAllHash.get(i).get("Suppcode"),
                    SuppAllHash.get(i).get("Suppname"),
                    SuppAllHash.get(i).get("Curr"),
                    SuppAllHash.get(i).get("Rate"),
                    SuppAllHash.get(i).get("Address"),
                    SuppAllHash.get(i).get("Mobile")));
        }
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
        Label appendlbl1=new Label("Supplier Code");
        Label appendlbl2=new Label("Supplier Name");
        Label appendlbl3=new Label("Currency");
        Label appendlbl4=new Label("Rate");
        Label appendlbl5=new Label("Address");
        Label appendlbl6=new Label("Mobile");
        
        //Button btnaddNewGroup = new Button("New group");
        TextField searchtxt=new TextField();searchtxt.setPrefWidth(300);
        searchtxt.setId("searchtxt");
        searchtxt.setPromptText("Search..");
        //===================================================================search
        searchtxt.textProperty().addListener((Observable observable) -> {
            if(searchtxt.textProperty().get().isEmpty()) {
                table.setItems(data);
                return;
            }
            ObservableList<supp_desc> tableItems = FXCollections.observableArrayList();
            ObservableList<TableColumn<supp_desc, ?>> cols = table.getColumns();
            for (supp_desc data1 : data) {
                for (TableColumn<supp_desc, ?> col1 : cols) {
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
        appendgrid.add(appendlbl6, 3, 3);appendgrid.add(appendtxt6, 4, 3);
        
        currMap=generalFunc.getAllCurr();
        for (int i=0;i<currMap.size();i++){
            appendtxt3.getItems().add(currMap.get(i));
        }
        appendtxt3.getSelectionModel().selectFirst();
        btnMenu3.setOnAction((ActionEvent event) -> {
           clearFields(); 
        });
       
        //=============================accept
        btnMenu1.setOnAction((ActionEvent event) -> {
            HashMap<String,String> hashSupplocaly=new HashMap<>();
            hashSupplocaly.put("Suppcode", appendtxt1.getText());
            hashSupplocaly.put("Suppname", appendtxt2.getText());
            hashSupplocaly.put("Curr", appendtxt3.getSelectionModel().getSelectedItem());
            hashSupplocaly.put("Rate", appendtxt4.getText());
            hashSupplocaly.put("Address", appendtxt5.getText());
            hashSupplocaly.put("Mobile", appendtxt6.getText());
            if(!"".equals(filepicture)){
                hashSupplocaly.put("Supppic", file.toURI().toString());
            }else{
                hashSupplocaly.put("Supppic", "");
            }
            if(generalFunc.checkItemCodeExistance(appendtxt1.getText())==true){
                generalFunc.UpdateSpeciefItem(hashSupplocaly);
            }else{
                generalFunc.AddSupp(hashSupplocaly);
                data.add(new supp_desc(
                    hashSupplocaly.get("SupplierCode"),
                    hashSupplocaly.get("SuppName"),
                    hashSupplocaly.get("CompanyReference"),
                    hashSupplocaly.get("Currency"),
                    hashSupplocaly.get("Rate"),
                    hashSupplocaly.get("Address")));
            }
            clearFields();
        });
        btnMenu2.setOnAction((ActionEvent event) -> {
            clearFields();
        });
        //====================================================add items to mysql
        //===================================================================================
        TableColumn supp_code_col = new TableColumn("Supplier Code");
        supp_code_col.setMinWidth(100);
        supp_code_col.setCellValueFactory(
                new PropertyValueFactory<>("SuppCode"));
        
        TableColumn supp_name_col = new TableColumn("Supplier Name");
        supp_name_col.setMinWidth(100);
        supp_name_col.setCellValueFactory(
                new PropertyValueFactory<>("SuppName"));
        
        TableColumn curr_col = new TableColumn("Currency");
        curr_col.setMinWidth(200);
        curr_col.setCellValueFactory(
                new PropertyValueFactory<>("Curr"));
        
        TableColumn rate_col = new TableColumn("Rate");
        rate_col.setMinWidth(200);
        rate_col.setCellValueFactory(
                new PropertyValueFactory<>("Rate"));
        
        TableColumn address_col = new TableColumn("Address");
        address_col.setMinWidth(200);
        address_col.setCellValueFactory(
                new PropertyValueFactory<>("Address"));
        
        TableColumn mobile_col = new TableColumn("Mobile");
        mobile_col.setMinWidth(200);
        mobile_col.setCellValueFactory(
                new PropertyValueFactory<>("Mobile"));
        
        table.setItems(data);
        table.getColumns().addAll(supp_code_col, supp_name_col, curr_col,rate_col,address_col,mobile_col);
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
                    
                }
            }
        });
       
        appendtxt1.setDisable(true);
        table.setOnMouseClicked((MouseEvent event) -> {
            if(event.getButton().equals(MouseButton.PRIMARY)){
                if(event.getClickCount() == 2){
                    supp_desc itemcodevar=table.getSelectionModel().getSelectedItem();
                    specSupphash=generalFunc.getSpecifiedSupp(itemcodevar.getSuppCode());
                    appendtxt1.setText(specSupphash.get("Suppcode"));
                    appendtxt2.setText(specSupphash.get("Suppname"));
                    //appendtxt3.setText(specSupphash.get("Curr"));
                    appendtxt4.setText(specSupphash.get("Rate"));
                    appendtxt5.setText(specSupphash.get("Address"));
                    appendtxt6.setText(specSupphash.get("Mobile"));
                    imageview1.setImage(new Image(specSupphash.get("Supp_pic")));
                }
            }
            
        });
        String ratevarr=generalFunc.getRateBuCurr(
                appendtxt3.getSelectionModel().getSelectedItem(),"LBP");
        appendtxt4.setText(ratevarr);
        appendtxt3.valueProperty().addListener(new ChangeListener<String>() {
        @Override 
        public void changed(ObservableValue ov, String t, String t1) {
          String ratevarr=generalFunc.getRateBuCurr(
                appendtxt3.getSelectionModel().getSelectedItem(),"LBP");
           appendtxt4.setText(ratevarr);
        }    
    });
        //============================================
        
        StackPane root = new StackPane();
        root.getChildren().add(v1);
        
        Scene scene = new Scene(root, Constantes.primScreenBounds.getWidth()-200-10,
                700);
        String cssURL = this.getClass().getResource("/css/Supp.css").toExternalForm();
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
    //=========clear fields
    
    //========================class item description to use it for adding to mysql
    public static class supp_desc {
        private final SimpleStringProperty SuppCode;
        private final SimpleStringProperty SuppName;
        private final SimpleStringProperty Currency;
        private final SimpleStringProperty Rate;
        private final SimpleStringProperty Address;
        private final SimpleStringProperty Mobile;
        
        private supp_desc(String SuppCode, String SuppName, String Currency, String Rate,String Address,String Mobile) {
            this.SuppCode = new SimpleStringProperty(SuppCode);
            this.SuppName = new SimpleStringProperty(SuppName);
            this.Currency = new SimpleStringProperty(Currency);
            this.Rate = new SimpleStringProperty(Rate);
            this.Address = new SimpleStringProperty(Address);
            this.Mobile = new SimpleStringProperty(Mobile);
        }
        
        public String getSuppCode() {
            return SuppCode.get();
        }
        public void setSuppCode(String NSuppCode) {
            SuppCode.set(NSuppCode);
        }
        
        public String getSuppName() {
            return SuppName.get();
        }
        public void setSuppName(String NSuppName) {
            SuppName.set(NSuppName);
        }
        
        public String getCurr() {
            return Currency.get();
        }
        public void setCurr(String NCurrency) {
            Currency.set(NCurrency);
        }
        public String getRate() {
            return Rate.get();
        }
        public void setRate(String NRate) {
            Rate.set(NRate);
        }
        public String getAddress() {
            return Address.get();
        }
        public void setAddress(String NAddress) {
            Address.set(NAddress);
        }
        public String getMobile() {
            return Mobile.get();
        }
        public void setMobile(String NMobile) {
            Mobile.set(NMobile);
        }
        
    }
}
