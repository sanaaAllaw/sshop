/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sshop;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author skynete
 */
public class Invoice extends Application {
    private final TableView<purchase> table = new TableView<>();
    static  ObservableList<purchase> data1 = FXCollections.observableArrayList();
    static  ObservableList<String> currency = FXCollections.observableArrayList();
    static  ObservableList<purchase> datatest = FXCollections.observableArrayList();
    HashMap<String,String> pivGroupHash=new HashMap<>();
    TextField supptxtname=new TextField();
    static TextField supptxt=new TextField();
    HashMap<Integer, String> currMap=new HashMap<>();
    @Override
    public void start(Stage primaryStage) {
        VBox v1=new VBox();
        data1.add(new purchase("", "", "",
                "", "", "", "",
                "", ""));
        GridPane grid1=new GridPane();
        grid1.setVgap(10);grid1.setHgap(10);
        Label PurchaseNo=new Label("Purchase No.");
        TextField purchNotxt=new TextField();
        purchNotxt.setDisable(true);
        supptxt.setPromptText("Supplier Account");
        
        supptxtname.setPrefWidth(200);
        supptxtname.setDisable(true);
        Label datelbl=new Label("Date");
        DatePicker datepick1=new DatePicker(LocalDate.now());
        Label whlbl=new Label("WhareHouse");
        TextField whtxt=new TextField();
        Button btnsave=new Button("Save");
        Button btnLoad=new Button("Load");
        Button btnClear=new Button("Clear");
        Button btnPreview=new Button("Preview");
        btnClear.setOnAction((ActionEvent event) -> {
           clearFields(); 
           data1.clear();
        });
        btnsave.setOnAction((ActionEvent event) -> {
            LocalDate localDate = datepick1.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date date = Date.from(instant);
            for (purchase data11 : data1) {
                pivGroupHash.put("pivno", purchNotxt.getText());
                pivGroupHash.put("suppcode", purchNotxt.getText());
                pivGroupHash.put("date", localDate.toString());
                pivGroupHash.put("item", data11.getItem());
                pivGroupHash.put("qty", data11.getQty());
                pivGroupHash.put("price", data11.getPrice());
                if(!"".equals(data11.getDiscount())){
                    pivGroupHash.put("discount", data11.getDiscount());
                }else{
                    pivGroupHash.put("discount", "0");
                }
                
                pivGroupHash.put("curr", data11.getCurr());
                generalFunc.Addpiv(pivGroupHash);
            }
            clearFields();
        });
        btnsave.setId("rich-blue");btnLoad.setId("rich-blue");btnClear.setId("rich-blue");btnPreview.setId("rich-blue");
        btnsave.setPrefWidth(150);btnLoad.setPrefWidth(150);btnClear.setPrefWidth(150);btnPreview.setPrefWidth(150);
        
        grid1.add(btnsave, 1, 0);grid1.add(btnLoad, 2, 0);grid1.add(btnClear, 3, 0);grid1.add(btnPreview, 4, 0);
        grid1.add(PurchaseNo, 1, 1);grid1.add(purchNotxt, 2, 1);
        grid1.add(supptxt, 1, 2);grid1.add(supptxtname, 2, 2);
        grid1.add(datelbl, 3, 2);grid1.add(datepick1, 4, 2);grid1.add(whlbl, 5, 2);
        
        TableColumn purcode_col = new TableColumn("Item Code");
        purcode_col.setMinWidth(100);
        purcode_col.setCellValueFactory(
                new PropertyValueFactory<>("item"));
        
        TableColumn supp_Code_col = new TableColumn("Qty");
        supp_Code_col.setMinWidth(100);
        supp_Code_col.setCellValueFactory(
                new PropertyValueFactory<>("qty"));
        
        TableColumn Date_col = new TableColumn("Date");
        Date_col.setMinWidth(200);
        Date_col.setCellValueFactory(
                new PropertyValueFactory<>("date"));
        
        TableColumn rate_col = new TableColumn("Price");
        rate_col.setMinWidth(200);
        rate_col.setCellValueFactory(
                new PropertyValueFactory<>("price"));
        
        TableColumn address_col = new TableColumn("Currency");
        address_col.setMinWidth(200);
        address_col.setCellValueFactory(
                new PropertyValueFactory<>("curr"));
        currMap=generalFunc.getAllCurr();
        for (int i=0;i<currMap.size();i++){
            currency.add(currMap.get(i));
        }
        address_col.setCellFactory(ComboBoxTableCell.forTableColumn(currency));

        
        TableColumn mobile_col = new TableColumn("Mobile");
        mobile_col.setMinWidth(200);
        mobile_col.setCellValueFactory(
                new PropertyValueFactory<>("Mobile"));
        
        table.setItems(data1);
        table.getColumns().addAll(purcode_col, supp_Code_col, Date_col,rate_col,address_col,mobile_col);
        
        table.getSelectionModel().setCellSelectionEnabled(true);  // selects cell only, not the whole row
        table.setOnMouseClicked((MouseEvent click) -> {
            if (click.getClickCount() == 2) {
                @SuppressWarnings("rawtypes")
                        TablePosition pos = table.getSelectionModel().getSelectedCells().get(0);
                int row = pos.getRow();
                int col = pos.getColumn();
                @SuppressWarnings("rawtypes")
                        TableColumn column = pos.getTableColumn();
                String val = column.getCellData(row).toString(); System.out.println("Selected Value, " + val + ", Column: " + col + ", Row: " + row);
                if ( col == 0 ) {
                    Constantes.indexvar=table.getSelectionModel().getSelectedIndex();
                    Itemgrid Igrid1=new Itemgrid();
                    Igrid1.start(Constantes.StageItemgrid);
                    
                }
                
            }
        });
        
       table.setEditable(true); 
        v1.getChildren().addAll(grid1,table);
        v1.setSpacing(10);
        supptxt.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() == 2){
                    SuppGrid sgrid1=new SuppGrid();
                    sgrid1.start(Constantes.StageSuppgrid);
                }
            }
        });
        purchNotxt.setText(generalFunc.getPIVCode());
        BorderPane root = new BorderPane();
        root.setCenter(v1);
        
        Scene scene = new Scene(root, 1000, 500);
        String cssURL = this.getClass().getResource("/css/purchase.css").toExternalForm();
        scene.getStylesheets().add(cssURL);
        
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
    public static class purchase {
        private final SimpleStringProperty pivno;
        private final SimpleStringProperty suppcode;
        private final SimpleStringProperty date;
        private final SimpleStringProperty wh;
        private final SimpleStringProperty item;
        private final SimpleStringProperty qty;
        private final SimpleStringProperty price;
        private final SimpleStringProperty discount;
        private final SimpleStringProperty curr;
        
        purchase(String pivno, String suppcode, String date,
                String wh,String item,String qty,String price,String discount,String curr) {
            this.pivno = new SimpleStringProperty(pivno);
            this.suppcode = new SimpleStringProperty(suppcode);
            this.date = new SimpleStringProperty(date);
            this.wh = new SimpleStringProperty(wh);
            this.item = new SimpleStringProperty(item);
            this.qty = new SimpleStringProperty(qty);
            this.price = new SimpleStringProperty(price);
            this.discount = new SimpleStringProperty(discount);
            this.curr = new SimpleStringProperty(curr);
        }
        public String getPivno() {
            return pivno.get();
        }
        public void setPivno(String Npivno) {
            pivno.set(Npivno);
        }
        public String getSuppCode() {
            return suppcode.get();
        }
        public void setSuppCode(String NSuppCode) {
            suppcode.set(NSuppCode);
        }
        
        public String getDate() {
            return date.get();
        }
        public void setDate(String NDate) {
            date.set(NDate);
        }
        
        public String getWh() {
            return wh.get();
        }
        public void setWh(String NWh) {
            wh.set(NWh);
        }
        public String getItem() {
            return item.get();
        }
        public void setItem(String NItem) {
            item.set(NItem);
        }
        public String getQty() {
            return qty.get();
        }
        public void setQty(String NQty) {
            qty.set(NQty);
        }
        public String getPrice() {
            return price.get();
        }
        public void setPrice(String NPrice) {
            price.set(NPrice);
        }
        public String getDiscount() {
            return discount.get();
        }
        public void setDiscount(String NDiscount) {
            discount.set(NDiscount);
        }
        public String getCurr() {
            return curr.get();
        }
        public void setCurr(String NCurr) {
            curr.set(NCurr);
        }
        
    }
    public void clearFields(){
        supptxtname.clear();
       DatePicker datepick1=new DatePicker(LocalDate.now());
    }
}
