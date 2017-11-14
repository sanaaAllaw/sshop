package stock;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
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
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class products extends Application {
    TableView<Item> tab1=new TableView<>();
    static String staticItem;
    double tab1width=500;
    Stage editStage=new Stage(StageStyle.DECORATED);
    Stage histStage=new Stage(StageStyle.DECORATED);
    static final ObservableList<Item> data1 =
            FXCollections.observableArrayList();
    VBox box=new VBox();
    
    GridPane gridtitle=new GridPane();
    Label search=new Label("Search");
    TextField sear_txt=new TextField();
    @Override
    public void start(Stage primaryStage) throws SQLException {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        Label titleLabel=new Label("Stock Card");
        gridtitle.add(titleLabel, 1, 5);
        gridtitle.setAlignment(Pos.CENTER);
        titleLabel.setId("titles");
        titleLabel.setAlignment(Pos.CENTER);
        final LineChart<String,Number> lineChart =
                new LineChart<>(xAxis,yAxis);
        
        lineChart.setTitle("Items Stock");
        //defining a series
        
        xAxis.setLabel("Date");
        
        
        lineChart.setTitle("Stock Items");
        
       
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Sales");
        lineChart.getData().addAll(series3); 
        selectItemsFromTable();
        box.getChildren().addAll(sear_txt,tab1);
        
        BorderPane root = new BorderPane();
        root.setTop(gridtitle);
        root.setLeft(box);
        root.setRight(lineChart);
        Scene scene = new Scene(root, 300, 250);
        String css =this.getClass().getResource("items.css").toExternalForm();
        scene.getStylesheets().add(css);
        TableColumn st1 = new TableColumn("Item Name");
        st1.setPrefWidth(tab1width/3);
        st1.setCellValueFactory(
                new PropertyValueFactory<>("ItemName"));
        TableColumn st2 = new TableColumn("Price");
        st2.setPrefWidth(tab1width/3);
        st2.setCellValueFactory(
                new PropertyValueFactory<>("Price"));
        TableColumn st3 = new TableColumn("Qty");
        st3.setPrefWidth(tab1width/3);
        st3.setCellValueFactory(
                new PropertyValueFactory<>("Qty"));
        TableColumn st4 = new TableColumn("Barcode");
        st4.setPrefWidth(tab1width/3);
        st4.setCellValueFactory(
                new PropertyValueFactory<>("description"));
         TableColumn st5 = new TableColumn("Item Code");
        st5.setPrefWidth(tab1width/3);
        st5.setCellValueFactory(
                new PropertyValueFactory<>("ItemCode"));
        tab1.setItems(data1);
        tab1.getColumns().addAll(st1,st2,st3,st4);
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        box.setPrefWidth(primaryScreenBounds.getWidth()/2);
        box.setPrefHeight(primaryScreenBounds.getHeight());
        tab1.setPrefHeight(primaryScreenBounds.getHeight());
        tab1.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                Item item = tab1.getSelectionModel().getSelectedItem();
                staticItem=(item.getItemName());
            Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        
        String selectSQL = "SELECT sum(qty),date,price FROM transaction where item_name=? group by date";
        
        try {
            dbConnection = connection.getDBConnection();
            preparedStatement = dbConnection.prepareStatement(selectSQL);
            preparedStatement.setString(1,staticItem);
            ResultSet rs = preparedStatement.executeQuery();
            series3.getData().clear();
            while (rs.next()) {
              series3.getData().add(new XYChart.Data(rs.getString("date"), rs.getInt(1)));
            }
             //data of table view
        
        }
            
            
        catch (SQLException e) {
            
            System.out.println(e.getMessage());
           
        } finally {
            
          
            
        }
             
       
        
        
            }
        });
        tab1.setRowFactory((TableView<Item> tableView) -> {
            final TableRow<Item> row = new TableRow<>();
            final ContextMenu contextMenu = new ContextMenu();
            final MenuItem editItem = new MenuItem("Edit item");
            final MenuItem ItemHistory = new MenuItem("View Item History");
            editItem.setOnAction((ActionEvent event) -> {
                Item item = tab1.getSelectionModel().getSelectedItem();
                staticItem=(item.getItemName());
                EditItems editN=new EditItems();
                try {
                    editN.start(editStage);
                } catch (SQLException ex) {
                    Logger.getLogger(addItems.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            });
            ItemHistory.setOnAction((ActionEvent event) -> {
                Item item = tab1.getSelectionModel().getSelectedItem();
                staticItem=(item.getItemCode());
                transactions transN=new transactions();
                try {
                    transN.start(histStage);
                } catch (SQLException ex) {
                    Logger.getLogger(addItems.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            });
            contextMenu.getItems().addAll(editItem,ItemHistory);
            // Set context menu on row, but use a binding to make it only show for non-empty rows:
            row.contextMenuProperty().bind(
                    Bindings.when(row.emptyProperty())
                            .then((ContextMenu)null)
                            .otherwise(contextMenu)
            );
            return row ;
        });
        /*sear_txt.addEventFilter(KeyEvent.KEY_TYPED, (KeyEvent event) -> {
        data1.clear();
        try {
        selectItemsBFromTable(sear_txt.getText());
        } catch (SQLException ex) {
        Logger.getLogger(addItems.class.getName()).log(Level.SEVERE, null, ex);
        }
        });*/
        sear_txt.textProperty().addListener((javafx.beans.Observable observable) -> {
            if(sear_txt.textProperty().get().isEmpty()) {
                tab1.setItems(data1);
                return;
            }
            ObservableList<Item> tableItems = FXCollections.observableArrayList();
            ObservableList<TableColumn<Item, ?>> cols = tab1.getColumns();
            for (Item data11 : data1) {
                for (TableColumn<Item, ?> col1 : cols) {
                    TableColumn col = col1;
                    String cellValue = col.getCellData(data11).toString();
                    cellValue = cellValue.toLowerCase();
                    if (cellValue.contains(sear_txt.textProperty().get().toLowerCase())) {
                        tableItems.add(data11);
                        break;
                    }
                }
            }
            tab1.setItems(tableItems);
        });
        primaryStage.setX(primaryScreenBounds.getMinX());
        primaryStage.setY(primaryScreenBounds.getMinY());
        primaryStage.setWidth(primaryScreenBounds.getWidth());
        primaryStage.setHeight(primaryScreenBounds.getHeight());
        primaryStage.setMaximized(true);
        Image ico = new Image("images/stockIcon.png");
        primaryStage.getIcons().add(ico);
        primaryStage.setTitle("Home");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public static class Item {
        private final SimpleStringProperty ItemCode;
        private final SimpleStringProperty ItemName;
        private final SimpleDoubleProperty Price;
        private final SimpleIntegerProperty Qty;
        private final SimpleStringProperty Description;
        private final SimpleStringProperty Reste;
        Item(String Itemnamevar,double Pricevar,int Qtyvar,String Desc,String RestVar,String ItemCode){
            this.ItemName = new SimpleStringProperty(Itemnamevar);
            this.Price = new SimpleDoubleProperty(Pricevar);
            this.Qty = new SimpleIntegerProperty(Qtyvar);
            this.Description = new SimpleStringProperty(Desc);
            this.Reste = new SimpleStringProperty(RestVar);
            this.ItemCode=new SimpleStringProperty(ItemCode);
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
          public String getItemCode() {
            return ItemCode.get();
        }
        
        public void setItemCode(String ItemCodeV) {
            ItemCode.set(ItemCodeV);
        }
    }
    static void selectItemsFromTable() throws SQLException {
        
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        
        String selectSQL = "SELECT * FROM items ";
        
        try {
            dbConnection = connection.getDBConnection();
            preparedStatement = dbConnection.prepareStatement(selectSQL);
            
            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                String itemName=rs.getString("name");
                double price=rs.getDouble("price");
                int qty=rs.getInt("qty");
                String barcode=rs.getString("barcode");
                String itemcodevar=rs.getString("itemcode");
                data1.add(new Item(itemName, price, qty, barcode, "",itemcodevar));
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
    void selectItemsBFromTable(String S) throws SQLException {
        
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        
        String selectSQL = "SELECT * FROM items WHERE barcode like ? or name like ?";
        
        try {
            dbConnection = connection.getDBConnection();
            preparedStatement = dbConnection.prepareStatement(selectSQL);
            preparedStatement.setString(1, "%"+S+"%");
            preparedStatement.setString(2, "%"+S+"%");
            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String itemName=rs.getString("name");
                double price=rs.getDouble("price");
                int qty=rs.getInt("qty");
                 String itemcodevar=rs.getString("itemcode");
                data1.add(new Item(itemName, price, qty, "", "",itemcodevar));
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
}
