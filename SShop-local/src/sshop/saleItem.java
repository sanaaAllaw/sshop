/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sshop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import report.report;


//declared class sales item/
//class public include all functions and other classes
public class saleItem extends Application {
    public static int invoicenumber;
    double TotalPrice1;// Sum of all prices
    int itemqty1;//quantity selected from database
    TextField barItem=new TextField();
    TextField text1;
    TextField text2;
    TextField text3;
    TextField text4;
    private final TableView<items> table = new TableView<>();
     public  static ObservableList<items> data =
            FXCollections.observableArrayList(); //data to get item from class item 
    Pane panel1=new Pane();
    Label Total=new Label("Total (L.L)");
    Label TotalPrice=new Label("0.0");
    Label invNum=new Label();
     Label curr=new Label("L.L");
    int itemqty;
    @Override
    public void start(Stage primaryStage) {
        Connection dbConnection = null;
        dbConnection = JDBCMysql.connectmysql();
        
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();// width and height of screen
        Total.setId("total");
        VBox vbox1=new VBox();
        HBox hbox1=new HBox();
        hbox1.setPrefHeight(50);
        HBox hbox2=new HBox();
        hbox2.setPrefHeight(50);
        hbox1.setStyle("-fx-background-color:gray");
        hbox1.setSpacing(200);
        TotalPrice.setId("total");
        hbox1.getChildren().add(Total);
        hbox1.getChildren().add(TotalPrice);
        hbox1.getChildren().add(invNum);
        Stage printerStage1=new Stage(StageStyle.DECORATED);
        Label l1=new Label("Extra sales");
        Label l2=new Label("Extra item");
        Label l3=new Label("Extra price");
        Label l4=new Label("Extra qty");
        Label l5=new Label("Extra Description");
        try {
            invNum.setText(getInvNum());
        } catch (SQLException ex) {
            Logger.getLogger(saleItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        text1=new TextField();
        // enable textfield to accept only numbers
        text2=new TextField(){
            @Override public void replaceText(int start, int end, String text) {
                if (text.matches("[0-9]*")) {
                    super.replaceText(start, end, text);
                }
            }
            
            @Override public void replaceSelection(String text) {
                if (text.matches("[0-9]*")) {
                    super.replaceSelection(text);
                }
            }
        };
        text3=new TextField(){
            @Override public void replaceText(int start, int end, String text) {
                if (text.matches("[0-9]*")) {
                    super.replaceText(start, end, text);
                }
            }
            
            @Override public void replaceSelection(String text) {
                if (text.matches("[0-9]*")) {
                    super.replaceSelection(text);
                }
            }
        };
        text4=new TextField();
        text1.setPrefSize(200, 30);
        text2.setPrefSize(200, 30);
        text3.setPrefSize(200, 30);
        text4.setPrefSize(200, 30);
        Button btn2=new Button("Add extra item");
        btn2.setPrefWidth(200);
        Button btn3=new Button("Generate Invoice");
        btn3.setOnAction((event)->{
            invoicenumber=Integer.parseInt(invNum.getText());
           Connection connection = null;
        Statement statement = null;
        try {
            connection = JDBCMysql.connectmysql();
            statement = connection.createStatement();
            HashMap parameterMap = new HashMap();
            parameterMap.put("rtitle", "Report Title Here");//sending the report title as a parameter.
            report rpt = new report(parameterMap, connection);
            rpt.setReportName("productlist"); //productlist is the name of my jasper file.
            rpt.callReport();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        });
        btn3.setPrefWidth(200);
        GridPane grid1=new GridPane();
        grid1.setVgap(10);
        grid1.setHgap(10);
        grid1.add(l1, 0, 0);
        grid1.add(l2, 1, 1);
        grid1.add(l3, 3, 1);
        grid1.add(l4, 5, 1);
        grid1.add(l5, 7, 1);
        grid1.add(text1, 2, 1);
        grid1.add(text2, 4, 1);
        grid1.add(text3, 6, 1);
        grid1.add(text4, 8, 1);
        grid1.add(btn2, 4, 2);
        grid1.add(btn3, 6, 2);
        // add extra items to tableview and data
        btn2.setOnAction((event) -> {
            if(checkrequiredField()==false){
                String extraname=text1.getText();
                String extradesc=text4.getText();
                double extraprice=Double.valueOf(text2.getText());
                int extraqty=Integer.parseInt(text3.getText());
                data.add(new items(extraname,extraprice,extraqty,extradesc,"Extra items"));
                TotalPrice1=TotalPrice1+(extraprice*extraqty);
                   TotalPrice.setText(String.valueOf(TotalPrice1));
                try {
                    insertIntoextra(extraname, extraqty, extraprice, extradesc, getDate());//instert data to extra table
                } catch (SQLException ex) {
                    Logger.getLogger(saleItem.class.getName()).log(Level.SEVERE, null, ex);
                }
                barItem.clear();
                clearFields();
            }
        });
        hbox2.getChildren().add(grid1);
        //Adding the Button to the cell
        
        table.setPrefWidth(Constantes.primScreenBounds.getWidth()-200-10);
        table.setPrefHeight(primaryScreenBounds.getHeight()/1.5);
        table.setRowFactory((TableView<items> tableView) -> {//right click remove row
            final TableRow<items> row = new TableRow<>();
            final ContextMenu contextMenu = new ContextMenu();
            final MenuItem removeMenuItem = new MenuItem("Remove item");
            removeMenuItem.setOnAction((ActionEvent event) -> {
            items item = table.getSelectionModel().getSelectedItem();         
                table.getItems().remove(row.getItem());
                if("Extra items".equals(item.getReste())){
                try {
                    deletFromextra(item.getItemName());//delete data from extra table 
                    TotalPrice1=TotalPrice1-(item.getPrice()*item.getQty());
                    TotalPrice.setText(String.valueOf(TotalPrice1));
                } catch (SQLException ex) {
                    Logger.getLogger(saleItem.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                else{
                try {
                    deletFromtrans(item.getItemName(), itemqty1+1);//delete data from transaction table
                    TotalPrice1=TotalPrice1-item.getPrice();
                    TotalPrice.setText(String.valueOf(TotalPrice1));
                   updatetotable(item.getItemName());
                } catch (SQLException ex) {
                    Logger.getLogger(saleItem.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                barItem.requestFocus();
            });
            contextMenu.getItems().add(removeMenuItem);
            // Set context menu on row, but use a binding to make it only show for non-empty rows:
            row.contextMenuProperty().bind(
                    Bindings.when(row.emptyProperty())
                            .then((ContextMenu)null)
                            .otherwise(contextMenu)
            );
            return row ;
        });  
        //set tablecolumn names to accept data values
        TableColumn Itemnamecol=new TableColumn("Item Name");
        Itemnamecol.setPrefWidth(300);
        Itemnamecol.setCellValueFactory(
                new PropertyValueFactory<>("ItemName"));
        TableColumn descripCol=new TableColumn("Description");
        descripCol.setPrefWidth(500);
        descripCol.setCellValueFactory(
                new PropertyValueFactory<>("Description"));
        TableColumn PriceCol=new TableColumn("Price");
        PriceCol.setPrefWidth(100);
        PriceCol.setCellValueFactory(
                new PropertyValueFactory<>("Price"));
        
        
        TableColumn QtyCol=new TableColumn("Qty");
        QtyCol.setPrefWidth(100);
        QtyCol.setCellValueFactory(
                new PropertyValueFactory<>("Qty"));
        TableColumn QtyResCol=new TableColumn("Qty Reste");
        QtyResCol.setPrefWidth(100);
        QtyResCol.setCellValueFactory(
                new PropertyValueFactory<>("Reste"));
        
        table.setItems(data);
        table.getColumns().addAll(Itemnamecol,descripCol,PriceCol,QtyCol,QtyResCol);
        BorderPane root = new BorderPane();
        
        //baritem textfield action slecte data by barr code or item name
        barItem.setOnAction((event) -> {
            
            try {
                selectRecordsFromTable(barItem.getText());
            } catch (SQLException ex) {
                Logger.getLogger(saleItem.class.getName()).log(Level.SEVERE, null, ex);
            }
            barItem.clear();
        });
        vbox1.getChildren().add(barItem);
        barItem.setPrefWidth(primaryScreenBounds.getWidth());
        barItem.setPrefHeight(primaryScreenBounds.getWidth()/30);
        barItem.setPromptText("enter item or barcode here");
        vbox1.getChildren().add(table);
        vbox1.getChildren().add(hbox1);
        vbox1.getChildren().add(hbox2);
        root.setTop(vbox1);
        Scene scene = new Scene(root, Constantes.primScreenBounds.getWidth()-200-10,
                7000);
        
        String css =this.getClass().getResource("/css/items.css").toExternalForm();
        scene.getStylesheets().add(css);
        
       // primaryStage.setX(primaryScreenBounds.getMinX());
        //primaryStage.setY(primaryScreenBounds.getMinY());
        //primaryStage.setWidth(primaryScreenBounds.getWidth());
        //primaryStage.setHeight(primaryScreenBounds.getHeight());
        primaryStage.setX(200+10);
        primaryStage.setY(0);
        //Image ico = new Image("images/Add-item-icon.png");
       // primaryStage.getIcons().add(ico);
        primaryStage.setTitle("sale items");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
        
    }
    // class items, requierd all variable for items needed to append data and tableview
    public static class items {
        private final SimpleStringProperty ItemName;
        private final SimpleDoubleProperty Price;
        private final SimpleIntegerProperty Qty;
        private final SimpleStringProperty Description;
        private final SimpleStringProperty Reste;
        private items(String Itemnamevar,double Pricevar,int Qtyvar,String Desc,String RestVar){
            this.ItemName = new SimpleStringProperty(Itemnamevar);
            this.Price = new SimpleDoubleProperty(Pricevar);
            this.Qty = new SimpleIntegerProperty(Qtyvar);
            this.Description = new SimpleStringProperty(Desc);
            this.Reste = new SimpleStringProperty(RestVar);
        }
        public String getItemName() {
            return ItemName.get();
        }
        
        public void setItemName(String itemName) {
            ItemName.set(itemName);
        }
        public String getDescription() {
            return Description.get();
        }
        
        public void setDescription(String itemDesc) {
            Description.set(itemDesc);
        }
        public double getPrice() {
            return Price.get();
        }
        
        public void setPrice(double itemprice) {
            Price.set(itemprice);
        }
        public int getQty() {
            return Qty.get();
        }
        
        public void setQty(int itemqty) {
            Qty.set(itemqty);
        }
        public String getReste() {
            return Reste.get();
        }
        
        public void setReste(String ResV) {
            Reste.set(ResV);
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    void selectRecordsFromTable(String S) throws SQLException {
        
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        
        String selectSQL = "SELECT * FROM items WHERE item_barcode = ? or item_name = ?";
        
        try {
            dbConnection = JDBCMysql.connectmysql();
            preparedStatement = dbConnection.prepareStatement(selectSQL);
            preparedStatement.setString(1, S);
            preparedStatement.setString(2, S);
            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();
            String result = null;
            int fond;
            if (rs.next()) {
                int itemqty1=rs.getInt("item_qty");
                fond=3;
                itemqty=itemqty1-1;
                if(itemqty1<fond && itemqty1>0){
                    result=itemqty+" low than "+fond+" items";
                    String itemname = rs.getString("item_name");
                    String desc = rs.getString("item_name");
                    double price = rs.getDouble("item_orig_price");
                    data.add(new items(itemname, price, 1, desc,result));
                    insertIntoTransaction(itemname,1,price,getDate(),"");
                     TotalPrice1=TotalPrice1+price;
                   TotalPrice.setText(String.valueOf(TotalPrice1));
                    updatetotable(itemname);
                }
                
                else if(itemqty1==0){
                    
                    result=itemqty1+" no items qty available";
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Message");
                    alert.setHeaderText(result);
                    alert.setContentText(result);
                    
                    alert.showAndWait();
                }
                else{
                    String itemname = rs.getString("item_name");
                    String desc = rs.getString("item_name");
                    double price = rs.getDouble("item_orig_price");
                    result=itemqty+" qty available";
                    
                    data.add(new items(itemname, price, 1, desc,result));
                    insertIntoTransaction(itemname,1,price,getDate(),"");
                    TotalPrice1=TotalPrice1+price;
                     TotalPrice.setText(String.valueOf(TotalPrice1));
                    updatetotable(barItem.getText());
                }
                
                
                
            }
            else{
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText("Item not found");
                alert.setContentText("Item not found");
                
                alert.showAndWait();
            }
            
        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
            
        } finally {
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            
            if (dbConnection != null) {
                dbConnection.close();
            }
            
        }
        
    }
     public String getDate(){
         DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
Date date = new Date();

        return dateFormat.format(date);
     }
    private void clearFields() {
        text1.setText("");
        text2.setText("");
        text3.setText("");
        text4.setText("");
        text1.setStyle("-fx-border-color: white ; -fx-border-width: 2px ;");
        
        text2.setStyle("-fx-border-color: white ; -fx-border-width: 2px ;");
        
        text3.setStyle("-fx-border-color: white ; -fx-border-width: 2px ;");
        
        text4.setStyle("-fx-border-color: white ; -fx-border-width: 2px ;");
        
    }
    
    private boolean checkrequiredField(){
        if("".equals(text1.getText())){
            text1.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
            text1.requestFocus();
            return true;
        }
        else if("".equals(text2.getText())){
            text2.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
            text2.requestFocus();
            return true;
        }
        else if("".equals(text3.getText())){
            text3.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
            text3.requestFocus();
            return true;
        }
        
        else{
            return false;
        }
    }
    
    
  
  
    void insertIntoTransaction(String itemname,int qty,double price,String date,String time) throws SQLException{
     Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        
        String selectSQL = "INSERT INTO `transaction`(`item_name`, `qty`, `price`, `date`, `time`, `invoiceNum`)"
                + " VALUES (?,?,?,?,?,?)";
        
        try {
            dbConnection = JDBCMysql.connectmysql();
            preparedStatement = dbConnection.prepareStatement(selectSQL);
            preparedStatement.setString(1, itemname);
            preparedStatement.setInt(2, qty);
            preparedStatement.setDouble(3, price);
              preparedStatement.setString(4, date);
            preparedStatement.setString(5, time);
             preparedStatement.setString(6, invNum.getText());
            // execute select SQL stetement
            int rs = preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
            
        } finally {
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            
            if (dbConnection != null) {
                dbConnection.close();
            }
            
        }
        
    }
    void insertIntoextra(String itemname,int qty,double price,String desc,String date) throws SQLException{
     Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        
        String selectSQL = "INSERT INTO `extra`(`item_name`, `qty`, `price`, `description`, `date`,`invoiceNum`) VALUES"
                + "(?,?,?,?,?,?)";
        
        try {
            dbConnection = JDBCMysql.connectmysql();
            preparedStatement = dbConnection.prepareStatement(selectSQL);
            preparedStatement.setString(1, itemname);
            preparedStatement.setInt(2, qty);
            preparedStatement.setDouble(3, price);
              preparedStatement.setString(4, desc);
            preparedStatement.setString(5, date);
            preparedStatement.setString(6, invNum.getText());
            // execute select SQL stetement
            int rs = preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
            
        } finally {
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            
            if (dbConnection != null) {
                dbConnection.close();
            }
            
        }
        
    }
    //modify to table item (qty)
    void updatetotable(String S) throws SQLException {
        
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        
        String selectSQL = "update  items set item_qty = ? where item_barcode = ? or item_name = ?";
        
        try {
            dbConnection = JDBCMysql.connectmysql();
            preparedStatement = dbConnection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, itemqty);
            preparedStatement.setString(2, S);
            preparedStatement.setString(3, S);
            // execute select SQL stetement
            int rs = preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
            
        } finally {
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            
            if (dbConnection != null) {
                dbConnection.close();
            }
            
        }
        
    }
    //delete from transaction table  if i make remove item
  void deletFromtrans(String S,int qtyValue) throws SQLException {
        
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
         PreparedStatement preparedStatement1 = null;
        String selectSQL = "delete from transaction where item_name = ?";
         String selectSQL1 = "update  items set item_qty = item_qty+? where item_barcode = ? or item_name = ?";
        try {
            dbConnection = JDBCMysql.connectmysql();
            preparedStatement = dbConnection.prepareStatement(selectSQL);
             preparedStatement1 = dbConnection.prepareStatement(selectSQL1);
            preparedStatement.setString(1, S);
            preparedStatement1.setInt(1, qtyValue);
            preparedStatement1.setString(2, S);
            preparedStatement1.setString(3, S);
            // execute select SQL stetement
            int rs = preparedStatement.executeUpdate();
            int rs1 = preparedStatement1.executeUpdate();
            
            
        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
            
        } finally {
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            
            if (dbConnection != null) {
                dbConnection.close();
            }
            
        }
        
    }  
  
   //delete from extra  table  if i make remove item
  void deletFromextra(String S) throws SQLException {
        
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        
        String selectSQL = "delete from extra where item_name = ?";
        
        try {
            dbConnection = JDBCMysql.connectmysql();
            preparedStatement = dbConnection.prepareStatement(selectSQL);
            
            preparedStatement.setString(1, S);
            // execute select SQL stetement
            int rs = preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
            
        } finally {
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            
            if (dbConnection != null) {
                dbConnection.close();
            }
            
        }
        
    }
  
   void checkItemQty(String S) throws SQLException {
        
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        
        String selectSQL = "SELECT * FROM items WHERE item_barcode = ? or item_name = ?";
        
        try {
            dbConnection =JDBCMysql.connectmysql();
            preparedStatement = dbConnection.prepareStatement(selectSQL);
            preparedStatement.setString(1, S);
            preparedStatement.setString(2, S);
            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();
            String result = null;
            int fond;
            if (rs.next()) {
                 itemqty1=rs.getInt("item_qty");
                
          
            }
            else{
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText("Item not found");
                alert.setContentText("Item not found");
                
                alert.showAndWait();
            }
            
        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
            
        } finally {
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            
            if (dbConnection != null) {
                dbConnection.close();
            }
            
        }
        
    }
   String getInvNum() throws SQLException {
        
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        
        String selectSQL = "SELECT COUNT(*) FROM transaction";
        
        try {
            dbConnection = JDBCMysql.connectmysql();
            preparedStatement = dbConnection.prepareStatement(selectSQL);
           
            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();
            String result = null;
            int fond;
            if (rs.next()) {
                 return rs.getString(1);
                
          
            }
           
            
        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
            
        } finally {
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            
            if (dbConnection != null) {
                dbConnection.close();
            }
            
        }
        return null;
        
    }
}
