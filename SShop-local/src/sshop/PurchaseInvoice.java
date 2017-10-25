/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sshop;

import java.time.LocalDate;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author skynete
 */
public class PurchaseInvoice extends Application {
    private final TableView<Purchase> table = new TableView<>();
    @Override
    public void start(Stage primaryStage) {
        HBox h1=new HBox();
        GridPane grid1=new GridPane();
        grid1.setVgap(10);grid1.setHgap(10);
        Label PurchaseNo=new Label("Purchase No.");
        TextField purchNotxt=new TextField();
        TextField supptxt=new TextField();
        supptxt.setPromptText("Supplier Account");
        TextField supptxtname=new TextField();
        supptxtname.setPrefWidth(200);
        supptxtname.setDisable(true);
        Label datelbl=new Label("Date");
        DatePicker datepick1=new DatePicker(LocalDate.now());
        Label whlbl=new Label("WhareHouse");
        TextField whtxt=new TextField();
        grid1.add(PurchaseNo, 1, 1);grid1.add(purchNotxt, 2, 1);
        grid1.add(supptxt, 1, 2);grid1.add(supptxtname, 2, 2);
        grid1.add(datelbl, 3, 2);grid1.add(datepick1, 4, 2);grid1.add(whlbl, 5, 2);
        
        TableColumn purcode_col = new TableColumn("Purchase No");
        purcode_col.setMinWidth(100);
        purcode_col.setCellValueFactory(
                new PropertyValueFactory<>("pivno"));
        
        TableColumn supp_Code_col = new TableColumn("Supplier Code");
        supp_Code_col.setMinWidth(100);
        supp_Code_col.setCellValueFactory(
                new PropertyValueFactory<>("suppcode"));
        
        TableColumn Date_col = new TableColumn("Date");
        Date_col.setMinWidth(200);
        Date_col.setCellValueFactory(
                new PropertyValueFactory<>("date"));
        
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
        h1.getChildren().add(grid1);
        
        BorderPane root = new BorderPane();
        root.setCenter(h1);
        
        Scene scene = new Scene(root, 800, 500);
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
        
        private purchase(String pivno, String suppcode, String date, 
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
}
